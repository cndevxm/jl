package com.cndevxm.designpatterns.behavioralPatterns.interpreterPattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DistanceNode extends AbstractNode {

    private String distance;

    // 移动距离表达式的解释操作
    @Override
    public String interpret() {
        return this.distance;
    }
}
