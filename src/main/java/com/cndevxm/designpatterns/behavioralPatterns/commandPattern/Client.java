package com.cndevxm.designpatterns.behavioralPatterns.commandPattern;

public class Client {

    public static void main(String[] args) {
        Invoker invoker = new Invoker(new CommandQueue());
        invoker.call();
        System.out.println("##############################");
        Logutil.showLog();
        System.out.println("##############################");
        invoker.unDo();
        invoker.unDo();
        invoker.unDo();
        System.out.println("##############################");
        invoker.reDo();
        invoker.reDo();
        invoker.reDo();
    }
}
