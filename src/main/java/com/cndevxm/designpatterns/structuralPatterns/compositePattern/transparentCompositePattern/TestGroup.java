package com.cndevxm.designpatterns.structuralPatterns.compositePattern.transparentCompositePattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestGroup implements Unit {

    private String name;

    @Override
    public void add(Unit unit) {
        System.out.println("测试组没有子节点");
    }

    @Override
    public void remove(Unit unit) {
        System.out.println("测试组没有子节点");
    }

    @Override
    public Unit getChild(int i) {
        System.out.println("测试组没有子节点");
        return null;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + "收到通知");
    }
}
