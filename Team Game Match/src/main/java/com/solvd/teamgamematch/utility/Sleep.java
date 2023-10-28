package com.solvd.teamgamematch.utility;

public class Sleep {
    public static void sleepForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }
}
