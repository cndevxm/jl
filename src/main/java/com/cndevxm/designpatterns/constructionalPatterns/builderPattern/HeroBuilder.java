package com.cndevxm.designpatterns.constructionalPatterns.builderPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/13
 * Description
 */
public class HeroBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        actor.setType("英雄");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("东方化");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("盔甲");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("飘逸");
    }
}


