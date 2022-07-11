package com.cndevxm.designpatterns.behavioralPatterns.statePattern;

public class Client {

    public static void main(String[] args) {

        Account account = new Account("张三", 1000, 10000);
        account.qq(10000);
        account.qq(2000);
        account.qq(2000);
        account.cq(1000);
        account.qq(1);
        account.cq(1);
        account.cq(10000);
    }
}
