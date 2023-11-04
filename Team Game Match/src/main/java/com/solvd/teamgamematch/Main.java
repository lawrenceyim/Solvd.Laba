package com.solvd.teamgamematch;

import com.solvd.teamgamematch.menu.CommandPromptMenu;
import com.solvd.teamgamematch.menu.IMenu;
import com.solvd.teamgamematch.output.CommandPromptOutput;
import com.solvd.teamgamematch.output.IOutput;

/**
 * Main method for the League of Legends match predictor
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class Main {
    private static IOutput output;
    public static void main(String[] args) {
        output = new CommandPromptOutput();
        IMenu menu = new CommandPromptMenu();
        menu.menuLoop();
    }

    public static IOutput getOutput() {
        if (output == null) {
            output = new CommandPromptOutput();
        }
        return output;
    }
}
