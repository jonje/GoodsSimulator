package edu.neumont.csc370.simulation

import edu.neumont.csc370.LOG
import edu.neumont.csc370.model.Player
import java.util.*

/**
 * Created by stephen on 10/23/15.
 */
class PhaseThreeSimulation(val configuration : SimulationConfigurationBundle)
    : Simulation(configuration.players, configuration.multiplier) {
    var moneyPot = 0.0

    override fun run() {
        configuration.print()
        LOG.printSimLevel("")

        for(i in 0..configuration.numOfIterations) {
            LOG.printSimLevel("New sim round: $i")

            val playerBetPairs: ArrayList<Pair<Player, Double>> = ArrayList()
            for (player in configuration.players) {
                val currentBet = player.getBet(configuration.minimumEntry, this.multiplier)

                if ( currentBet >= configuration.minimumEntry) {
                    moneyPot += currentBet
                    playerBetPairs.add(Pair(player, currentBet))
                }
            }

            this.payOut(playerBetPairs)
            LOG.printSimLevel("Players current amounts")
            this.printPlayers()
            LOG.printSimLevel("End of round")
            moneyPot = 0.0
        }
    }

    private fun payOut(playerBetPairs : ArrayList<Pair<Player, Double>>) : Unit {
        val lotteryPot = moneyPot * this.multiplier

        LOG.printSimLevel(java.lang.String.format("Lottery pot is: %.2f", lotteryPot))
        LOG.printSimLevel("Paying out to players...")

        //I did the payout this way deliberately
        //Pros: The print output makes more sense
        //Cons: We loop through the playerBetPairs twice, and payPercentageRewards is doing two things (payout out + returning highestContributor)
        if(playerBetPairs.size > 0) {
            val highestContributor = this.payPercentageRewards(playerBetPairs)
            this.payDistribution(playerBetPairs)

            LOG.printSimLevel("Paying out flat reward to highest contribution $highestContributor")
            highestContributor.earnWinnings(configuration.flatReward)
        }
        this.depreciatePlayers()
    }

    //Pays out percentage rewards AND returns highest contributor. This is so that more loops over the player bet pairs
    //are not necessary
    private fun payPercentageRewards(playerBetPairs: ArrayList<Pair<Player, Double>>) : Player {
        LOG.printSimLevel("Paying out percentage rewards")
        var highestContribution : Pair<Player, Double> = playerBetPairs.first()

        for ((player, bet) in playerBetPairs) {
            player.earnWinnings(bet * configuration.percentageReward)

            if (bet > highestContribution.second)
                highestContribution = Pair(player, bet)
        }

        return highestContribution.first;
    }

    private fun payDistribution(playerBetPairs: ArrayList<Pair<Player, Double>>) : Unit {
        LOG.printSimLevel("Paying out equal shares of the pot")
        val lotteryPot = moneyPot * this.multiplier
        for ((player, bet) in playerBetPairs) {
            player.earnWinnings(lotteryPot / playerBetPairs.size())
        }
    }

    private fun depreciatePlayers() {
        LOG.printSimLevel("Removing flat amount from players' total ")
        for (player in configuration.players) {
            player.reduceMoney(configuration.depreciationLevel)
        }
    }

    private fun payOutInSingleLoop(playerBetPairs: ArrayList<Pair<Player, Double>>): Player {
        val lotteryPot = moneyPot * this.multiplier
        var highestContribution : Pair<Player, Double> = playerBetPairs.first()

        for ((player, bet) in playerBetPairs) {
            player.earnWinnings(bet * configuration.percentageReward)
            player.earnWinnings(lotteryPot / playerBetPairs.size())

            if (bet > highestContribution.second)
                highestContribution = Pair(player, bet)
        }

        return highestContribution.first;
    }

    private fun printPlayers() : Unit {
        for(player in configuration.players) {
            LOG.printPlayerLevel(player.toString())
        }
    }
}