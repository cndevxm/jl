package com.cndevxm.designpatterns.behavioralPatterns.commandPattern;

public class InsertCommand extends Command {

    private Receiver receiver = new Receiver();

    @Override
    public void execute() {
        receiver.insert();
        Logutil.addLog("执行了插入操作");
    }
}
