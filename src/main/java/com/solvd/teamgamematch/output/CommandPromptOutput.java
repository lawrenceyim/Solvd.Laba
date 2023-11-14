package com.solvd.teamgamematch.output;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

/**
 * Display output to the command prompt or terminal
 * All terminal output should use displayOutput() instead of System.out.println()
 *
 * @version 1.0 3 Nov 2023
 * @author Lawrence Yim
 */


public class CommandPromptOutput implements IOutput {
    private static final org.apache.logging.log4j.core.Logger LOGGER = (Logger) LogManager.getRootLogger();
    private static final org.apache.logging.log4j.core.Logger OUTPUT_LOGGER = (Logger) LogManager.getLogger("Output");

    @Override
    public void displayError(String errorMessage) {
        LOGGER.debug(errorMessage);
    }

    @Override
    public void displayOutput(String message) {
        OUTPUT_LOGGER.trace(message);
    }
}
