package edu.neumont.csc370.model

import edu.neumont.csc370.LOG

/**
 * Created by gh255013 on 10/25/15.
 * The cheapskate only ever pays the minimum
 */
class Cheapskate(money : Double) : Player(money, 0.0) {

    override fun getBet(minimumBet : Double, multiplier : Double) : Double {
        var ret = minimumBet
        if(ret > this.money)
            ret = 0.0
        LOG.printPlayerLevel("MiddleMan betting $ret")
        this.money -= ret
        return ret
    }
}
