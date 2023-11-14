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
    /*
    Instantiating and closing a new Scanner creates an error with System.in. Making the scanner a
    static variable eliminates the need to create a new scanner every time, reducing the risks of memory leak.
    Replace with a better solution when found.
     */
    private static final Scanner input = new Scanner(System.in);

    public static void waitForAnyUserInput() {
        Main.getOutput().displayOutput("Press enter to continue...");
        input.nextLine();
    }
}
