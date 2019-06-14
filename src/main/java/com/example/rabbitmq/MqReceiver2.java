package com.example.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/** *
 * Description: MQ消息接收者
 * ClassName: MqReceiver
 * Author: maze
 * Date: 2019/6/14 17:18
 **/
public class MqReceiver2 {

    public static void main(String[] args) throws IOException {

        //获取rabbitmq连接
        Connection connection = RabbitMqUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare("fristQueue", false, false, false, null);
        //定义队列的消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");
                System.out.println("接收到消息："+message);
            }
        };

        //自动回复队列应答 -- RabbitMQ中的消息确认机制
        channel.basicConsume("fristQueue", true, defaultConsumer);
    }
}
