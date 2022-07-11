package com.cndevxm.designpatterns.behavioralPatterns.commandPattern;

public class QueryCommand extends Command {

    private Receiver receiver = new Receiver();

    @Override
    public void execute() {
        receiver.query();
        Logutil.addLog("执行了查询操作");
    }
}
