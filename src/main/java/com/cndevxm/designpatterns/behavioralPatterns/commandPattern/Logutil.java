package com.cndevxm.designpatterns.behavioralPatterns.commandPattern;

import java.util.LinkedHashMap;
import java.util.Map;

public class Logutil {

    private static Map<Integer, String> log = new LinkedHashMap<>();

    private static int stepNumber = 0;

    private static int queryNumber = 0;

    // 添加执行操作
    public static void addLog(String logStr) {
        stepNumber++;
        System.out.println("新增一条执行记录：" + logStr);
        log.put(stepNumber, logStr);

        queryNumber = stepNumber;
    }

    // 获取上一条执行日志
    public static void getPreviousLog() {
        if (queryNumber < 0) {
            queryNumber = 0;
            System.out.println("已经是最上一条执行记录");
        } else {
            queryNumber--;
            System.out.println("上一条执行记录为：" + log.get(queryNumber));
        }
    }

    // 获取下一条执行日志
    public static void getNextLog() {
        if (queryNumber > stepNumber) {
            queryNumber = stepNumber;
            System.out.println("已经是最下一条执行记录");
        } else {
            queryNumber++;
            System.out.println("下一条执行记录为：" + log.get(queryNumber));
        }
    }

    public static void showLog() {
        for (Integer i : log.keySet()) {
            System.out.println(log.get(i));
        }
    }
}
