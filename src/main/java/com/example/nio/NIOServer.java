package com.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel server = ServerSocketChannel.open();
        Selector selector = Selector.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",8080);
        //服务端地址、端口
        server.bind(inetSocketAddress);
        //服务端设置 非阻塞（默认是阻塞）
        server.configureBlocking(false);

        server.register(selector,SelectionKey.OP_ACCEPT);

        while (true){

            //需要处理数据的通道的数量
            int wait = selector.select();
            if(0==wait) continue;

            /**
             * 选择出已经准备好要处理数据的通道，这里并不是全部的channel，而是仅仅本次轮询要进行数据处理的channel，
             * 处理完成之后，从Set集合中删掉，代表本channel已经处理完成，等下次需要处理的时候，再次选中即可；
             */
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if(selectionKey.isAcceptable()){
                    System.out.println("接受请求，准备读取数据");
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    System.out.println("读取数据中......");
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    client.read(byteBuffer);
                    System.out.println("client send message："+new String(byteBuffer.array()));
//                    client.register(selector, SelectionKey.OP_WRITE);
                }else if(selectionKey.isWritable()){
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    byteBuffer.put("收到请求".getBytes());
                    client.write(byteBuffer);
                    System.out.println("server send message："+new String(byteBuffer.array()));
                }
            }
        }
    }




}
