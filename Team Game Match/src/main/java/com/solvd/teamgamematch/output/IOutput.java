package com.solvd.teamgamematch.output;

/**
 * Interface to display output in the right format based on the display format being used
 * E.g. Main.getOutput().displayOutput() for terminal or command prompt, different from output for a GUI program
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public interface IOutput {
    void displayOutput(String message);
}
