package edu.neumont.csc370.model;

import edu.neumont.csc370.LOG;

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
        LOG.printPlayerLevel("Miser betting nothing");
        return 0;
    }

}
