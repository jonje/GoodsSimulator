package edu.neumont.csc370.simulation

import edu.neumont.csc370.LOG
import edu.neumont.csc370.model.Player
import edu.neumont.csc370.model.PlayerFactory
import java.util.*

/**
 * Created by stephen on 10/23/15.
 */
class SimulationConfigurationBundle(
        var players : List<Player>,
        val multiplier : Double,
        val numOfIterations : Int = 1,
        val flatReward : Double = 0.0,
        val percentageReward : Double = 0.0,
        val minimumEntry : Double = 0.0,
        val depreciationLevel : Double = 0.0) {

    companion object Factory {
        // different than Scala in this regard, where they have the same name
        fun generateBundles(playerStartingCash: Double, flatRewardRange : IntRange, percentageRangeCeiling : Double,
                            minimumEntryRange : IntRange, depreciationLevelCeiling : Double,
                            multiplierRange: DoubleRange, numOfIterations : Int) {
            val rangeSliceCount = 5

            val yeildList : MutableList<SimulationConfigurationBundle> =
                    ArrayList(flatRewardRange.end * rangeSliceCount * (minimumEntryRange.end - minimumEntryRange.start))

            // SCRATCH: note, the Range<T> type has a ".increment" property. Use that instead?
            for (reward in flatRewardRange step ((flatRewardRange.end - flatRewardRange.start) / rangeSliceCount)) {

                for (percent in 0.0.rangeTo(percentageRangeCeiling).step(percentageRangeCeiling / rangeSliceCount)) {

                    for (painPayment in 0.0.rangeTo(depreciationLevelCeiling).step(depreciationLevelCeiling / rangeSliceCount)) {

                        for (minimum in minimumEntryRange) {

                            for (multiplier in multiplierRange) {

                                yeildList.add(SimulationConfigurationBundle(
                                        PlayerFactory.getPhaseTwoPlayers(playerStartingCash),
                                        multiplier,
                                        numOfIterations,
                                        reward.toDouble(),
                                        percent,
                                        minimum.toDouble(),
                                        painPayment
                                ))

                            }

                        }

                    }

                }

            }

        }
    }

    public fun print() : Unit {
        LOG.printSimLevel("SIMULATION CONFIG")
        LOG.printSimLevel("Players:")

        for(player in players) {
            LOG.printPlayerLevel("\t" + player)
        }

        LOG.printSimLevel("Pot Multiplier: " + multiplier)
        LOG.printSimLevel("Number of Iterations: " + numOfIterations)
        LOG.printSimLevel("Flat Reward: " + flatReward)
        LOG.printSimLevel("Percentage Reward: " + percentageReward)
        LOG.printSimLevel("Minimum Entry: " + minimumEntry)
        LOG.printSimLevel("Depreciation each turn: " + depreciationLevel)

        LOG.printSimLevel("END CONFIG")
    }
}
