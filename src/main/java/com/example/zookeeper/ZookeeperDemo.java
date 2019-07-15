package com.example.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

public class ZookeeperDemo {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {


        ZooKeeper zooKeeper = new ZooKeeper("172.17.229.81:2181", 5000, new WatcherDemo());

        String result = zooKeeper.create("/tiananweilai","安多的风".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL);
        System.out.println("创建节点"+result);
        zooKeeper.getData("/tiananweilai",true,null);

        zooKeeper.setData("/tiananweilai", "天空之城".getBytes(), -1);

        Thread.sleep(2000);

    }
}
