package com.cndevxm.designpatterns.behavioralPatterns.statePattern;

public class RestrictedState extends Accountstate {

    public RestrictedState() {
    }

    public RestrictedState(Account account) {
        super(account);
    }

    @Override
    public void cq(double money) {
        super.cq(money);
    }

    @Override
    public void qq(double money) {
        System.out.println("取款功能受限");
        System.out.println("----------------------------");
    }
}
