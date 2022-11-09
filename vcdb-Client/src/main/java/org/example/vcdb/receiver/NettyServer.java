package org.example.vcdb.receiver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.stream.ChunkedWriteHandler;


public class NettyServer {
    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                            ch.pipeline().addLast("http-aggregator",new HttpObjectAggregator(65536));
                            ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                            ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                            ch.pipeline().addLast("json转换成RequestEntity",new JsonToRestFulEntityHandler());
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind(8080).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*
    curl -H "Content-Type: application/json" -X POST -d\
    '{"limit":9,"j_tables":[{"tab_name":"t_name","method":"inner"}],"cf_names":["rowKey","id"],"terms":[{"cf_name":"列族名称","c_name":"StudentAge","max": "2","equivalence":"22","min":"1","like": "模糊(%表示多个字符，_表示一个字符)"}],"orders":[{"cf_name":"xxx","sort":"asc/desc"}]}'\
    "localhost:8080/dbname/tab_name/_mget"

    */
    public static void main(String[] args) throws Exception {
        NettyServer nettyServer =new NettyServer();
        nettyServer.run();
    }

}
