package edu.neumont.csc370.model;

import edu.neumont.csc370.LOG;

/**
 * Created by gh255013 on 10/24/15.
 */
public class AdaptivePlayer extends Player{
    private double betLastRound;
    private double winningsLastRound;
    private double currentBet;

    public AdaptivePlayer(double money, double bettingRatio) {
        super(money, bettingRatio);
        winningsLastRound = 0;
        betLastRound = 0;
        currentBet = money * this.getBettingRatio();
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
        currentBet = this.getMoney() * getBettingRatio();
        if(currentBet < minimumBet)
            currentBet = minimumBet;

        if(currentBet > this.getMoney())
            currentBet = 0;

        this.setMoney(this.getMoney() - currentBet);
        LOG.printPlayerLevel("AdaptivePlayer betting " + currentBet);
        return currentBet;
    }

    @Override
    public void earnWinnings(double winnings) {
        LOG.printPlayerLevel(String.format("%s just earned %.2f", this, winnings));
        this.setMoney(this.getMoney() + winnings);
    }

    private void addPercentageToMultiplier(double percentageChange) {
        if((getBettingRatio() + percentageChange) > 1.00) {
            setBettingRatio(1.00);

        } else if((getBettingRatio() + percentageChange) < 0.00) {
            setBettingRatio(0.00);
        } else {
            setBettingRatio(getBettingRatio() + percentageChange);
        }
    }
}
