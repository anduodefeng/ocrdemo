package com.example.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

public class ZookeeperDemo {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {


        ZooKeeper zooKeeper = new ZooKeeper("172.17.229.81:2181", 5000, new WatcherDemo());

//        String result = zooKeeper.create("/event","安多的风".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,
//                CreateMode.PERSISTENT);
//        System.out.println("创建节点"+result);

        zooKeeper.setData("/event", "546".getBytes(), -1);

        System.in.read();

    }
}
