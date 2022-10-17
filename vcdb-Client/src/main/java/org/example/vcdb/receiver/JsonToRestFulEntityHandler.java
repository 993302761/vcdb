package org.example.vcdb.receiver;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import org.example.vcdb.Analyzer.EX;
import org.example.vcdb.entity.Post.ActionEntity;
import io.netty.util.CharsetUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class JsonToRestFulEntityHandler extends SimpleChannelInboundHandler {
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        String ip=ctx.channel().remoteAddress().toString();
//        String[] a= ip.split(":");
//        System.out.println(a[0]+"-->"+"已连接");
//    }
//
//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        String ip=ctx.channel().remoteAddress().toString();
//        String[] a= ip.split(":");
//        System.out.println(a[0]+"-->"+"已断开");
//    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ActionEntity actionEntity= toRestfulEntity(msg);
        System.out.println("server接收到\n"+actionEntity);
        String s = EX.DFA2(actionEntity);
        ByteBuf byteBuf = Unpooled.wrappedBuffer(s.getBytes());
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
        ChannelFuture future = ctx.channel().write(response);
        future.addListener(ChannelFutureListener.CLOSE);
    }

    public ActionEntity toRestfulEntity(Object msg) throws JSONException {
        FullHttpRequest fullHttpRequest =(FullHttpRequest) msg;
        ActionEntity actionEntity = new ActionEntity(fullHttpRequest.getMethod().name(),fullHttpRequest.getUri());
        String content = fullHttpRequest.content().toString(CharsetUtil.UTF_8);
        System.out.println(content);
        return jsonToJavaOfRestfulEntity(content,actionEntity);
    }
    //解析json转换为实体
    public  ActionEntity jsonToJavaOfRestfulEntity(String content,ActionEntity actionEntity) throws JSONException {
        if ("".equals(content)){
            return  actionEntity;
        }
        JSONObject jsonObject = new JSONObject(content.trim());
        Iterator keys = jsonObject.keys();
        while(keys.hasNext()) {
            String key = (String) keys.next();
            Object o = jsonObject.get(key);
            if (o instanceof JSONArray) {
                System.out.println(key+": jsonArray类型");
                addCompoundAttribute(key,(JSONArray) o,actionEntity);
            }else {
                System.out.println(key+": kv类型");
                addRegularAttribute(key,o,actionEntity);
            }
        }
        return actionEntity;
    }

    private void addRegularAttribute(String key,Object o, ActionEntity actionEntity) {
        //看当前key是否存在
        if (actionEntity.containKey(key)){
            System.err.println("key重复");
        }
        if (o instanceof String){
            actionEntity.addRegularAttribute(key,o);
        }else {
            actionEntity.addRegularAttribute(key,String.valueOf(o));
        }

    }

    private void addCompoundAttribute(String key,JSONArray array, ActionEntity actionEntity) throws JSONException {
        //看当前key是否存在
        if (actionEntity.containKey(key)){
            System.err.println("key重复");
        }
        List<String> cfNames=new ArrayList<String>();
        if ("cf_names".equalsIgnoreCase(key)){
            for(int i=0;i<array.length();i++) {
                try{
                    String str = array.getString(i);
                    cfNames.add(str);
                }catch (JSONException ignored){
                    System.err.println("cfNames错误");
                }
            }
            actionEntity.addRegularAttribute(key,cfNames);
        } else {
            List<HashMap<String, String>> hashMapList=new ArrayList<HashMap<String, String>>();
            for(int i=0;i<array.length();i++) {
                String key2;
                try{
                    HashMap<String, String> hashMap=new HashMap<String, String>();
                    JSONObject jo=array.getJSONObject(i);
                    Iterator iterator = jo.keys();
                    while(iterator.hasNext()){
                        key2 = (String) iterator.next();
                        hashMap.put(key2,jo.getString(key2));
                    }
                    hashMapList.add(hashMap);
                }catch (JSONException ignored){
                    System.err.println("json类型错误");
                }
            }
            actionEntity.addCompoundAttribute(key,hashMapList);
        }
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}

class tt{
    public static void main(String[] args) {
        String s2="\\";
        for (byte b:s2.getBytes()){
            System.out.println(b);
        }
    }
}

