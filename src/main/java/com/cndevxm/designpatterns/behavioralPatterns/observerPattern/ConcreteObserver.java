package com.cndevxm.designpatterns.behavioralPatterns.observerPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConcreteObserver implements Observer {

    private String name;

    @Override
    public void update() {
        System.out.println(this.name + "已更新");
    }
}
