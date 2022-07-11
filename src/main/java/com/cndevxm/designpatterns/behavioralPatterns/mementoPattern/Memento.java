package com.cndevxm.designpatterns.behavioralPatterns.mementoPattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Memento {

    private String name;
    private String phone;
    private String address;

    public Memento(Originator originator) {
        this.name = originator.getName();
        this.phone = originator.getPhone();
        this.address = originator.getAddress();
    }

}
