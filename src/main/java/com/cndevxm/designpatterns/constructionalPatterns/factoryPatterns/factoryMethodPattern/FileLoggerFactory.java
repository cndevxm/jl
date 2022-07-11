package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.factoryMethodPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/5
 * Description
 */
public class FileLoggerFactory extends AbstractLoggerFactory {

    @Override
    public Logger createLogger() {
        System.out.println("创建FileLogger");
        return new FileLogger();
    }

    @Override
    public Logger createLogger(String args) {
        System.out.println("创建FileLogger");
        return new FileLogger();
    }

    @Override
    public Logger createLogger(Object args) {
        System.out.println("创建FileLogger");
        return new FileLogger();
    }
}
