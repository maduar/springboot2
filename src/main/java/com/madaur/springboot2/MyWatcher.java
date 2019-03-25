package com.madaur.springboot2;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Description:
 *
 * @author maduar maduar@163.com
 * @version 1.1.1 14/03/2019
 */
public class MyWatcher implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("WatchedEvent: " + watchedEvent);
    }
}
