package com.solvd.teamgamematch;

import com.solvd.teamgamematch.employees.EmployeeManager;
import com.solvd.teamgamematch.exceptions.ConfigurationException;
import com.solvd.teamgamematch.game.champions.ChampionManager;
import com.solvd.teamgamematch.menu.CurrentMenu;
import com.solvd.teamgamematch.regions.Regions;
import com.solvd.teamgamematch.utils.Generator;

import java.io.File;

/**
 * Main method for the League of Legends match predictor
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */

public class Main {
    static {
        File file = new File("src/main/resources/log4j2.xml");
        if (!file.exists()) {
            throw new ConfigurationException("Missing log4j2.xml file");
        }
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Regions regions = new Regions();
    private static final EmployeeManager employeeManager = new EmployeeManager();

    public static void main(String[] args) {
        generateDefaultValues();

        while (true) {
            CurrentMenu.getCurrentMenu().displayMenu();
            int userChoice = CurrentMenu.getCurrentMenu().getUserChoice();
            if (userChoice == -1) {
                continue;
            }
            CurrentMenu.getCurrentMenu().performUserChoice(userChoice, regions);
        }
    }

    public static EmployeeManager getEmployeeManager() {
        return employeeManager;
    }

    private static void generateDefaultValues() {
        Generator.generateEmployees(employeeManager.getEmployees());
        Generator.generateChampions(ChampionManager.getInstance().getChampions());
        Generator.generateRegions(regions);
        Generator.generatePlayers(regions);
        Generator.generateMatches(regions);
    }
}
