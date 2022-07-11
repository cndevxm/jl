package com.cndevxm.designpatterns.constructionalPatterns.builderPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/13
 * Description
 */
public class Client {

    public static void main(String[] args) {

        ActorBuilder actorBuilder = new AngelBuilder();
        ActorController actorController = new ActorController();
        Actor actor = actorController.construct(actorBuilder);

        System.out.println(actor.getType());
        System.out.println(actor.getSex());
        System.out.println(actor.getFace());
        System.out.println(actor.getCostume());
        System.out.println(actor.getHairstyle());
    }
}
