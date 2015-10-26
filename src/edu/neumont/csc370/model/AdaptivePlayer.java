package edu.neumont.csc370.model;

import edu.neumont.csc370.LOG;

/**
 * Created by gh255013 on 10/24/15.
 */
public class AdaptivePlayer extends Player{
    private double currentBet;
    private double lastRoundMoney;
    private double lastRoundProfitPercentage;

    public AdaptivePlayer(double money, double bettingRatio) {
        super(money, bettingRatio);
        currentBet = money * this.getBettingRatio();
        lastRoundMoney = this.getMoney();
        lastRoundProfitPercentage = 0;
    }

    @Override
    public double getBet(double minimumBet, double multiplier) {
        //Consider previous winnings (increasing or decreasing as % of money)
        double profitLastRound = this.getMoney() - lastRoundMoney;
        double profitPercentage = profitLastRound / lastRoundMoney;
        double tempProfitPercentage = profitPercentage;
        profitPercentage = profitPercentage - lastRoundProfitPercentage;
        lastRoundProfitPercentage = tempProfitPercentage;
        lastRoundMoney = this.getMoney();

        //Consider pot multiplier
        double percentageToChange = /*Math.log(multiplier) * */profitPercentage;
        this.addPercentageToMultiplier(percentageToChange);

        //Decide on bet
        currentBet = this.getMoney() * getBettingRatio();
        if(currentBet < minimumBet)
            currentBet = minimumBet;

        if(currentBet > this.getMoney())
            currentBet = 0;

        this.setMoney(this.getMoney() - currentBet);
        String betMessage = String.format("AdaptivePlayer betting %.2f, %%%.2f of his/her money",
                currentBet, getBettingRatio() * 100);
        LOG.printPlayerLevel(betMessage);

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
