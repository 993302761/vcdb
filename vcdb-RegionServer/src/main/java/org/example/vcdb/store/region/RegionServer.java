package org.example.vcdb.store.region;

import com.google.protobuf.Empty;
import com.sun.jdi.ShortType;
import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.file.VCFIleWriter;
import org.example.vcdb.store.file.VCFileReader;
import org.example.vcdb.store.mem.KV;
import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.store.mem.MemStore;
import org.example.vcdb.store.proto.Meta;
import org.example.vcdb.store.proto.getRegionMetaGrpc;
import org.example.vcdb.store.region.Region.RegionMeta;
import org.example.vcdb.store.region.Region.VCRegion;
import org.example.vcdb.store.region.fileStore.ColumnFamilyMeta;
import org.example.vcdb.store.region.fileStore.FileStore;
import org.example.vcdb.store.region.fileStore.FileStoreMeta;
import org.example.vcdb.store.region.fileStore.KVRange;
import org.example.vcdb.util.Bytes;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import static org.example.vcdb.store.mem.KV.byteToType;
import static org.example.vcdb.store.region.fileStore.ColumnFamilyMeta.byteToCFType;
import static org.example.vcdb.store.region.fileStore.FileStore.*;

public class RegionServer extends getRegionMetaGrpc.getRegionMetaImplBase {
    //cache for fileStores
    //负责接收sql请求的KV
    static Map<String,MemStore> inboundMemStore;

    //负责接收从文件加载过来的的KV
    static Map<String,MemStore> outboundMemStore;

    static RegionServerMeta regionServerMeta;

    //cache for region
    List<VCRegion> loadOnRegion;

    public static void readConfig(String fileName) {
        regionServerMeta = new RegionServerMeta(VCFileReader.readAll(fileName));
    }

    public RegionServer(String fileName) {
        regionServerMeta = new RegionServerMeta(VCFileReader.readAll(fileName));
        inboundMemStore=new ConcurrentHashMap<>();
    }

    public RegionServer() {

    }



    /*table:cfName-----fileStoreMeta------fileStore*/
    /*createDB:createDB*/
    /*Transaction:Transaction*/
    /*Table:Table*/
    //用dbName当做rowKey
    public static boolean createDBService(String dbName){
        try {
            commonSet(dbName,"DB","DB",(byte) 0);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public static boolean createTable(String dbName,String tabName,byte[] requestEntity){
        try {
            commonSet(dbName+"."+tabName,"Table","Table",(byte) 4);
            int pos=0;
            int count=Bytes.toInt(requestEntity,pos,4);
            pos+=4;

            for (int i = 0; i < count; i++) {
                int cfNameLength=Bytes.toInt(requestEntity,pos,4);
                pos+=4;
                String cfName=Bytes.toString(requestEntity,pos,cfNameLength);
                pos+=cfNameLength;
                byte type=requestEntity[pos];
                pos+=1;
                long min=Bytes.toLong(requestEntity,pos,8);
                pos+=8;
                long max=Bytes.toLong(requestEntity,pos,8);
                pos+=8;
                boolean unique=requestEntity[pos]==1;
                pos+=1;
                boolean isNil=requestEntity[pos]==1;
                pos+=1;

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                String fileName=sdf.format(new Date());
                String regionMetaFileName="region/"+fileName;
                String fileStoreName="fileStore/"+fileName;
                String fileStoreMetaName="fileStoreMeta/"+fileName;

                /*createTable*/
                /*注册该表到RegionServerMeta*/
                /*先读出RegionServerMeta*/
                RegionServerMeta serverMeta = new RegionServerMeta(VCFileReader.readAll("regionServerMeta"));
                Map<String, String> regionMap = serverMeta.getRegionMap();

                /*应该查重*/
                regionMap.put(dbName +"."+tabName,regionMetaFileName);

                /*替换新map*/
                serverMeta.setRegionMap(regionMap);

                /*写入文件*/
                VCFIleWriter.writeAll(serverMeta.getData(), "regionServerMeta");

                /*创建regionMetaMap*/
                Map<String, String> fileStoreMap = new ConcurrentHashMap<>();
                fileStoreMap.put(cfName, fileStoreMetaName);
                RegionMeta regionMeta = new RegionMeta(regionMetaFileName, fileStoreMap);
                VCFIleWriter.writeAll(regionMeta.getData(), regionMetaFileName);

                /*创建fileStoreMeta*/
                FileStoreMeta fileStoreMeta = new FileStoreMeta((new Date()).getTime(), false,
                        fileStoreName, "".getBytes(), "".getBytes());
                VCFIleWriter.writeAll(fileStoreMeta.getData(), fileStoreMetaName);

                /*创建fileStore*/
                ColumnFamilyMeta cfMeta = new ColumnFamilyMeta(unique,isNil,min,max,byteToCFType(type));
                FileStore fileStore=new FileStore(cfMeta);
                VCFIleWriter.writeAll(fileStore.getData(), fileStoreName);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteDB(String dbName){
        try {
            commonSet(dbName,"DB","DB",(byte) 8);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteTable(String tabName){
        try {
            commonSet(tabName,"Table","Table",(byte) 10);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean openTransaction(String explainValue){
        try {
            commonSet(explainValue,"Transaction","Transaction",(byte) 12);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean closeTransaction(String explainValue){
        try {
            commonSet(explainValue,"Transaction","Transaction",(byte) 14);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public int putCells(String dbName,String tabName,String rowKey,byte[] requestEntity){
        int pos=0;
        int count=Bytes.toInt(requestEntity,pos,4);
        pos+=4;
        for (int i = 0; i < count; i++) {
            int cfNameLength=Bytes.toInt(requestEntity,pos,4);
            pos+=4;
            String cfName=Bytes.toString(requestEntity,pos,cfNameLength);
            pos+=cfNameLength;

            int cnameLength=Bytes.toInt(requestEntity,pos,4);
            pos+=4;
            String cname=Bytes.toString(requestEntity,pos,cfNameLength);
            pos+=cnameLength;

            int valueLength=Bytes.toInt(requestEntity,pos,4);
            pos+=4;
            String value=Bytes.toString(requestEntity,pos,cfNameLength);
            pos+=valueLength;

            /*添加KV到memStore*/
            MemStore memStore = inboundMemStore.get(dbName+"."+tabName+ ":" +cfName);
            KV kv = memStore.kvSet.get(rowKey);
            if (kv==null){
                kv=new KV(rowKey.getBytes(),0,rowKey.getBytes().length,null);
            }
            List<KV.ValueNode> values = kv.getValues();
            KV.ValueNode valueNode=new KV.ValueNode(new Date().getTime(),byteToType((byte) 10),
                    cname.getBytes(),cnameLength,0,
                    value.getBytes(),valueLength,0);
            values.add(valueNode);
            kv=new KV(rowKey.getBytes(),0,rowKey.getBytes().length,values);
            memStore.kvSet.add(kv);
        }
        return count;
    }


    //有问题功能局限，应该可以修改，columnFamilyMeta
    /*修改列族名字---table：cf--->fileStoreMeta*/
    public static boolean alterTable(String dBName,String tabName,byte[] requestEntity){
        try {
            int pos=0;
            int count=Bytes.toInt(requestEntity,pos,4);
            pos+=4;
            for (int i = 0; i < count; i++) {
                int cfNameLength=Bytes.toInt(requestEntity,pos,4);
                pos+=4;
                String cfName=Bytes.toString(requestEntity,pos,cfNameLength);
                pos+=cfNameLength;

                int old_cfNameLength=Bytes.toInt(requestEntity,pos,4);
                pos+=4;
                String old_cfName=Bytes.toString(requestEntity,pos,cfNameLength);
                pos+=old_cfNameLength;

                int methodLength=Bytes.toInt(requestEntity,pos,4);
                pos+=4;
                String method=Bytes.toString(requestEntity,pos,cfNameLength);
                pos+=methodLength;
                RegionMeta regionMeta = RegionServer.getRegionMeta(dBName+"."+tabName);
                Map<String, String> fileStoreMap = regionMeta.getFileStoreMap();
                if ("put".equalsIgnoreCase(method)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                    String fileName=sdf.format(new Date());
                    String fileStoreName="fileStore/"+fileName;
                    String fileStoreMetaName="fileStoreMeta/"+fileName;
                    /*创建fileStoreMeta*/
                    FileStoreMeta fileStoreMeta = new FileStoreMeta((new Date()).getTime(), false,
                            fileStoreName, "".getBytes(), "".getBytes());
                    VCFIleWriter.writeAll(fileStoreMeta.getData(), fileStoreMetaName);

                    /*创建fileStore*/
                    ColumnFamilyMeta cfMeta = new ColumnFamilyMeta(false,false,Long.MIN_VALUE,Long.MAX_VALUE,byteToCFType((byte) 56));
                    FileStore fileStore=new FileStore(cfMeta);
                    VCFIleWriter.writeAll(fileStore.getData(), fileStoreName);
                    fileStoreMap.put(cfName,fileStoreMetaName);
                } else if ("delete".equalsIgnoreCase(method)) {
                    String fileStoreMetaName = fileStoreMap.get(old_cfName);
                    fileStoreMap.remove(old_cfName);
                    VCFIleWriter.deleteAll(fileStoreMetaName);
                } else if ("update".equalsIgnoreCase(method)) {
                    String fileStoreMetaName = fileStoreMap.get(old_cfName);
                    fileStoreMap.remove(old_cfName);
                    fileStoreMap.put(cfName,fileStoreMetaName);
                }
                regionMeta.setFileStoreMap(fileStoreMap);
                VCFIleWriter.writeAll(regionMeta.getData(), regionMeta.getName());
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int mergeVersion(String dBName,String tabName,byte[] requestEntity){
        int pos=0;
        int count=Bytes.toInt(requestEntity,pos,4);
        pos+=4;
        for (int i = 0; i < count; i++) {
            int rowKeyLength=Bytes.toInt(requestEntity,pos,4);
            pos+=4;
            String rowKey=Bytes.toString(requestEntity,pos,rowKeyLength);
            pos+=rowKeyLength;

            int cfNameLength=Bytes.toInt(requestEntity,pos,4);
            pos+=4;
            String cfName=Bytes.toString(requestEntity,pos,cfNameLength);
            pos+=cfNameLength;

            int versionFrom=Bytes.toInt(requestEntity,pos,4);
            pos+=4;

            int versionTo=Bytes.toInt(requestEntity,pos,4);
            pos+=4;

            //找到合并的KVs在哪一页

            String fileStoreMetaName=getRegionMeta(dBName + "." + tabName).getfileStoreMetaName(cfName);
            FileStoreMeta fileStoreMeta=new FileStoreMeta(VCFileReader.readAll(fileStoreMetaName));
            int pageIndex = findPageIndex(dBName, tabName, rowKey ,cfName);

            //加载到内存进行修改
            byte[] bytes = VCFileReader.openFileStorePage(pageIndex, fileStoreMeta.getEncodedName());
            KeyValueSkipListSet kvs = byteArrayToKvs(bytes);
            KV kv = kvs.get(rowKey);
            List<KV.ValueNode> values = kv.getValues();
            //看是否存在versionTo和versionFrom的valueNode
//            values.get(versionFrom);
//            values.get(versionTo);
            int vCount=versionTo-versionFrom;
            if (vCount-1>0){
                for (int j = 0; j < vCount-1; j++) {
                    values.remove(versionTo+1);
                }
            }
            kv.setValues(values);
            kvs.add(kv);
            //进行落盘
            byte[] bytes1 = kvsToByteArray(kvs);
            VCFIleWriter.writeAll(bytes1,pageIndex*1024,fileStoreMeta.getEncodedName());
        }
        return  count;
    }

    private int findPageIndex(String dBName, String tabName, String rowKey, String cfName) {
        List<KVRange> pageTrailer = getPageTrailer(dBName + "." + tabName, cfName);
        for (int i = 0; i < pageTrailer.size(); i++) {
            try {
                pageTrailer.get(i + 1);
                if ((rowKey.compareTo(Bytes.toString(pageTrailer.get(i).getEndKey())) <= 0
                        && rowKey.compareTo(Bytes.toString(pageTrailer.get(i).getStartKey())) >= 0)) {
                    return i;
                }
            } catch (Exception e) {
                return i;
            }
        }
        return 0;
    }

    public  boolean  useVersion(String dBName,String tabName,String rowKey, String cfName){
        //找到修改的KVs在哪一页
        String fileStoreMetaName=getRegionMeta(dBName + "." + tabName).getfileStoreMetaName(cfName);
        FileStoreMeta fileStoreMeta=new FileStoreMeta(VCFileReader.readAll(fileStoreMetaName));
        int pageIndex = findPageIndex(dBName, tabName, rowKey ,cfName);

        //加载到内存进行修改
        byte[] bytes = VCFileReader.openFileStorePage(pageIndex, fileStoreMeta.getEncodedName());
        KeyValueSkipListSet kvs = byteArrayToKvs(bytes);
        KV kv = kvs.get(rowKey);
        List<KV.ValueNode> values = kv.getValues();

        KV.ValueNode valueNode = values.get(values.size() - 1);
        values.add(valueNode);
        kv.setValues(values);

        kvs.add(kv);
        //进行落盘
        byte[] bytes1 = kvsToByteArray(kvs);
        VCFIleWriter.writeAll(bytes1,pageIndex*1024,fileStoreMeta.getEncodedName());
        return true;
    }


    public byte[] showVersion(String dBName,String tabName,String rowKey,String cfName){
        //找到修改的KVs在哪一页
        String fileStoreMetaName=getRegionMeta(dBName + "." + tabName).getfileStoreMetaName(cfName);
        FileStoreMeta fileStoreMeta=new FileStoreMeta(VCFileReader.readAll(fileStoreMetaName));
        int pageIndex = findPageIndex(dBName, tabName, rowKey ,cfName);

        //加载到内存,找到KV,返回
        byte[] bytes = VCFileReader.openFileStorePage(pageIndex, fileStoreMeta.getEncodedName());
        KeyValueSkipListSet kvs = byteArrayToKvs(bytes);
        KV kv = kvs.get(rowKey);
        return kv.getData();
    }


    public boolean deleteVersion(String dBName,String tabName,String rowKey,String cfName,int version){
        //找到修改的KVs在哪一页
        String fileStoreMetaName=getRegionMeta(dBName + "." + tabName).getfileStoreMetaName(cfName);
        FileStoreMeta fileStoreMeta=new FileStoreMeta(VCFileReader.readAll(fileStoreMetaName));
        int pageIndex = findPageIndex(dBName, tabName, rowKey ,cfName);

        //加载到内存进行修改
        byte[] bytes = VCFileReader.openFileStorePage(pageIndex, fileStoreMeta.getEncodedName());
        KeyValueSkipListSet kvs = byteArrayToKvs(bytes);
        KV kv = kvs.get(rowKey);
        List<KV.ValueNode> values = kv.getValues();

        values.remove(version);
        kv.setValues(values);
        kvs.add(kv);
        //进行落盘
        byte[] bytes1 = kvsToByteArray(kvs);
        VCFIleWriter.writeAll(bytes1,pageIndex*1024,fileStoreMeta.getEncodedName());
        return true;
    }


    public byte[] singleSearch(String dBName,String tabName,String limit,
                               String orderCfName,boolean sort,
                               byte[] cfNames,byte[] terms){
        //加载terms
        int pos1=0;
        int termsCount=Bytes.toInt(terms,pos1,4);
        pos1+=4;
        Map<String,CFTerm> cfTermMap=new HashMap<>();
        for (int i = 0; i < termsCount; i++) {
             int cfLength=Bytes. toInt(terms,pos1);
             pos1+=4;
             String cfName=Bytes.toString(terms,pos1,cfLength);
             pos1+=cfLength;

            int cLength=Bytes. toInt(terms,pos1);
            pos1+=4;
            String cName=Bytes.toString(terms,pos1,cLength);
            pos1+=cLength;


            int maxLength=Bytes. toInt(terms,pos1);
            pos1+=4;
            String max=Bytes.toString(terms,pos1,maxLength);
            pos1+=maxLength;

            int minLength=Bytes. toInt(terms,pos1);
            pos1+=4;
            String min=Bytes.toString(terms,pos1,minLength);
            pos1+=minLength;

            int equivalenceLength=Bytes. toInt(terms,pos1);
            pos1+=4;
            String equivalence=Bytes.toString(terms,pos1,equivalenceLength);
            pos1+=equivalenceLength;


            int likeLength=Bytes. toInt(terms,pos1);
            pos1+=4;
            String like=Bytes.toString(terms,pos1,likeLength);
            pos1+=equivalenceLength;

            cfTermMap.put(cfName,new CFTerm(cfName,cName, max,equivalence,min,like));
        }

        Set<Integer> rowKeysRes=new HashSet<>();
        //结合term筛选出来rowKeys
        for (Map.Entry<String,CFTerm> entry : cfTermMap.entrySet()) {
            MemStore memStore = outboundMemStore.get(dBName + "." + tabName + ":" + entry.getKey());
            KeyValueSkipListSet kvs=new KeyValueSkipListSet(new KV.KVComparator());
            byte type=99;
            if (memStore==null){
                //从磁盘里读出来
                RegionMeta regionMeta = getRegionMeta(dBName + "." + tabName);
                String fileStoreMetaName=regionMeta.getfileStoreMetaName(entry.getKey());
                FileStoreMeta fileStoreMeta=new FileStoreMeta(VCFileReader.readAll(fileStoreMetaName));
                List<KVRange> pageTrailer = fileStoreMeta.getPageTrailer();
                FileStore fileStore =new FileStore(VCFileReader.readAll(fileStoreMeta.getEncodedName()));

                //装了一个fileStore的东西
                for (int j = 0; j < pageTrailer.size(); j++) {
                    kvs.addKVs(fileStore.getDataSet(1+j));
                }
            }
            if (memStore!=null){
                type= memStore.getType();
            }

            // 在读出来的memStore里面筛选出来rowKeys,和rowKeysRes取交集
            Set<String> rowKeys=new HashSet<>();
            for (KV kv:kvs){
                List<KV.ValueNode> values = kv.getValues();
                int size = values.size();
                KV.ValueNode valueNode = values.get(size-1);
                //结合Term筛选valueNode
                String value = valueNode.getValue();
                CFTerm term = entry.getValue();
                Object o = transferType(value, type);
                //判断cfName,cName是否是rowKey
                if (term.getCf_name().equals("rowKey")){

                } else {
                    switch (type) {
                        case 42:
                            byte byteValue = Byte.parseByte(value);
                            byte byteMax = Byte.parseByte(term.getMax());
                            byte byteMin = Byte.parseByte(term.getMin());
                            byte byteEquivalence = Byte.parseByte(term.getMin());
                            if (byteValue>=byteMin&&byteValue<=byteMax){
                                if (byteEquivalence == 32){
                                    if (byteEquivalence==byteValue){
                                        rowKeys.add(kv.getRowKey());
                                    }
                                }else {
                                    rowKeys.add(kv.getRowKey());
                                }
                            }
                            break;
                        case 44:
                            short shortValue = Short.parseShort(value);
                            short shortMax = Short.parseShort(term.getMax());
                            short shortMin = Short.parseShort(term.getMin());
                            short shortEquivalence = Short.parseShort(term.getMin());
                            if (shortValue>=shortMin&&shortValue<=shortMax){
                                if (shortEquivalence == 32){
                                    if (shortEquivalence==shortValue){
                                        rowKeys.add(kv.getRowKey());
                                    }
                                }else {
                                    rowKeys.add(kv.getRowKey());
                                }
                            }
                            break;
                        case 46:
                            int intValue = Integer.parseInt(value);
                            int intMax = Integer.parseInt(term.getMax());
                            int intMin = Integer.parseInt(term.getMin());
                            int intEquivalence = Integer.parseInt(term.getMin());
                            int intLike = Integer.parseInt(term.getLike());
                            break;
                        case 48:
                            long longValue = Long.parseLong(value);
                            long longMax = Long.parseLong(term.getMax());
                            long longMin = Long.parseLong(term.getMin());
                            long longEquivalence = Long.parseLong(term.getMin());
                            long longLike = Long.parseLong(term.getLike());
                            break;
                        case 50:
                            float floatValue = Float.parseFloat(value);
                            float floatMax = Float.parseFloat(term.getMax());
                            float floatMin = Float.parseFloat(term.getMin());
                            float floatEquivalence = Float.parseFloat(term.getMin());
                            float floatLike = Float.parseFloat(term.getLike());
                            break;
                        case 52:
                            long dateValue = Long.parseLong(value);
                            long dateMax = Long.parseLong(term.getMax());
                            long dateMin = Long.parseLong(term.getMin());
                            long dateEquivalence = Long.parseLong(term.getMin());
                            long dateLike = Long.parseLong(term.getLike());
                            break;
                        case 54:
                            char charValue = value.toCharArray()[0];
                            char charMax = term.getMax().toCharArray()[0];
                            char charMin = term.getMin().toCharArray()[0];
                            char charEquivalence = term.getMin().toCharArray()[0];
                            char charLike = term.getLike().toCharArray()[0];
                            break;
                        case 56:
                            break;
                        case 58:
                            byte[] bytesValue = value.getBytes();
                            byte[] bytesMax = term.getMax().getBytes();
                            byte[] bytesMin = term.getMin().getBytes();
                            byte[] bytesEquivalence = term.getMin().getBytes();
                            byte[] bytesLike = term.getLike().getBytes();
                        default:
                            return null;
                    }
                }
            }
        }

        //加载cfNames
        int pos2=0;
        int cfNameCount=Bytes.toInt(cfNames,pos2,4);
        pos2+=4;
        // 查memStore
        for (int i = 0; i < cfNames.length; i++) {
            int cfNameLength=Bytes.toInt(cfNames,pos2,4);
            pos2+=4;
            String cfName=Bytes.toString(cfNames,pos2,cfNameLength);
            pos2+=cfNameLength;
            MemStore memStore = outboundMemStore.get(dBName + "." + tabName + ":" + cfName);
            //装了一个fileStore的东西
            KeyValueSkipListSet kvs=new KeyValueSkipListSet(new KV.KVComparator());
            if (memStore==null){
                //从磁盘里读出来
                RegionMeta regionMeta = getRegionMeta(dBName + "." + tabName);
                String fileStoreMetaName=regionMeta.getfileStoreMetaName(cfName);
                FileStoreMeta fileStoreMeta=new FileStoreMeta(VCFileReader.readAll(fileStoreMetaName));
                List<KVRange> pageTrailer = fileStoreMeta.getPageTrailer();
                FileStore fileStore =new FileStore(VCFileReader.readAll(fileStoreMeta.getEncodedName())) ;
                for (int j = 0; j < pageTrailer.size(); j++) {
                    kvs.addKVs(fileStore.getDataSet(1+i));
                }
            }
            // 在读出来的memStore里面筛选

        }




        // 读文件，找到页号，加载到内存

        // 加载到memStore

        //返回kvs 的toByteArray

        return null;
    }


    public byte[] multiSearch(){
        //查memStore


        //读文件，找到多个页号，加载到内存


        //加载到memStore


        //返回 kvs 的 toByteArray


        return null;
    }

    public static boolean like(final String str, final String expr)

    {
        String regex = quotemeta(expr);

        regex = regex.replace("_",".").replace("%",".*?");

        Pattern p = Pattern.compile(regex,

                Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        return p.matcher(str).matches();

    }

    public static String quotemeta(String s)

    {
        if (s == null)

        {
            throw new IllegalArgumentException("String cannot be null");

        }

        int len = s.length();

        if (len == 0)

        {
            return"";

        }

        StringBuilder sb = new StringBuilder(len * 2);

        for (int i = 0; i < len; i++)

        {
            char c = s.charAt(i);
            String s1="[](){}.*+?$^|#\\";
            String s2="\\";
            for (byte b:s2.getBytes()){
                System.out.println(b);
        }
            if (s1.indexOf(c) != -1)

            {
                sb.append(s2);

            }

            sb.append(c);

        }
        return sb.toString();
    }
    public int deleteCells(){
        //添加多个kv到memStore
        //类似于putKVs


        return 11;
    }



    public int updateCells(){
        //添加多个kv到memStore
        //类似于putKVs

        return 11;
    }




    private static void commonSet(String rowKey,String fullTableName,String cfName,byte actionType){
            MemStore memStore = inboundMemStore.get(fullTableName+ ":" +cfName);
            KV kv = memStore.kvSet.get(rowKey);
            if (kv==null){
                kv=new KV(rowKey.getBytes(),0,rowKey.getBytes().length,null);
            }
            List<KV.ValueNode> values = kv.getValues();
            KV.ValueNode valueNode=new KV.ValueNode(new Date().getTime(),byteToType((byte) 10),
                    "".getBytes(),"".getBytes().length,0,
                    "".getBytes(),"".getBytes().length,0);
            values.add(valueNode);
            kv=new KV(rowKey.getBytes(),0,rowKey.getBytes().length,values);
            memStore.kvSet.add(kv);
    }





    public Object transferType(String value,byte type){
        switch (type){
            case 42:
                return Byte.parseByte(value);
            case 44:
                return Short.parseShort(value);
            case 46:
                return Integer.parseInt(value);
            case 48:
                return Long.parseLong(value);
            case 50:
                return Float.parseFloat(value);
            case 52:
                return Long.parseLong(value);
            case 54:
                return value.toCharArray()[0];
            case 56:
                return value;
            case 58:
                return value.getBytes();
            default:
                return null;
        }
    }
















    public static void addKVToMemStore(String fullCfName,KV kv){
        if (inboundMemStore.get(fullCfName)==null){
            inboundMemStore.put(fullCfName,new MemStore());
        }
        MemStore toMemStore = inboundMemStore.get(fullCfName);
        toMemStore.add(kv);
        inboundMemStore.put(fullCfName,toMemStore);
    }

    public static void addKVsToDisk(String fullTabName,String cfName,KeyValueSkipListSet kvs ){
        RegionServer.readConfig("regionServerMeta");
        RegionMeta regionMeta = RegionServer.getRegionMeta(fullTabName);
        FileStoreMeta fileStoreMeta = RegionServer.getFileStoreMeta(regionMeta, cfName);
        Map<Integer, List<KV>> integerListMap = RegionServer.splitKVsByPage(fileStoreMeta.getPageTrailer(), kvs);
        for (Map.Entry<Integer,List<KV>> entry : integerListMap.entrySet()) {
            if (!entry.getValue().isEmpty()){
                RegionServer.insertPageWithSplit(fullTabName,cfName,entry.getKey(),entry.getValue());
            }
        }
    }

    public static void removeKVsFromMemStore(String fullCfName){
        if (!inboundMemStore.containsKey(fullCfName)){
            inboundMemStore.remove(fullCfName);
        }
    }

    public static FileStoreMeta getFileStoreMeta(RegionMeta regionMeta, String cfName) {
        return regionMeta.getFileStoreMeta(cfName);
    }

    public static List<KVRange> getPageTrailer(String tabName, String cfName) {
        RegionMeta regionMeta = getRegionMeta(tabName);
        FileStoreMeta fileStoreMeta = getFileStoreMeta(regionMeta, cfName);
        return fileStoreMeta.getPageTrailer();
    }




    public static void insertPageWithSplit(String tabName, String cfName, int pageIndex, List<KV> kvs) {
        RegionMeta regionMeta = getRegionMeta(tabName);
        FileStoreMeta fileStoreMeta = getFileStoreMeta(regionMeta, cfName);
        String fileStoreName = fileStoreMeta.getEncodedName();
        List<KVRange> pageTrailer = fileStoreMeta.getPageTrailer();
        int pageLength = pageTrailer.get(pageIndex).getPageLength();
        if (pageLength + getKVsLength(kvs) > 4 * 1024) {
            byte[] bytes = VCFileReader.openFileStorePage(pageIndex+1,fileStoreName);
            KeyValueSkipListSet kvs1 = byteArrayToKvs(bytes);
            kvs1.addKVs(kvs);
            int tempLength = 0;
            boolean flag=true;
            List<KV> newKVs = new ArrayList<>();
            for (KV kv : kvs1) {
                newKVs.add(kv);
                tempLength += kv.getLength();
                if (tempLength > 3 * 1024) {
                    if (flag) {
                        pageTrailer.remove(pageIndex);
                        insertOldPage(newKVs, pageTrailer, pageIndex,
                                fileStoreName, fileStoreMeta, regionMeta.getfileStoreMetaName(cfName));
                        System.out.println("insertOldPage=========================");
                        newKVs.clear();
                        tempLength = 0;
                        flag= false;
                        continue;
                    }
                    if (kv.getLength() > 3 * 1024) {
                        insertNewPage(kv, pageTrailer, fileStoreName, fileStoreMeta, regionMeta.getfileStoreMetaName(cfName));
                        newKVs.remove(kv);
                    } else {
                        System.out.println("===========================");
                        insertNewPage(newKVs, pageTrailer, fileStoreName, fileStoreMeta, regionMeta.getfileStoreMetaName(cfName));
                        System.out.println("insertNewPage+++++++++++++++++++");
                        newKVs.clear();
                        tempLength = 0;
                    }
                }
            }
            if (!newKVs.isEmpty()){
                System.out.println("===========================");
                insertNewPage(newKVs, pageTrailer, fileStoreName, fileStoreMeta, regionMeta.getfileStoreMetaName(cfName));
                System.out.println("insertNewPage+++++++++++++++++++");
                newKVs.clear();
            }
        } else {
            //不分裂
            VCFIleWriter.appendDataSetToFileStorePage(pageTrailer.get(pageIndex).getPageLength(), kvsToByteArray(kvs), pageIndex+1, fileStoreMeta.getEncodedName());
            //更新元数据
            List<KVRange> list = updatePageTrailer(kvs, pageTrailer, pageIndex);
            fileStoreMeta.setPageTrailer(list);
            VCFIleWriter.writeAll(fileStoreMeta.getData(), 0, regionMeta.getfileStoreMetaName(cfName));
        }
    }

    private static void insertNewPage(KV kv, List<KVRange> pageTrailer,
                                      String fileStoreName, FileStoreMeta fileStoreMeta,
                                      String fileStoreMetaName) {
        int pageTrailerIndex = pageTrailer.size();
        pageTrailer.set(pageTrailerIndex, new KVRange(4 + kv.getLength(), kv.getRowKey(), kv.getRowKey()));
        fileStoreMeta.setPageTrailer(pageTrailer);
        VCFIleWriter.writeAll(fileStoreMeta.getData(), 0, fileStoreMetaName);
        List<KV> kvs = new ArrayList<>();
        kvs.add(kv);
        byte[] bytes = kvsToByteArray(kvs);
        VCFIleWriter.setFileStorePage(bytes, pageTrailerIndex+1, fileStoreName);
    }

    private static void insertNewPage(List<KV> newKVs, List<KVRange> pageTrailer,
                                      String fileStoreName, FileStoreMeta fileStoreMeta,
                                      String fileStoreMetaName) {
        int pageTrailerIndex = pageTrailer.size();
        List<KVRange> list = updatePageTrailer2(newKVs, pageTrailer, pageTrailerIndex);
        fileStoreMeta.setPageTrailer(list);
        VCFIleWriter.writeAll(fileStoreMeta.getData(), 0, fileStoreMetaName);
        byte[] bytes = kvsToByteArray(newKVs);
        VCFIleWriter.setFileStorePage(bytes, pageTrailerIndex+1, fileStoreName);
    }

    private static void insertOldPage(List<KV> newKVs, List<KVRange> pageTrailer,
                                      int pageIndex, String fileStoreName, FileStoreMeta fileStoreMeta, String fileStoreMetaName) {
        List<KVRange> list = updatePageTrailer2(newKVs, pageTrailer, pageIndex);
        fileStoreMeta.setPageTrailer(list);
        VCFIleWriter.writeAll(fileStoreMeta.getData(), 0, fileStoreMetaName);
        byte[] bytes = kvsToByteArray(newKVs);
        VCFIleWriter.setFileStorePage(bytes, pageIndex+1, fileStoreName);
    }

    public static Map<Integer, List<KV>> splitKVsByPage(List<KVRange> pageTrailer, KeyValueSkipListSet kvSet) {
        Map<Integer, List<KV>> integerListMap = new ConcurrentHashMap<>();
        for (int j = 0; j < pageTrailer.size(); j++) {
            List<KV> kvs = new ArrayList<>();
            for (KV kv : kvSet) {
                try {
                    pageTrailer.get(j + 1);
                    if ((kv.getRowKey().compareTo(Bytes.toString(pageTrailer.get(j).getEndKey())) <= 0
                            && kv.getRowKey().compareTo(Bytes.toString(pageTrailer.get(j).getStartKey())) >= 0)) {
                        kvs.add(kv);
                        kvSet.remove(kv);
                    }
                } catch (Exception e) {
                    kvs.add(kv);
                    kvSet.remove(kv);
                }
                integerListMap.put(j, kvs);
            }
        }
        return integerListMap;
    }

    public static void addTabName(String dbName, String tabName, String regionMetaFileName) {
        RegionServerMeta serverMeta = new RegionServerMeta(VCFileReader.readAll("regionServerMeta"));
        Map<String, String> regionMap = serverMeta.getRegionMap();
        /*应该查重*/
        regionMap.put(dbName + "." + tabName, regionMetaFileName);
        /*替换新map*/
        serverMeta.setRegionMap(regionMap);
        /*写入文件*/
        VCFIleWriter.writeAll(serverMeta.getData(), "regionServerMeta");
    }

    public static void updateRegionMeta(String fileName, String cfName, String fileStoreMetaName) {
        RegionMeta regionMeta = new RegionMeta(VCFileReader.readAll(fileName));
        regionMeta.getFileStoreMap();
        Map<String, String> fileStoreMap = regionMeta.getFileStoreMap();
        fileStoreMap.put(cfName, fileStoreMetaName);
        regionMeta.setFileStoreMap(fileStoreMap);
        VCFIleWriter.writeAll(regionMeta.getData(), fileName);
    }

    public static List<KVRange> updatePageTrailer(List<KV> newKVs, List<KVRange> pageTrailer, int pageIndex) {
        String minKey = "zzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String maxKey = "\0";
        int pageLength = getKVsLength(newKVs);
        for (KV kv : newKVs) {
            if (minKey.compareTo(kv.getRowKey()) > 0) {
                minKey = kv.getRowKey();
            }
            if (maxKey.compareTo(kv.getRowKey()) < 0) {
                maxKey = kv.getRowKey();
            }
        }
        pageTrailer.set(pageIndex , new KVRange(pageLength, minKey, maxKey));
        return pageTrailer;
    }

    public static List<KVRange> updatePageTrailer(KeyValueSkipListSet newKVs, List<KVRange> pageTrailer, int pageIndex) {
        String minKey = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String maxKey = "\0";
        int pageLength = getKVsLength(newKVs);
        minKey=newKVs.first().getRowKey();
        maxKey=newKVs.last().getRowKey();
        pageTrailer.set(pageIndex,new KVRange(pageLength, minKey, maxKey));
        return pageTrailer;
    }

    public static List<KVRange> updatePageTrailer2(List<KV> newKVs, List<KVRange> pageTrailer, int pageIndex) {
        String minKey = "zzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String maxKey = "\0";
        int pageLength = getKVsLength(newKVs);
        for (KV kv : newKVs) {
            if (minKey.compareTo(kv.getRowKey()) > 0) {
                minKey = kv.getRowKey();
            }
            if (maxKey.compareTo(kv.getRowKey()) < 0) {
                maxKey = kv.getRowKey();
            }
        }
        pageTrailer.add(pageIndex , new KVRange(pageLength, minKey, maxKey));
        return pageTrailer;
    }

    public static List<KVRange> updatePageTrailer2(KeyValueSkipListSet newKVs, List<KVRange> pageTrailer, int pageIndex) {
        String minKey = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String maxKey = "\0";
        int pageLength = getKVsLength(newKVs);
        minKey=newKVs.first().getRowKey();
        maxKey=newKVs.last().getRowKey();
        pageTrailer.add(pageIndex,new KVRange(pageLength, minKey, maxKey));
        return pageTrailer;
    }

    public static void updateColumnFamilyMeta(String fileStoreName, ColumnFamilyMeta columnFamilyMeta) {
        VCFIleWriter.writeAll(columnFamilyMeta.getData(), 0, fileStoreName);
    }

    public static RegionMeta getRegionMeta(String tableName) {
        //取出的应该缓存
        Map<String, String> regionMap = regionServerMeta.getRegionMap();
        return new RegionMeta(VCFileReader.readAll(regionMap.get(tableName)));
    }

    //接受rpc调用
    //获取元数据
    // responseObserver 为返回值
    @Override
    public void getRegionMeta(Empty request, StreamObserver<Meta.regionMeta> responseObserver) {
        Meta.regionMeta regionMeta = null;
        //获取元数据

        //返回元数据
        responseObserver.onNext(regionMeta);
        //告知本次处理完毕
        responseObserver.onCompleted();
    }

    //合并KV里的ValueNode
    public int MergeKV(String dbName, String tableName, String cfName, String rowKey, int versionFrom, int versionTo) {
        return 1;
    }


}
