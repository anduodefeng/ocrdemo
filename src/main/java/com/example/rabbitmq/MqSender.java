package com.example.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/** *
 * Description: MQ消息发送者
 * ClassName: MqSender
 * Author: maze
 * Date: 2019/6/14 17:17
 **/
public class MqSender {

    public static void main(String[] args) throws IOException, TimeoutException {

        //获取rabbitmq连接
        Connection connection = RabbitMqUtil.getConnection();

        //从连接中创建通道
        Channel channel = connection.createChannel();

        //创建队列
        channel.queueDeclare("fristQueue", false, false, false, null);

        //消息内容
        for(int i=0;i<100;i++){
            String message = "This is the "+ (i+1) +" Queue";
            channel.basicPublish("", "fristQueue", null, message.getBytes());

            System.out.println("发送消息：" + message);
        }

        channel.close();

        connection.close();


    }
}
