package edu.neumont.csc370;

import edu.neumont.csc370.model.Player;
import edu.neumont.csc370.model.PlayerFactory;
import edu.neumont.csc370.simulation.PhaseOneSimulation;
import edu.neumont.csc370.simulation.PhaseTwoSimulation;
import edu.neumont.csc370.simulation.SimulationConfigurationBundle;

import java.util.List;

/**
 * Modified my sfox on 10/22/15
 * Created by jjensen on 10/21/15.
 */
public class Main {
    public static void main(String[] args) {

//        phaseOneTrials();
        phaseTwoTrials();
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

    private static void phaseTwoTrials() {
        List<? extends Player> playersForPhaseTwo =
                PlayerFactory.INSTANCE.getPlayersForPhase("phase 2", 40.00).get(0);

        SimulationConfigurationBundle configuration = new SimulationConfigurationBundle(playersForPhaseTwo, 2.00, 1, 0, .20, 5.00, 0.00);
        PhaseTwoSimulation phaseTwoSimulation = new PhaseTwoSimulation(configuration);

        LOG.printMainLevel("Start Simulation");
        phaseTwoSimulation.run();
        LOG.printMainLevel("End Simulation");
    }
}
