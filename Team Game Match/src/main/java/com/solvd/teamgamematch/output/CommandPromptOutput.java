package com.solvd.teamgamematch.output;

/**
 * Display output to the command prompt or terminal
 *
 * @version 1.0 3 Nov 2023
 * @author Lawrence Yim
 */


public class CommandPromptOutput implements IOutput {

    @Override
    public void displayOutput(String message) {
        System.out.println(message);
    }
}
