package com.solvd.teamgamematch.menu;

import com.solvd.teamgamematch.Main;
import com.solvd.teamgamematch.exceptions.InvalidAccessLevel;
import com.solvd.teamgamematch.person.AccessLevel;
import com.solvd.teamgamematch.regions.Region;
import com.solvd.teamgamematch.regions.RegionName;
import com.solvd.teamgamematch.regions.Regions;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public abstract class CommandPromptMenu {
    public void switchAccessLevel() {
        Scanner input = Main.getInputScanner();
        Main.getOutput().displayOutput("Access Levels:" + System.lineSeparator() +
                "1. Administrator" + System.lineSeparator() +
                "2. Standard" + System.lineSeparator() +
                "3. Guest" + System.lineSeparator());
        try {
            int choice = input.nextInt();
            if (choice >= 1 && choice <= 3) {
                switch (choice) {
                    case 1:
                        Main.setAccessLevel(AccessLevel.Administrator);
                        break;
                    case 2:
                        Main.setAccessLevel(AccessLevel.Standard);
                        break;
                    case 3:
                        Main.setAccessLevel(AccessLevel.Guest);
                        break;
                    default:
                        throw new InvalidAccessLevel("Invalid access level provided");
                }
                Main.setMenu();
                Main.getOutput().displayOutput("Access level changed");
            } else {
                Main.getOutput().displayOutput("Invalid access level. Returning to main menu");
            }
        } catch (InputMismatchException e) {
            input.nextLine(); // clear input
            Main.getOutput().displayOutput("Invalid input. Returning to main menu");
        }
    }

    protected void getPlayerMatchHistory(Region region) {
        Scanner input = Main.getInputScanner();
        Main.getOutput().displayOutput("Enter the player's name:");
        input.nextLine(); // eliminate the \n from previous user input
        String name = input.nextLine().replace("\n", "").trim();
        region.getPlayerMatchHistory().displayPlayerMatchHistory(name);
    }

    protected void switchRegion(Regions regions) {
        Scanner input = Main.getInputScanner();
        Set<RegionName> set = regions.getRegions().keySet();
        RegionName[] regionNames = set.toArray(new RegionName[set.size()]);
        Main.getOutput().displayOutput("Regions:");
        for (int i = 1; i <= regionNames.length; i++) {
            Main.getOutput().displayOutput(i + ". " + regionNames[i - 1].getName());
        }
        try {
            int choice = input.nextInt();
            if (choice >= 1 && choice <= regionNames.length) {
                Main.getOutput().displayOutput("Switching regions to " + regionNames[choice - 1]);
                regions.setCurrentRegion(regionNames[choice - 1]);
            } else {
                Main.getOutput().displayOutput("Invalid region. Returning to main menu");
            }
        } catch (InputMismatchException e) {
            input.nextLine(); // clear input
            Main.getOutput().displayOutput("Invalid input. Returning to main menu");
        }
    }
}
