package com.cndevxm.designpatterns.behavioralPatterns.commandPattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Invoker {

    private CommandQueue commandQueue;

    public void call() {
        commandQueue.execute();
    }

    public void unDo() {
        Logutil.getPreviousLog();
    }

    public void reDo() {
        Logutil.getNextLog();
    }

}
