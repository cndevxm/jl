package com.cndevxm.designpatterns.constructionalPatterns.builderPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/13
 * Description 建造模式的指挥者角色
 */
public class ActorController {

    public Actor construct(ActorBuilder actorBuilder) {

        Actor actor;
        actorBuilder.buildType();
        actorBuilder.buildSex();
        actorBuilder.buildFace();
        actorBuilder.buildCostume();
        actorBuilder.buildHairstyle();
        actor = actorBuilder.createActor();
        return actor;
    }
}
