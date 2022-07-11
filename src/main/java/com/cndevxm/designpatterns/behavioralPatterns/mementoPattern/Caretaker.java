package com.cndevxm.designpatterns.behavioralPatterns.mementoPattern;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    private List<Memento> mementos = new ArrayList<>();

    public void setMemento(Memento memento) {
        mementos.add(memento);
    }

    public Memento getMemento(int i) {
        return mementos.get(i);
    }
}
