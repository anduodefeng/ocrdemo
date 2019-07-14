package com.example.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ZookeeperDemo {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {


        ZooKeeper zooKeeper = new ZooKeeper("172.17.229.81:2181", 5000,
                watchedEvent -> {
                    countDownLatch.countDown();
                    System.out.println("状态---->"+watchedEvent.getState().name());
                    System.out.println("类型---->"+watchedEvent.getType().name());
                    System.out.println("路径---->"+watchedEvent.getPath());
                });

        String result = zooKeeper.create("/tiananweilai","安多的风".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL);
        System.out.println("创建节点"+result);

        zooKeeper.getData("/tiananweilai",true,null);

        TimeUnit.SECONDS.sleep(1000000);



    }
}
