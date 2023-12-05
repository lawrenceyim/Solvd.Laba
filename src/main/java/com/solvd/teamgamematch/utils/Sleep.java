package com.solvd.teamgamematch.utils;

import com.solvd.teamgamematch.output.CurrentOutput;

/**
 * Utility class for putting the Java program to sleep
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */
public class Sleep {
    public static void sleepForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            CurrentOutput.getCurrentOutput().displayError(e.getMessage());
        }
    }
}
