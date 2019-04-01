//package com.madaur.springboot2;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.retry.RetryOneTime;
//import org.apache.zookeeper.ZooKeeper;
//
//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//
///**
// * Description:
// *
// * @author maduar maduar@163.com
// * @version 1.1.1 13/03/2019
// */
//@Slf4j
//public class TestZk {
//    static CountDownLatch countDownLatch = new CountDownLatch(1);
//
//    public static void main(String args[]) throws Exception {
//        //
//        // 与 127.0.0.1:2181 连接，重试策略：仅重试 1 次
//        //
//
//        String ip = "150.109.49.131:";
//        String port = "2181";
//
//        int sessionTimeout = 3000;
//
//        MyWatcher myWatcher = new MyWatcher();
//
//        ZooKeeper zooKeeper = new ZooKeeper(ip + port, sessionTimeout, myWatcher);
//
//        Thread.sleep(sessionTimeout);
//
//        List<String> children = zooKeeper.getChildren("/", false);
//        log.info("children: " + children);
//
//        byte[] data = zooKeeper.getData("/china", false, null);
//        log.info("data: " + new String(data));
//
//        System.out.println("stat: " + zooKeeper.getState());
//
//        zooKeeper.close();
//    }
//}
