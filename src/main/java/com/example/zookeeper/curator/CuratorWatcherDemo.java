package com.example.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/** *
 * Description: CuratorWatcher机制实例
 * ClassName: CuratorWatcherDemo
 * Author: maze
 * Date: 2019/7/15 21:02
 **/
public class CuratorWatcherDemo {

    /**
     * 支持3中watch；
     * 1、pathCache 监视一个路径子节点下的创建、删除、更新操作；
     * 2、nodeCache 监视当前节点的创建、删除、更新操作；
     * 3、treeCache pathCache+nodeCache 监视当前节点及其子节点的创建、删除、更新操作；
     */

    private static String CONNECTSTRING = "172.17.229.81:2181";

    public static void main(String[] args) throws Exception {

        //获取zookeeper连接
        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.builder().connectString(CONNECTSTRING).sessionTimeoutMs(5000)
                        .retryPolicy(new ExponentialBackoffRetry(1000,3)).build();

        curatorFramework.start();

        //nodeCache 监听当前节点发生变化
//        NodeCache nodeCache = new NodeCache(curatorFramework, "/maze", false);
//        nodeCache.start(true);
//
//        nodeCache.getListenable().addListener(() -> System.out.println("节点发生变化,变化的是值是："+
//                new String(nodeCache.getCurrentData().getData())));
//
//        curatorFramework.setData().forPath("/maze", "7月16日".getBytes());
//        Thread.sleep(5000);

        //监听当前节点子路径下节点的变化
        PathChildrenCache cache=new PathChildrenCache(curatorFramework,"/zhangsan",true);
        cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        // Normal / BUILD_INITIAL_CACHE /POST_INITIALIZED_EVENT

        cache.getListenable().addListener((curatorFramework1,pathChildrenCacheEvent)->{
            System.out.println("类型："+pathChildrenCacheEvent.getType());
            switch (pathChildrenCacheEvent.getType()){
                case CHILD_ADDED:
                    System.out.println("增加子节点");
                    break;
                case CHILD_REMOVED:
                    System.out.println("删除子节点");
                    break;
                case CHILD_UPDATED:
                    System.out.println("更新子节点");
                    break;
                default:break;
            }
        });

        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/zhangsan/wwwwww","vvvvv".getBytes());
        Thread.sleep(3000);

        curatorFramework.setData().forPath("/zhangsan/wwwwww", "balbalbalbal".getBytes());

//        curatorFramework.delete().forPath("/maze/wwwwww");
        Thread.sleep(3000);


    }
}
