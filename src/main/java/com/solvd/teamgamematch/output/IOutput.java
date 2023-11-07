package com.solvd.teamgamematch.output;

/**
 * Interface to display output in the right format based on the display format being used
 * CommandPromptOutput class is for terminal or command prompt
 * Create and use a new class for a GUI program
 *
 * @version 1.0 4 Nov 2023
 * @author Lawrence Yim
 */

public interface IOutput {
    void displayError(String errorMessagee);
    void displayOutput(String message);
}
