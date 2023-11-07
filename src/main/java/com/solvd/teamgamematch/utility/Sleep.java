package com.solvd.teamgamematch.utility;

import com.solvd.teamgamematch.Main;

/**
 * Utility class for putting the Java program to sleep
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */
public class Sleep {
    public static void sleepForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Main.getOutput().displayError(e.getMessage());
        }
    }
}
