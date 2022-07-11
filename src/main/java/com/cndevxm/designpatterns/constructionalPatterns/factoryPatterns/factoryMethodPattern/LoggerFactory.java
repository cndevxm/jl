package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.factoryMethodPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/5
 * Description 抽象工厂
 */
interface LoggerFactory {

    Logger createLogger();

    Logger createLogger(String args);

    Logger createLogger(Object args);
}
