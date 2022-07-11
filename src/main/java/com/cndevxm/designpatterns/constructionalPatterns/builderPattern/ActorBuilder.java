package com.cndevxm.designpatterns.constructionalPatterns.builderPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/13
 * Description
 */
public abstract class ActorBuilder {

    protected Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairstyle();

    public Actor createActor() {
        return actor;
    }
}
