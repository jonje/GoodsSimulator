package edu.neumont.csc370.simulation

import edu.neumont.csc370.model.Player

/**
 * the template that all of our Simulations should follow, for each phase
 * Created by stephen on 10/23/15.
 */
abstract class  Simulation(players : List<Player>, val multiplier : Double) {

    abstract fun run()
}