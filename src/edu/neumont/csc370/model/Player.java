package edu.neumont.csc370.model;

/**
 * Created by jjensen on 10/21/15.
 */
public abstract class Player {

    private static int _id = 0;
    private double money;
    private double multiplier;
    private int id;

    public Player(double money, double multiplier) {
        this.money = money;
        this.multiplier = multiplier;
        this.id = _id++;
    }

    public abstract double getBet();

    public void earnWinnings(double winnings) {
        money += winnings;
    }

    public int getId() {
        return id;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public double getMoney() {
        return money;
    }
    protected void setMoney(double newAmount) {
        this.money = newAmount;
    }

    @Override
    public String toString() {
        return String.format("%s, $%f x %f",
                this.getClass().getSimpleName(), this.getMoney(), this.getMultiplier());
    }
}
