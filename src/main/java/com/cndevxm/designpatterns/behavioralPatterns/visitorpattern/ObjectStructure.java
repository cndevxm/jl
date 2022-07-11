package com.cndevxm.designpatterns.behavioralPatterns.visitorpattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ObjectStructure {

    private List<Element> elements = new ArrayList<>();

    public void add(Element element) {
        elements.add(element);
    }

    public void remove(Element element) {
        elements.remove(element);
    }

    public void handle(Visitor visitor) {
        elements.forEach(e -> visitor.visit(e));
    }
}
