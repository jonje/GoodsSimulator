package edu.neumont.csc370;

import edu.neumont.csc370.model.AdaptivePlayer;
import edu.neumont.csc370.model.Player;

/**
 * Created by gh255013 on 10/24/15.
 */
public class Test {
    public static void main(String[] args) {
        Player player = new AdaptivePlayer(20, .25);
        System.out.println(player.getBet(5, 2));
    }
}
