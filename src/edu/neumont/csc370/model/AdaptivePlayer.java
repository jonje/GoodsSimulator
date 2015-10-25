package edu.neumont.csc370.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gh255013 on 10/24/15.
 */
public class AdaptivePlayer extends Player{
    private List<Double> previousWinnings;

    public AdaptivePlayer(double money, double bettingRatio) {
        super(money, bettingRatio);
        previousWinnings = new ArrayList<Double>();
    }

    @Override
    public double getBet(double minimumBet, double multiplier) {
        //Consider previous winnings (increasing or decreasing as % of money)
        //Consider pot multiplier
        //Decide on bet


        //temporay
        return minimumBet;
    }

    @Override
    public void earnWinnings(double winnings) {
        System.out.println(String.format("%s just earned %f", this, winnings));
        this.setMoney(this.getMoney() + winnings);
    }
}
