package edu.neumont.csc370;

import edu.neumont.csc370.model.Player;
import edu.neumont.csc370.model.PlayerFactory;
import edu.neumont.csc370.simulation.PhaseOneSimulation;
import edu.neumont.csc370.simulation.PhaseTwoSimulation;
import edu.neumont.csc370.simulation.SimulationBundledConfiguration;

import java.util.List;

/**
 * Modified my sfox on 10/22/15
 * Created by jjensen on 10/21/15.
 */
public class Main {
    public static void main(String[] args) {

        phaseOneTrials();

        List<? extends Player> playersForPhaseTwo =
                PlayerFactory.INSTANCE.getPhaseTwoPlayers(40.00);

        SimulationBundledConfiguration configuration = new
                SimulationBundledConfiguration(playersForPhaseTwo, 2.00, 1, 0, .20, 5.00);

        PhaseTwoSimulation phaseTwoSimulation = new PhaseTwoSimulation(configuration);

    }

    private static void phaseOneTrials() {
        List<List<? extends Player>> playersForPhase
                = PlayerFactory.INSTANCE.getPlayersForPhase("phase 1", 20.00);

        PhaseOneSimulation phaseOneSimulation;
        for ( List<? extends Player> players : playersForPhase ) {
            phaseOneSimulation = new PhaseOneSimulation(players);
            System.out.println("\n|||||||||| Spacer ||||||||||\n");
            phaseOneSimulation.run();
        }
    }
}
