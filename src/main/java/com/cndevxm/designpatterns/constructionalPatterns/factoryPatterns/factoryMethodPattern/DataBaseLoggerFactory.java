package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.factoryMethodPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/5
 * Description 具体工厂
 */
public class DataBaseLoggerFactory extends AbstractLoggerFactory {

    @Override
    public Logger createLogger() {
        System.out.println("创建DataBaseLogger");
        return new DataBaseLogger();
    }

    @Override
    public Logger createLogger(String args) {
        System.out.println("创建DataBaseLogger");
        return new DataBaseLogger();
    }

    @Override
    public Logger createLogger(Object args) {
        System.out.println("创建DataBaseLogger");
        return new DataBaseLogger();
    }
}
