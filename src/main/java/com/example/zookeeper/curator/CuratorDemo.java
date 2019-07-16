package com.example.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** *
 * Description: curator demo实例
 * ClassName: CuratorDemo
 * Author: maze
 * Date: 2019/7/15 21:03
 **/
public class CuratorDemo {

    private static String CONNECTSTRING = "172.17.229.81:2181";
    public static void main(String[] args){

        //获取zookeeper连接
//        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(CONNECTSTRING,5000,5000,
//                new ExponentialBackoffRetry(1000,3));
//        curatorFramework.start();


        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.builder().connectString(CONNECTSTRING).sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000,3)).build();

        curatorFramework.start();

        //创建节点
//        try {
//            String result = curatorFramework.create()
//                            .creatingParentsIfNeeded()
//                            .withMode(CreateMode.PERSISTENT)
//                            .forPath("/car/audi","111".getBytes());
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //修改节点
//        try {
//            Stat stat = curatorFramework.setData().forPath("/car/audi", "222".getBytes());
//            System.out.println(stat);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //获取节点数据
//        try {
//            byte[] bytes = curatorFramework.getData().forPath("/car/audi");
//            System.out.println(new String(bytes));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //删除节点
//        try {
//            curatorFramework.delete().deletingChildrenIfNeeded().forPath("/car");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        /**
         * 异步操作，增、删、改、查操作都可以做异步处理，不影响主线程
         * 异步操作需要新建立线程来操作；
         */
//        try {
//            curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
//                    .inBackground(new BackgroundCallback() {
//                        @Override
//                        public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
//                            System.out.println("异步创建节点");
//                            System.out.println("类型："+curatorEvent.getType());
//                        }
//                    }).forPath("/car/audi");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        /**
         * 事务操作（curator独有操作）
         * and 连接的多个操作都成功，才成功，一个失败，都失败；
         */

        try {
            Collection<CuratorTransactionResult> results = curatorFramework.inTransaction().create().withMode(CreateMode.PERSISTENT)
                    .forPath("/maze", "444".getBytes()).and().delete().forPath("/car").and().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
