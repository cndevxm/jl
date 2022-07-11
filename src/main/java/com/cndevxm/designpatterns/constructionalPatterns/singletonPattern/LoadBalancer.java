package com.cndevxm.designpatterns.constructionalPatterns.singletonPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Yulin Ma
 * Date 2019/3/8
 * Description 懒加载 单例模式
 */
public class LoadBalancer {

    private static LoadBalancer loadBalancer;

    private List serverList;

    private LoadBalancer() {
        try {
            // 添加睡觉时间，使高并发情况的问题更加凸显出来
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serverList = new ArrayList();
        System.out.println("调用了构造函数");
    }

    public static LoadBalancer getLoadBalancer() {
        if (loadBalancer == null) {
            loadBalancer = new LoadBalancer();
        }
        return loadBalancer;
    }

    public void addServer(String server) {
        serverList.add(server);
    }

    public void removeServer(String server) {
        serverList.remove(server);
    }

    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String) serverList.get(i);
    }
}
