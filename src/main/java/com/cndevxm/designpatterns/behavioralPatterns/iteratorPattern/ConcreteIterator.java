package com.cndevxm.designpatterns.behavioralPatterns.iteratorPattern;

import java.util.List;

public class ConcreteIterator implements Iterator {

    private ConcreteAggregate aggregate;
    private List list;
    private int cursor1;
    private int cursor2;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
        this.list = aggregate.getObjects();
        this.cursor1 = 0;
        this.cursor2 = list.size() - 1;
    }

    @Override
    public void next() {
        if (cursor1 < list.size()) {
            cursor1++;
        }
    }

    @Override
    public void previous() {
        if (cursor2 > -1) {
            cursor2--;
        }
    }

    @Override
    public boolean isLast() {
        return (cursor1 == list.size());
    }

    @Override
    public boolean isFirst() {
        return (cursor2 == -1);
    }

    @Override
    public Object getNextItem() {
        return this.list.get(cursor1);
    }

    @Override
    public Object getPreviousItem() {
        return this.list.get(cursor2);
    }
}
