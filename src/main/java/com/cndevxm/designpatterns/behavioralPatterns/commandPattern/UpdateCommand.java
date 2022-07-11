package com.cndevxm.designpatterns.behavioralPatterns.commandPattern;

public class UpdateCommand extends Command {

    private Receiver receiver = new Receiver();

    @Override
    public void execute() {
        receiver.update();
        Logutil.addLog("执行了更新操作");
    }
}
