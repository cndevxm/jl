package com.cndevxm.designpatterns.behavioralPatterns.interpreterPattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 简单句子解释器
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SentenceNode extends AbstractNode {

    private AbstractNode directionNode;
    private AbstractNode actionNode;
    private AbstractNode distanceNode;

    @Override
    public String interpret() {
        return directionNode.interpret() + actionNode.interpret() + distanceNode.interpret();
    }
}
