package edu.neumont.csc370;

import edu.neumont.csc370.model.Player;
import edu.neumont.csc370.model.PlayerFactory;
import edu.neumont.csc370.simulation.PhaseOneSimulation;

import java.util.List;

/**
 * Modified my sfox on 10/22/15
 * Created by jjensen on 10/21/15.
 */
public class Main {
    public static void main(String[] args) {

        List<List<? extends Player>> playersForPhase
                = PlayerFactory.INSTANCE.getPlayersForPhase("phase 1", 20.00);

        PhaseOneSimulation phaseOneSimulation = new PhaseOneSimulation();
        for ( List<? extends Player> players : playersForPhase ) {
            System.out.println("\n|||||||||| Spacer ||||||||||\n");
            phaseOneSimulation.runWithPlayerPool(players);
        }

    }
}
