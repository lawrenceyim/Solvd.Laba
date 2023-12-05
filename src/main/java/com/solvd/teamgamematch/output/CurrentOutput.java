package com.solvd.teamgamematch.output;

public class CurrentOutput {
    private static IOutput currentOutput;

    public static IOutput getCurrentOutput() {
        if (currentOutput == null) {
            currentOutput = new CommandPromptOutput();
        }
        return currentOutput;
    }

    public static void setCurrentOutput(IOutput output) {
        currentOutput = output;
    }
}
