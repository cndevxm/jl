package com.cndevxm.designpatterns.behavioralPatterns.interpreterPattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 方向解释：终结符表达式
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DirectionNode extends AbstractNode {

    private String direction;

    // 移动方向表达式的解释操作
    @Override
    public String interpret() {
        if (direction.equalsIgnoreCase("up")) {
            return "向上";
        } else if (direction.equalsIgnoreCase("down")) {
            return "向下";
        } else if (direction.equalsIgnoreCase("left")) {
            return "向左";
        } else if (direction.equalsIgnoreCase("right")) {
            return "向右";
        } else {
            return "无效指令";
        }
    }
}
