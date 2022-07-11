package com.cndevxm.designpatterns.behavioralPatterns.iteratorPattern;

public interface Iterator {

    void next();    // 移至下一个元素

    void previous();    // 移至上一个元素

    boolean isLast();

    boolean isFirst();

    Object getNextItem();

    Object getPreviousItem();

}
