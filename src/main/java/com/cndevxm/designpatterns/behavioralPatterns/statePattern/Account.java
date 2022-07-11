package com.cndevxm.designpatterns.behavioralPatterns.statePattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

    private String name;

    private Accountstate accountstate;

    private double balance;

    private double amount;

    /**
     * 初始化账户
     *
     * @param name
     * @param init
     */
    public Account(String name, double init, double amount) {
        this.name = name;
        this.balance = init;
        this.amount = amount;
        this.accountstate = new NormalState(this);
        System.out.println(this.name + "开户成功，账户额度为：" + this.amount + ",初始账户金额为：" + this.balance);
        System.out.println("-------------------------------");
    }

    /**
     * 存钱
     *
     * @param money
     */
    public void cq(double money) {
        System.out.println("存钱");
        this.accountstate.cq(money);
        System.out.println("账户目前存款为：" + this.balance);
        System.out.println("账户目前状态为：" + this.accountstate.getClass().getSimpleName());
        System.out.println("-------------------------------");
    }

    /**
     * 取钱
     *
     * @param money
     */
    public void qq(double money) {
        System.out.println("取钱");
        this.accountstate.qq(money);
        System.out.println("账户目前存款为：" + this.balance);
        System.out.println("账户目前状态为：" + this.accountstate.getClass().getSimpleName());
        System.out.println("-------------------------------");
    }
}
