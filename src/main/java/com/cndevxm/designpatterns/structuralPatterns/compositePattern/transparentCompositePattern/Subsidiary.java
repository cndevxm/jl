package com.cndevxm.designpatterns.structuralPatterns.compositePattern.transparentCompositePattern;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Subsidiary implements Unit {

    private List<Unit> units = new ArrayList<>();

    private String name;

    public Subsidiary(String name) {
        this.name = name;
    }

    @Override
    public void add(Unit unit) {
        units.add(unit);
    }

    @Override
    public void remove(Unit unit) {
        units.remove(unit);
    }

    @Override
    public Unit getChild(int i) {
        return units.get(i);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + "收到通知");
        System.out.println(name + "下发通知");
        units.forEach(child -> child.sendMessage(message));
    }
}
