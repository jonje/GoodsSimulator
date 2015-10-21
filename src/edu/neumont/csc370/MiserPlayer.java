package edu.neumont.csc370;

import javax.swing.plaf.metal.MetalBorders;

/**
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
