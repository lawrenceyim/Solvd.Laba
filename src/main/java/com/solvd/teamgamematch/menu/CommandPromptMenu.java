package com.solvd.teamgamematch.menu;

import com.solvd.teamgamematch.exceptions.InvalidAccessLevel;
import com.solvd.teamgamematch.input.CurrentInput;
import com.solvd.teamgamematch.output.CurrentOutput;
import com.solvd.teamgamematch.person.AccessLevel;
import com.solvd.teamgamematch.regions.Region;
import com.solvd.teamgamematch.regions.RegionName;
import com.solvd.teamgamematch.regions.Regions;
import com.solvd.teamgamematch.user.CurrentUser;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public abstract class CommandPromptMenu {
    public final void switchAccessLevel() {
        Scanner input = CurrentInput.getCurrentInput();
        CurrentOutput.getCurrentOutput().displayOutput("Access Levels:" + System.lineSeparator() +
                "1. Administrator" + System.lineSeparator() +
                "2. Standard" + System.lineSeparator() +
                "3. Guest" + System.lineSeparator());
        try {
            int userChoice = input.nextInt();
            IIsValidInput checker = (choice) -> choice >= 1 && choice <= 3;
            if (checker.isValidInput(userChoice)) {
                switch (userChoice) {
                    case 1:
                        CurrentUser.setAccessLevel(AccessLevel.Administrator);
                        break;
                    case 2:
                        CurrentUser.setAccessLevel(AccessLevel.Standard);
                        break;
                    case 3:
                        CurrentUser.setAccessLevel(AccessLevel.Guest);
                        break;
                    default:
                        throw new InvalidAccessLevel("Invalid access level provided");
                }
                CurrentMenu.setMenu();
                CurrentOutput.getCurrentOutput().displayOutput("Access level changed");
            } else {
                CurrentOutput.getCurrentOutput().displayOutput("Invalid access level. Returning to main menu");
            }
        } catch (InputMismatchException e) {
            input.nextLine(); // clear input
            CurrentOutput.getCurrentOutput().displayOutput("Invalid input. Returning to main menu");
        }
    }

    protected final void getPlayerMatchHistory(Region region) {
        Scanner input = CurrentInput.getCurrentInput();
        CurrentOutput.getCurrentOutput().displayOutput("Enter the player's name:");
        input.nextLine(); // eliminate the \n from previous user input
        String name = input.nextLine().replace("\n", "").trim();
        region.getPlayerMatchHistory().displayPlayerMatchHistory(name);
    }

    protected final void switchRegion(Regions regions) {
        Scanner input = CurrentInput.getCurrentInput();
        Set<RegionName> set = regions.getRegions().keySet();
        RegionName[] regionNames = set.toArray(new RegionName[set.size()]);
        CurrentOutput.getCurrentOutput().displayOutput("Regions:");
        IntStream.rangeClosed(1, regionNames.length).forEach(i ->
                CurrentOutput.getCurrentOutput().displayOutput(i + ". " + regionNames[i - 1].getName()));
        try {
            int choice = input.nextInt();
            if (choice >= 1 && choice <= regionNames.length) {
                CurrentOutput.getCurrentOutput().displayOutput("Switching regions to " + regionNames[choice - 1]);
                regions.setCurrentRegion(regionNames[choice - 1]);
            } else {
                CurrentOutput.getCurrentOutput().displayOutput("Invalid region. Returning to main menu");
            }
        } catch (InputMismatchException e) {
            input.nextLine(); // clear input
            CurrentOutput.getCurrentOutput().displayOutput("Invalid input. Returning to main menu");
        }
    }
}
