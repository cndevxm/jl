package com.cndevxm.designpatterns.behavioralPatterns.mediatorPattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class Colleague {

    protected Mediator mediator;

    public abstract void cook();

    public abstract void wash();

    public abstract void clean();

}
