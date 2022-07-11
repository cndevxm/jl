package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.factoryMethodPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/5
 * Description
 */
public class DataBaseLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("数据库存储日志");
    }
}
