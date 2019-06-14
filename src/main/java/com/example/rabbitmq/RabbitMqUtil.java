package com.example.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/** *
 * Description: rabbitMq 工具类
 * ClassName: RabbitMqUtil
 * Author: maze
 * Date: 2019/6/14 15:40
 **/
public class RabbitMqUtil {

    /** *
     * Description: 获取rabbitmq连接
     * Author: maze
     * Date: 2019/6/14 15:41
     * Params: []
     * Return: com.rabbitmq.client.Connection
     **/
    public static Connection getConnection(){

        Connection connection = null;
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();

            connectionFactory.setHost("39.96.68.127");
            connectionFactory.setPort(5672);
            connectionFactory.setVirtualHost("guesthost");
            connectionFactory.setUsername("guest");
            connectionFactory.setPassword("guest");

            connection = connectionFactory.newConnection();
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
