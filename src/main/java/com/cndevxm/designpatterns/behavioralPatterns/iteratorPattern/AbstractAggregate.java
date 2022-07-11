package com.cndevxm.designpatterns.behavioralPatterns.iteratorPattern;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAggregate {

    protected List objects = new ArrayList();

    public AbstractAggregate() {
    }

    public AbstractAggregate(List<Object> objects) {
        this.objects = objects;
    }

    public void addObject(Object o) {
        this.objects.add(o);
    }

    public void removeObject(Object o) {
        this.objects.remove(o);
    }

    public List getObjects() {
        return this.objects;
    }

    public abstract Iterator createIterator();

    public abstract Iterator createInnerIterator();
}
