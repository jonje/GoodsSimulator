package edu.neumont.csc370;

/**
 * Created by jjensen on 10/21/15.
 */
public abstract class Player {

    private double money;
    private double minBid;
    private double maxBid;
    private double multiplier;

    public Player(double money, double multiplier) {
        this.money = money;
        this.multiplier = multiplier;
    }

    public abstract double getBet();
    public abstract void setWinnings(double winnings);
    public abstract double getMoney();

}
