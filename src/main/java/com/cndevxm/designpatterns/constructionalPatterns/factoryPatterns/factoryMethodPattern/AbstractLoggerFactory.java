package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.factoryMethodPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/5
 * Description
 */
public abstract class AbstractLoggerFactory implements LoggerFactory {

    void writeLog() {
        Logger logger = this.createLogger();
        logger.writeLog();
    }

    void writeLog(String args) {
        Logger logger = this.createLogger(args);
        logger.writeLog();
    }

    void writeLog(Object args) {
        Logger logger = this.createLogger(args);
        logger.writeLog();
    }
}
