package edu.neumont.csc370;

import edu.neumont.csc370.model.Player;
import edu.neumont.csc370.model.PlayerFactory;

import java.util.List;

/**
 * Created by jjensen on 10/21/15.
 */
public class Main {
    public static void main(String[] args) {

        List<Player> playersForPhase = PlayerFactory.INSTANCE.getPlayersForPhase("phase 1");

        for ( Player aPlayer : playersForPhase ) {
            System.out.println(aPlayer);
        }
    }
}
