package edu.neumont.csc370.model;

/**
 * Created by jjensen on 10/21/15.
 */
public abstract class Player {

    private double money;
    private double multiplier;

    public Player(double money, double multiplier) {
        this.money = money;
        this.multiplier = multiplier;
    }

    public abstract double getBet();

    public void earnWinnings(double winnings) {
        money += winnings;
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
