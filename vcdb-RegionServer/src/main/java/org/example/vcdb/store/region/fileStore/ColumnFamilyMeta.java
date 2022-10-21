package org.example.vcdb.store.region.fileStore;
import org.example.vcdb.util.Bytes;


/**
 * @ClassName ColumnFamilyMeta
 * @Description TODO
 * @Author lqc
 * @Date 2022/8/20 下午9:19
 * @Version 1.0
 */
/*
    long min=Long.MIN_VALUE;
    long max=Long.MAX_VALUE;
    boolean unique;
    boolean isNull;
    byte type;
*/
public class ColumnFamilyMeta {
    private byte[] data=null;

    public byte[] getData() {
        return data;
    }
    public ColumnFamilyMeta( String min, String max,
                             boolean unique, boolean isNull,CFType type){
        byte uni=0;
        byte isNil=0;
        if (unique){
            uni=1;
        }
        if (isNull){
            isNil=1;
        }
        this.data = createByteArray( min, max,uni, isNil,  type);
    }

    public ColumnFamilyMeta(byte[] data){
        this.data=data;
    }

    private byte[] createByteArray(String min, String max,
                                   byte unique, byte isNull, CFType type) {
        byte[] bytes = new byte[4+min.getBytes().length+4+max.getBytes().length+1+1+1];
        int pos=0;
        pos= Bytes.putInt(bytes,pos,min.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,min.getBytes(),0,min.getBytes().length);
        pos= Bytes.putInt(bytes,pos,max.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,max.getBytes(),0,max.getBytes().length);
        pos= Bytes.putByte(bytes,pos,unique);
        pos=Bytes.putByte(bytes,pos,isNull);
        pos=Bytes.putByte(bytes,pos,type.getCode());
        return bytes;
    }

    public int getMinLength() {
        return Bytes.toInt(this.data,0,4);
    }
    public String getMin(){
        return Bytes.toString(this.data,4,getMinLength());
    }
    public int getMaxLength() {
        return Bytes.toInt(this.data,4+getMinLength(),4);
    }

    public String getMax(){
        return Bytes.toString(this.data,8+getMinLength(),getMaxLength());
    }

    public boolean isUnique() {
        return data[8+getMinLength()+getMaxLength()] != 0;
    }
    public boolean isNull() {
        return data[9+getMinLength()+getMaxLength()]!=0;
    }
    public CFType getType() {
        return byteToCFType(data[10+getMinLength()+getMaxLength()]);
    }

    public void dis(){
        System.out.println(isUnique());
        System.out.println(isNull());
        System.out.println(getMin());
        System.out.println(getMax());
        System.out.println( getType());
    }
    public static enum CFType {
        TINYINT((byte) 42),
        SMALLINT((byte) 44),
        INTEGER((byte) 46),
        BIGINT((byte) 48),
        FLOAT((byte) 50),
        TIMESTAMP((byte) 52),
        CHAR((byte) 54),
        VARCHAR((byte) 56),
        //二进制文件
        LONGBLOB((byte) 58),
        ;
        private final byte code;
        CFType(final byte c) {
            this.code = c;
        }
        public byte getCode() {
            return this.code;
        }
    }
    public static CFType byteToCFType(byte b){
        switch (b){
            case 42:
                return CFType.TINYINT;
            case 44:
                return CFType.SMALLINT;
            case 46:
                return CFType.INTEGER;
            case 48:
                return CFType.BIGINT;
            case 50:
                return CFType.FLOAT;
            case 52:
                return CFType.TIMESTAMP;
            case 54:
                return CFType.CHAR;
            case 56:
                return CFType.VARCHAR;
            case 58:
                return CFType.LONGBLOB;
            default:
                return null;
        }
    }
}
