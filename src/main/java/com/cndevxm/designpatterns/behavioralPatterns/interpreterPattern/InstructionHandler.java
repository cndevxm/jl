package com.cndevxm.designpatterns.behavioralPatterns.interpreterPattern;

import java.util.Stack;

/**
 * 指令处理类
 */
public class InstructionHandler {

    private AbstractNode node;

    public void handle(String instruction) {
        AbstractNode left, right;
        AbstractNode direction, action, distance;
        Stack<AbstractNode> stack = new Stack<>();
        String[] words = instruction.split(" ");

        for (int i = 0; i < words.length; i++) {
            if ("and".equals(words[i])) {
                left = stack.pop();
                direction = new DirectionNode(words[++i]);
                action = new ActionNode(words[++i]);
                distance = new DistanceNode(words[++i]);
                right = new SentenceNode(direction, action, distance);
                stack.push(new AndNode(left, right));
            } else if ("andATime".equals(words[i])) {
                left = stack.pop();
                direction = new DirectionNode(words[++i]);
                action = new ActionNode(words[++i]);
                distance = new DistanceNode(words[++i]);
                right = new SentenceNode(direction, action, distance);
                stack.push(new AndATimeNode(left, right));
            } else {
                // 将第一条指令压入栈中
                direction = new DirectionNode(words[i]);
                action = new ActionNode(words[++i]);
                distance = new DistanceNode(words[++i]);
                left = new SentenceNode(direction, action, distance);
                stack.push(left);
            }
        }
        node = stack.pop();
    }

    public String output() {
        return node.interpret();
    }
}
