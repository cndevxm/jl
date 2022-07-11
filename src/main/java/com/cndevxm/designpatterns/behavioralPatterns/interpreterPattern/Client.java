package com.cndevxm.designpatterns.behavioralPatterns.interpreterPattern;

public class Client {

    public static void main(String[] args) {

        String instruction = "up run 8 and down move 12 andATime left run 20 andATime right move 10";
        InstructionHandler instructionHandler = new InstructionHandler();
        instructionHandler.handle(instruction);
        String result = instructionHandler.output();
        System.out.println(result);
    }
}
