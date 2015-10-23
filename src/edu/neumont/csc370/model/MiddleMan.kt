package edu.neumont.csc370.model

/**
 * MiddleMen always keep one foot in, and one foot out
 * Created by stephen on 10/22/15.
 */
class MiddleMan(money : Double) : Player(money, 0.5) {

    override fun getBet() : kotlin.Double {
        val ret = money * this.bettingRatio
        println("MiddleMan betting $ret")
        this.money *= this.bettingRatio
        return ret
    }
}