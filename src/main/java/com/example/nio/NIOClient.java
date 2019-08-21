package com.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class NIOClient {

    public static void main(String[] args) throws IOException {

        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",8080);
        Selector selector = Selector.open();
        SocketChannel client = SocketChannel.open(inetSocketAddress);
        client.configureBlocking(false);
//        client.registry(selector, SelectionKey.OP_ACCEPT);

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String content = scanner.next();
            ByteBuffer byteBuffer = ByteBuffer.wrap(content.getBytes());
            client.write(byteBuffer);

//            Set<SelectionKey> selectionKeys = selector.selectedKeys();
//            Iterator<SelectionKey> iterator = selectionKeys.iterator();
//            while(iterator.hasNext()){
//                SelectionKey selectionKey = iterator.next();
//                if(selectionKey.isAcceptable()){
//                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
//                    SocketChannel socketChannel = serverSocketChannel.accept();
//                    socketChannel.configureBlocking(false);         //非阻塞模式
//                    socketChannel.registry(selector, SelectionKey.OP_READ);
//                    System.out.println("connected server..");
//                }else if(selectionKey.isReadable()){
//                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
//                    ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
//                    socketChannel.read(byteBuffer1);
//                    System.out.println("server send message："+new String(byteBuffer1.array()));
//                }
//            }

        }


    }
}
