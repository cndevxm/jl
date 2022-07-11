package com.cndevxm.designpatterns.structuralPatterns.decoratorPattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ComponentDecorator extends Component {

    private Component component;

    @Override
    public void display() {
        component.display();
    }
}
