package edu.neumont.csc370.simulation

import edu.neumont.csc370.LOG
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
        LOG.printSimLevel("Pot at $moneyPot, multiplying by $multiplier")
        moneyPot *= multiplier
        LOG.printSimLevel("Multiplied pot = $moneyPot")
        gamePlayers.forEach { it.earnWinnings(moneyPot / gamePlayers.size) }

        LOG.printSimLevel("\n--------- Stats ---------")
        gamePlayers.forEach { LOG.printSimLevel("Player $it") }
        moneyPot = 0.0
    }
}