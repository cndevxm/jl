package com.cndevxm.designpatterns.behavioralPatterns.commandPattern;

public class Receiver {

    public void insert() {
        System.out.println("执行了新增操作");
    }

    public void update() {
        System.out.println("执行了更新操作");
    }

    public void query() {
        System.out.println("执行了查询操作");
    }

    public void delete() {
        System.out.println("执行了删除操作");
    }
}
