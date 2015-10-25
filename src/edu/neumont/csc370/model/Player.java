package edu.neumont.csc370.model;

/**
 * Created by jjensen on 10/21/15.
 */
public abstract class Player {

    private static int _id = 0;
    protected double money;
    private double bettingRatio;
    private int id;

    public Player(double money, double bettingRatio) {
        this.money = money;
        this.bettingRatio = bettingRatio;
        this.id = _id++;
    }

    public abstract double getBet(double minimumBet, double multiplier);

    public void earnWinnings(double winnings) {
        System.out.println(String.format("%s just earned %f", this, winnings));
        money += winnings;
    }

    public int getId() {
        return id;
    }

    public double getBettingRatio() { return bettingRatio; }

    public void setBettingRatio( double bettingRatio ) {
        this.bettingRatio = bettingRatio;
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
