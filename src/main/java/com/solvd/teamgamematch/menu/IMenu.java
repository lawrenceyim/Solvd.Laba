package com.solvd.teamgamematch.menu;

import com.solvd.teamgamematch.regions.Regions;

/**
 * Interface for the main menu of the program
 *
 * @author Lawrence Yim
 * @version 1.0 4 Nov 2023
 */

public interface IMenu {
    void displayMenu();

    int getUserChoice();

    void performUserChoice(int userChoice, Regions regions);

    void switchRegion(Regions regions);

}
