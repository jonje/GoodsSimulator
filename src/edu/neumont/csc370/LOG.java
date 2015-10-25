package edu.neumont.csc370;

/**
 * Created by gh255013 on 10/25/15.
 */
public class LOG {
    public static boolean mainLevel = true;
    public static boolean simLevel = true;
    public static boolean playerLevel = true;

    public static void printMainLevel(String message) {
        if(LOG.mainLevel)
            System.out.println(message);
    }

    public static void printSimLevel(String message) {
        if(LOG.simLevel)
            System.out.println("\t" + message);
    }

    public static void printPlayerLevel(String message) {
        if(LOG.playerLevel)
            System.out.println("\t\t" + message);
    }
}