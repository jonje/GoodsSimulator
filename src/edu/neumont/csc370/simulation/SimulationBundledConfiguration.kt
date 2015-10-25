package edu.neumont.csc370.simulation

import edu.neumont.csc370.model.Player

/**
 * Created by stephen on 10/23/15.
 */
class SimulationBundledConfiguration(
        var players : List<Player>,
        val multiplier : Double,
        val numOfIterations : Int = 1,
        val flatReward : Double = 0.0,
        val percentageReward : Double = 0.0,
        val minimumEntry : Double = 0.0 ) {

    companion object Factory {
        // different than Scala in this regard
    }
}
