package edu.neumont.csc370.model

/**
 * Created by stephen on 10/22/15.
 */
class BigSpender(money : Double) : Player(money, 1.0) {

    override fun getBet(minimumBet : Double, multiplier : Double) : Double {
        val playerBet = this.money * this.bettingRatio
        println("BigSpender betting $playerBet")
        money -= playerBet
        return playerBet
    }
}