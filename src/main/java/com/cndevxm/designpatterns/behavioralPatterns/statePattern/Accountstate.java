package com.cndevxm.designpatterns.behavioralPatterns.statePattern;

public abstract class Accountstate {

    protected Account account;

    public Accountstate() {
    }

    public Accountstate(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public void cq(double money) {
        this.getAccount().setBalance(this.getAccount().getBalance() + money);
        this.changeState();
    }

    public abstract void qq(double money);

    public void changeState() {
        if (this.account.getBalance() >= 0) {
            this.account.setAccountstate(new NormalState(this.account));
        } else if (this.account.getBalance() >= -this.account.getAmount()) {
            this.account.setAccountstate(new OverdraftState(this.account));
        } else if (this.account.getBalance() < -this.account.getAmount()) {
            this.account.setAccountstate(new RestrictedState(this.account));
        }
    }

}
