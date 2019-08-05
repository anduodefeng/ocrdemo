package com.example.nio;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;

public class NioDemo {

    private static String sourcePath = "src/main/resources/file/source.txt";
    private static String targetPath = "src/main/resources/file/target.txt";

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();
//        BIOCopy();
//        NIOCopy();
//        NIOMultipleCopy();
        NIOCopy2();
        long end = System.currentTimeMillis();

        System.out.println("复制时间："+(end-start));

    }

    /** *
     * Description: BIO复制文件
     * Author: maze
     * Date: 2019/8/5 12:06
     * Params: []
     * Return: void
     **/
    private static void BIOCopy() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(sourcePath);
        FileOutputStream fileOutputStream = new FileOutputStream(targetPath);

        byte[] b = new byte[1024];
        while (fileInputStream.read(b) != -1){
            fileOutputStream.write(b,0,b.length);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    /** *
     * Description: NIO复制文件（单一缓冲区）
     * Author: maze
     * Date: 2019/8/5 13:54
     * Params: []
     * Return: void
     **/
    private static void NIOCopy() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(sourcePath);
        FileOutputStream fileOutputStream = new FileOutputStream(targetPath);
        ReadableByteChannel readableByteChannel = fileInputStream.getChannel();
        WritableByteChannel writableByteChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (readableByteChannel.read(byteBuffer) != -1){
            byteBuffer.flip();
        }

        while(byteBuffer.hasRemaining()){
            writableByteChannel.write(byteBuffer);
        }

        byteBuffer.clear();
        readableByteChannel.close();
        fileInputStream.close();
        writableByteChannel.close();
        fileOutputStream.close();

    }

    /** *
     * Description: NIO文件复制（多个缓冲区写入单一通道，单个通道写入多个缓冲区）
     * Author: maze
     * Date: 2019/8/5 14:46
     * Params: []
     * Return: void
     **/
    private static void NIOMultipleCopy() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(sourcePath);
        ScatteringByteChannel scatteringByteChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(50);
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1);

        byteBuffer.flip();
        byteBuffer1.flip();


        FileOutputStream fileOutputStream = new FileOutputStream(targetPath);
        GatheringByteChannel gatheringByteChannel = fileOutputStream.getChannel();
        gatheringByteChannel.write(new ByteBuffer[]{byteBuffer, byteBuffer1});


    }

    /** *
     * Description: NIO文件复制（通道之间直接复制）
     * Author: maze
     * Date: 2019/8/5 16:15
     * Params: []
     * Return: void
     **/
    private static void NIOCopy2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(sourcePath);
        FileOutputStream fileOutputStream = new FileOutputStream(targetPath);

        ReadableByteChannel readableByteChannel = fileInputStream.getChannel();
        WritableByteChannel writableByteChannel = fileOutputStream.getChannel();

        ((FileChannel) readableByteChannel).transferTo(0, ((FileChannel) readableByteChannel).size(),writableByteChannel);


    }
}
