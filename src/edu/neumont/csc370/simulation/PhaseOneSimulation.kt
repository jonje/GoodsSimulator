package edu.neumont.csc370.simulation

import edu.neumont.csc370.model.Player

/**
 * Created by stephen on 10/23/15.
 */
class PhaseOneSimulation : Simulation(multiplier = 2.0) {
    var moneyPot = 0.0

    override fun runWithPlayerPool(gamePlayers : List<Player>) {
        // TODO get each player's bet
        val idToBetMap = gamePlayers.toMap({ it.id}, {it.bet})

        // payout
    }
}