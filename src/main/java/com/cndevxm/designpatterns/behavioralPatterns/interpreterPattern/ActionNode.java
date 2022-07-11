package com.cndevxm.designpatterns.behavioralPatterns.interpreterPattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 动作解释：终结符表达式
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActionNode extends AbstractNode {

    private String action;

    // 动作（移动方式） 表达式的解释操作
    @Override
    public String interpret() {
        if (action.equalsIgnoreCase("move")) {
            return "移动";
        } else if (action.equalsIgnoreCase("run")) {
            return "快速移动";
        } else {
            return "无效指令";
        }
    }
}
