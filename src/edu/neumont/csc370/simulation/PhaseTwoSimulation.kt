package edu.neumont.csc370.simulation

import edu.neumont.csc370.model.Player
import java.util.*

/**
 * Created by stephen on 10/23/15.
 */
class PhaseTwoSimulation(val configuration : SimulationBundledConfiguration)
    : Simulation(configuration.players, configuration.multiplier) {

    var moneyPot = 0.0

    override fun run() {
        // check the minimum that everyone is putting in, and make a new list
        // containing the qualified. Accumulate the money pot at the same time

        val playerBetPairs : ArrayList<Pair<Player, Double>> = ArrayList()
        for (player in configuration.players) {
            val currentBet = player.getBet(configuration.minimumEntry, this.multiplier)

            if ( currentBet > configuration.minimumEntry) {
                moneyPot += currentBet
                playerBetPairs.add(Pair(player, currentBet))
            }
        }

        this.payOut(playerBetPairs)
    }

    private fun payOut(playerBetPairs : ArrayList<Pair<Player, Double>>) : Unit {
        val lotteryPot = moneyPot * this.multiplier
        var biggestContribution : Pair<Player, Double> = playerBetPairs.first()

        for ((player, bet) in playerBetPairs) {
            player.earnWinnings(bet * configuration.percentageReward)
            player.earnWinnings(lotteryPot / playerBetPairs.size)
            
            if (bet > biggestContribution.second)
                biggestContribution = Pair(player, bet)
        }

        biggestContribution.first.earnWinnings(configuration.flatReward)
    }
}