package com.cndevxm.designpatterns.behavioralPatterns.mediatorPattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ConcreteMdeiator implements Mediator {

    private ConcreteColleagueA concreteColleagueA;
    private ConcreteColleagueB concreteColleagueB;
    private ConcreteColleagueC concreteColleagueC;


    @Override
    public void cook() {
        concreteColleagueA.cook();
        concreteColleagueB.cook();
        concreteColleagueC.cook();
    }

    @Override
    public void wash() {
        concreteColleagueA.wash();
        concreteColleagueB.wash();
        concreteColleagueC.wash();
    }

    @Override
    public void clean() {
        concreteColleagueA.clean();
        concreteColleagueB.clean();
        concreteColleagueC.clean();
    }
}
