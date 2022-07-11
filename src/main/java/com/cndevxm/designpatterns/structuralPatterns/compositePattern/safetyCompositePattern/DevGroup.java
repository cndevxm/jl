package com.cndevxm.designpatterns.structuralPatterns.compositePattern.safetyCompositePattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevGroup implements Unit {

    private String name;

    @Override
    public void sendMessage(String message) {
        System.out.println(name + "收到通知");
    }
}
