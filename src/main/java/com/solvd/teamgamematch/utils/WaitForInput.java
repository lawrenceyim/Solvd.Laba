package com.solvd.teamgamematch.utils;

import com.solvd.teamgamematch.Main;

import java.util.Scanner;

/**
 * Makes the program wait for user input before resuming
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */

public class WaitForInput {
    public static void waitForAnyUserInput() {
        Scanner input = Main.getInputScanner();
        input.nextLine(); // Clear user input
        Main.getOutput().displayOutput("Press enter to continue...");
        input.nextLine();
    }
}
