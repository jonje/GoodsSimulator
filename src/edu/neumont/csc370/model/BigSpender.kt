package edu.neumont.csc370.model

/**
 * Created by stephen on 10/22/15.
 */
class BigSpender(money : Double, multiplier : Double) : Player(money, multiplier) {

    override fun getBet() : Double {
        val ret = this.money
        money = 0.0
        return ret
    }
}