package com.cndevxm.designpatterns.behavioralPatterns.interpreterPattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AndNode extends AbstractNode {

    private AbstractNode left;
    private AbstractNode right;

    @Override
    public String interpret() {
        return left.interpret() + "再" + right.interpret();
    }
}
