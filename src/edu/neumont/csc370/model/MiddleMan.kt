package edu.neumont.csc370.model

/**
 * MiddleMen always keep one foot in, and one foot out
 * Created by stephen on 10/22/15.
 */
class MiddleMan(money : Double) : Player(money) {

    override fun getBet() : kotlin.Double {
        val ret = money / 2
        this.money /= 2
        return ret
    }
}