package edu.neumont.csc370.model;

/**
 * Keep skates never payout
 * Created by jjensen on 10/21/15.
 */
public class MiserPlayer extends Player {

    public MiserPlayer(double money, double multiplier) {
        super(money, multiplier);
    }

    @Override
    public double getBet() {
        return 0;
    }

}