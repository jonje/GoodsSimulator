package edu.neumont.csc370.simulation

import edu.neumont.csc370.model.Player
/**
 * Created by stephen on 10/23/15.
 */
class PhaseOneSimulation(val players : List<Player>) : Simulation(players,  multiplier = 2.0) {
    var moneyPot = 0.0
    val minBet = 0.0

    override fun run() {

        runWithPlayerPool(players)
    }

    private fun runWithPlayerPool(gamePlayers : List<Player>) {

        // get everyone's bet
        moneyPot += gamePlayers.map { it.getBet(minBet, multiplier) }.sum()

        // payout
        println("Pot at $moneyPot, multiplying by $multiplier")
        moneyPot *= multiplier
        println("Multiplied pot = $moneyPot")
        gamePlayers.forEach { it.earnWinnings(moneyPot / gamePlayers.size) }

        println("\n--------- Stats ---------")
        gamePlayers.forEach { println("Player $it") }
        moneyPot = 0.0
    }
}