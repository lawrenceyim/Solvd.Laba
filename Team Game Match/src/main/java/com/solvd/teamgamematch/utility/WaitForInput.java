package com.solvd.teamgamematch.utility;

import java.util.Scanner;

/**
 * Makes the program wait for user input before resuming
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class WaitForInput {
    public static void waitForAnyUserInput() {
        System.out.println("Press enter to continue...");
        /*
        TODO: Scanner should be closed after it's used, but it shares System.in
         with the scanner in the Main class. Closing this creates an error.
         Figure out a solution for this problem
         */
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
}
