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
        new Scanner(System.in).nextLine();
    }
}
