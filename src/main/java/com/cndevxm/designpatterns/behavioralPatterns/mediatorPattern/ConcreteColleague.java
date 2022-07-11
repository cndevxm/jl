package com.cndevxm.designpatterns.behavioralPatterns.mediatorPattern;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConcreteColleague extends Colleague {

    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void cook() {
        System.out.println("开始制定菜单");
        this.mediator.cook();
    }

    @Override
    public void wash() {
        this.mediator.wash();
    }

    @Override
    public void clean() {
        this.mediator.clean();
    }

}
