package edu.neumont.csc370.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gh255013 on 10/24/15.
 */
public class AdaptivePlayer extends Player{
    private static final double START_BET_MULTIPLIER = .25;
    private double currentMultiplier;
    private double betLastRound;
    private double winningsLastRound;
    private double currentBet;

    public AdaptivePlayer(double money, double bettingRatio) {
        super(money, bettingRatio);
        winningsLastRound = 0;
        betLastRound = 0;
        currentBet = money * START_BET_MULTIPLIER;
    }

    @Override
    public double getBet(double minimumBet, double multiplier) {
        //Consider previous winnings (increasing or decreasing as % of money)
        double profitLastRound = betLastRound - winningsLastRound;
        double profitPercentage = profitLastRound / this.getMoney();

        //Consider pot multiplier
        double percentageChange = Math.log(multiplier) * profitPercentage;
        this.addPercentageToMultiplier(percentageChange);

        //Decide on bet
        currentBet = this.getMoney() * currentMultiplier;
        if(currentBet < minimumBet)
            currentBet = minimumBet;

        if(currentBet > this.getMoney())
            currentBet = 0;

        this.setMoney(this.getMoney() - currentBet);
        return currentBet;
    }

    @Override
    public void earnWinnings(double winnings) {
        System.out.println(String.format("%s just earned %f", this, winnings));
        this.setMoney(this.getMoney() + winnings);
    }

    private void addPercentageToMultiplier(double percentageChange) {
        if((currentMultiplier + percentageChange) > 1.00) {
            currentMultiplier = 1;

        } else if((currentMultiplier + percentageChange) < 0.00) {
            currentMultiplier = 0;
        } else {
            currentMultiplier += percentageChange;
        }
    }
}
