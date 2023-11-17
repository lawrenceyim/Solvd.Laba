package com.solvd.teamgamematch.output;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

/**
 * Display output to the command prompt or terminal
 * All terminal output should use displayOutput() instead of System.out.println()
 *
 * @author Lawrence Yim
 * @version 1.0 3 Nov 2023
 */


public class CommandPromptOutput implements IOutput {
    private static final Logger LOGGER = (Logger) LogManager.getRootLogger();
    private static final Logger OUTPUT_LOGGER = (Logger) LogManager.getLogger("Output");

    @Override
    public void displayError(String errorMessage) {
        LOGGER.debug(errorMessage);
    }

    @Override
    public void displayOutput(String message) {
        OUTPUT_LOGGER.trace(message);
    }
}
