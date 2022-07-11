package com.cndevxm.designpatterns.behavioralPatterns.commandPattern;

public class DeleteCommand extends Command {

    private Receiver receiver = new Receiver();

    @Override
    public void execute() {
        receiver.delete();
        Logutil.addLog("执行了删除操作");
    }
}
