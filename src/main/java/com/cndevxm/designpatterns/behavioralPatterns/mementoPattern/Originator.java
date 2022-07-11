package com.cndevxm.designpatterns.behavioralPatterns.mementoPattern;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Originator {

    private String name;
    private String phone;
    private String address;

    public Memento createMemento() {
        return new Memento(this);
    }

    public void restore(Memento memento) {
        this.name = memento.getName();
        this.phone = memento.getPhone();
        this.address = memento.getAddress();
    }

}
