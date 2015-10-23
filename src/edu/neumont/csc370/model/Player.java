package edu.neumont.csc370.model;

/**
 * Created by jjensen on 10/21/15.
 */
public abstract class Player {

    private static int _id = 0;
    private double money;
    private int id;

    public Player(double money) {
        this.money = money;
        this.id = _id++;
    }

    public abstract double getBet();

    public void earnWinnings(double winnings) {
        System.out.println(String.format("%s just earned %f", this, winnings));
        money += winnings;
    }

    public int getId() {
        return id;
    }

    public double getMoney() {
        return money;
    }
    protected void setMoney(double newAmount) {
        this.money = newAmount;
    }

    @Override
    public String toString() {
        return String.format("%s, $%f",
                this.getClass().getSimpleName(), this.getMoney());
    }
}
