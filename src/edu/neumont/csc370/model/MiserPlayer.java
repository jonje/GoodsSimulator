package edu.neumont.csc370.model;

/**
 * Keep skates never payout
 * Created by jjensen on 10/21/15.
 */
public class MiserPlayer extends Player {

    public MiserPlayer(double money) {
        super(money, 0);
    }

    @Override
    public double getBet( double minimumBet, double multiplier ) {
        System.out.println("Miser betting nothing");
        return 0;
    }

}
