package com.cndevxm.designpatterns.constructionalPatterns.builderPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/13
 * Description
 */
public class AngelBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        actor.setType("天使");
    }

    @Override
    public void buildSex() {
        actor.setSex("女");
    }

    @Override
    public void buildFace() {
        actor.setFace("美人");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("白裙");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("披头散发");
    }
}
