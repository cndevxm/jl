package com.cndevxm.designpatterns.behavioralPatterns.visitorpattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Element {

    private String name;
    private String address;
    private String sex;

    public abstract void accept(Visitor visitor);
}
