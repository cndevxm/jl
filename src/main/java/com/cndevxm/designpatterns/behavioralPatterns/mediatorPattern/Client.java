package com.cndevxm.designpatterns.behavioralPatterns.mediatorPattern;

public class Client {

    public static void main(String[] args) {

        Mediator mediator = new ConcreteMdeiator(new ConcreteColleagueA(), new ConcreteColleagueB(), new ConcreteColleagueC());
        Colleague colleague = new ConcreteColleague(mediator);
        System.out.println("-----------------------");
        colleague.cook();
        System.out.println("-----------------------");
        colleague.wash();
        System.out.println("-----------------------");
        colleague.clean();
    }
}
