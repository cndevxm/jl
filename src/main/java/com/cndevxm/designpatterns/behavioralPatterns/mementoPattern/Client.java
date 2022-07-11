package com.cndevxm.designpatterns.behavioralPatterns.mementoPattern;

public class Client {

    private static int cursor = -1;
    private static Caretaker caretaker = new Caretaker();

    private static void bj(Originator originator) {
        cursor++;
        caretaker.setMemento(originator.createMemento());
        System.out.println(originator.toString());
    }

    private static void undo(Originator originator) {
        System.out.println("往上一住址搬");
        cursor--;
        originator.restore(caretaker.getMemento(cursor));
        System.out.println(originator.toString());
    }

    private static void redo(Originator originator) {
        System.out.println("往下一住址搬");
        cursor++;
        originator.restore(caretaker.getMemento(cursor));
        System.out.println(originator.toString());
    }

    public static void main(String[] args) {
        Originator originator = new Originator("张三", "1", "sh");
        bj(originator);
        Originator originator1 = new Originator("张三", "2", "sh");
        bj(originator1);
        Originator originator2 = new Originator("张三", "3", "sh");
        bj(originator2);
        Originator originator3 = new Originator("张三", "3", "bj");
        bj(originator3);

        undo(new Originator());
        undo(new Originator());

        redo(new Originator());

    }

}
