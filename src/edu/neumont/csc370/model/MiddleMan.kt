package edu.neumont.csc370.model

import edu.neumont.csc370.LOG

/**
 * MiddleMen always keep one foot in, and one foot out
 * Created by stephen on 10/22/15.
 */
class MiddleMan(money : Double) : Player(money, 0.5) {

    override fun getBet(minimumBet : Double, multiplier : Double) : Double {
        var ret = money * this.bettingRatio
        if(ret < minimumBet)
            ret = 0.0
        LOG.printPlayerLevel("MiddleMan betting $ret")
        this.money -= ret
        return ret
    }
}