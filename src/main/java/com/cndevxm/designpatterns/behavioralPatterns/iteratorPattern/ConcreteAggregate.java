package com.cndevxm.designpatterns.behavioralPatterns.iteratorPattern;

import java.util.List;

public class ConcreteAggregate extends AbstractAggregate {

    public ConcreteAggregate() {
    }

    public ConcreteAggregate(List objects) {
        super(objects);
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    @Override
    public Iterator createInnerIterator() {
        return new InnerIterator();
    }

    private class InnerIterator implements Iterator {

        private int cursor1;
        private int cursor2;

        public InnerIterator() {
            cursor1 = 0;
            cursor2 = objects.size() - 1;
        }

        @Override
        public void next() {
            if (cursor1 < objects.size()) {
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
            return (cursor1 == objects.size());
        }

        @Override
        public boolean isFirst() {
            return (cursor2 == -1);
        }

        @Override
        public Object getNextItem() {
            return objects.get(cursor1);
        }

        @Override
        public Object getPreviousItem() {
            return objects.get(cursor2);
        }
    }

}
