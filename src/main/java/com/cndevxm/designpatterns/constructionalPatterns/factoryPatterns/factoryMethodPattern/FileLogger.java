package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.factoryMethodPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/5
 * Description
 */
public class FileLogger implements Logger{
    @Override
    public void writeLog() {
        System.out.println("文件系统存储日志");
    }
}
