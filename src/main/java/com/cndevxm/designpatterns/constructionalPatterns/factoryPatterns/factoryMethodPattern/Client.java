package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.factoryMethodPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/5
 * Description
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("数据库日志存储*******************");
        LoggerFactory dbLoggerFactory = new DataBaseLoggerFactory();
        Logger dbLogger = dbLoggerFactory.createLogger();
        dbLogger.writeLog();

        System.out.println("文件日志存储*******************");
        LoggerFactory fileLoggerFactory = new FileLoggerFactory();
        Logger fileLogger = fileLoggerFactory.createLogger();
        fileLogger.writeLog();

        System.out.println("数据库日志存储(隐藏细节)*******************");
        ((AbstractLoggerFactory) dbLoggerFactory).writeLog();
        System.out.println("文件日志存储(隐藏细节)*******************");
        ((AbstractLoggerFactory) fileLoggerFactory).writeLog();
    }
}
