package edu.neumont.csc370.model

/**
 * MiddleMen always keep one foot in, and one foot out
 * Created by stephen on 10/22/15.
 */
class MiddleMan(money : Double) : Player(money, 0.5) {

    override fun getBet(minimumBet : Double, multiplier : Double) : Double {
        val ret = this.money * this.bettingRatio
        if (ret >= minimumBet) {
            println("MiddleMan betting $ret")
            this.money *= this.bettingRatio
            return ret
        }
        return 0.0
    }
}