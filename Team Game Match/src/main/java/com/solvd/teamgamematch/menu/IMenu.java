package com.solvd.teamgamematch.menu;

import com.solvd.teamgamematch.regions.Region;
import com.solvd.teamgamematch.regions.Regions;

/**
 * Interface for the main menu of the program
 *
 * @version 1.0 4 Nov 2023
 * @author Lawrence Yim
 */

public interface IMenu {
    void displayMenu();
    int getUserChoice();
    void performUserChoice(int userChoice, Regions regions);
    void switchRegion(Regions regions);

}
