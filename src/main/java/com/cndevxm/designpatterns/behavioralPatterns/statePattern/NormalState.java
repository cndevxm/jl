package com.cndevxm.designpatterns.behavioralPatterns.statePattern;

public class NormalState extends Accountstate {

    public NormalState() {

    }

    public NormalState(Account account) {
        super(account);
    }

    @Override
    public void cq(double money) {
        super.cq(money);
    }

    @Override
    public void qq(double money) {
        double balance = this.getAccount().getBalance() - money;
        this.getAccount().setBalance(balance);
        System.out.println("取钱成功");
        this.changeState();
        System.out.println("----------------------------");
    }
}
