package edu.neumont.csc370.simulation

import edu.neumont.csc370.model.Player

/**
 * Created by stephen on 10/23/15.
 */
class PhaseOneSimulation : Simulation(multiplier = 2.0) {
    var moneyPot = 0.0

    override fun runWithPlayerPool(gamePlayers : List<Player>) {
//        val idToPlayers = gamePlayers.toMap({ it.id}, {it})

        // get everyone's bet
        moneyPot += gamePlayers.map { it.bet }.sum()

        // payout
        moneyPot *= 2
        gamePlayers.forEach { it.earnWinnings(moneyPot / gamePlayers.size) }

        println("\n--------- Stats ---------")
        gamePlayers.forEach { println("Player $it") }
    }
}