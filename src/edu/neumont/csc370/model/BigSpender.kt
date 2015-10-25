package edu.neumont.csc370.model

import edu.neumont.csc370.LOG

/**
 * Created by stephen on 10/22/15.
 */
class BigSpender(money : Double) : Player(money, 1.0) {

    override fun getBet(minimumBet : Double, multiplier : Double) : Double {
        var ret = money * this.bettingRatio
        if(ret < minimumBet)
            ret = 0.0
        LOG.printPlayerLevel("BigSpender betting $ret")
        this.money -= ret
        return ret
    }
}