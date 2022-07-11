package com.cndevxm.designpatterns.structuralPatterns.flyweightPattern;

import java.util.HashMap;

public class FlyweightFactory {

    private static FlyweightFactory flyweightFactory = new FlyweightFactory();
    private HashMap<String, Flyweight> map = new HashMap<>();

    public FlyweightFactory() {
        map.put("c", new ConcreteFlyweight());
    }

    /**
     * 饿汉式加载返回工厂实例
     *
     * @return
     */
    public static FlyweightFactory getInstance() {
        return flyweightFactory;
    }

    public Flyweight getFlyweight(String key) {
        return map.get(key);
    }
}
