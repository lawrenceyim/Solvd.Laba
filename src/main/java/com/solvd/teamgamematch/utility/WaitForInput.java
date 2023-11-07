package com.solvd.teamgamematch.utility;

import com.solvd.teamgamematch.Main;

import java.util.Scanner;

/**
 * Makes the program wait for user input before resuming
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
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
