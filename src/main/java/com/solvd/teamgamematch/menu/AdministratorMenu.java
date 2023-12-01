package com.solvd.teamgamematch.menu;

import com.solvd.teamgamematch.Main;
import com.solvd.teamgamematch.employees.Employee;
import com.solvd.teamgamematch.exceptions.InvalidInputException;
import com.solvd.teamgamematch.game.MatchMaking;
import com.solvd.teamgamematch.regions.Regions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdministratorMenu extends CommandPromptMenu implements IMenu {
    @Override
    public void displayMenu() {
        Main.getOutput().displayOutput("League of Legends simulator");
        Main.getOutput().displayOutput("Access Level: Administrator");
        Main.getOutput().displayOutput("1. New Match");
        Main.getOutput().displayOutput("2. View Players Stats");
        Main.getOutput().displayOutput("3. View Champion Win Rates");
        Main.getOutput().displayOutput("4. View Player Match History");
        Main.getOutput().displayOutput("5. View Employees");
        Main.getOutput().displayOutput("6. Switch Region");
        Main.getOutput().displayOutput("7. Switch Access Level");
        Main.getOutput().displayOutput("8. Exit Program");
    }

    @Override
    public int getUserChoice() {
        Scanner input = Main.getInputScanner();
        try {
            int userChoice = input.nextInt();
            IIsValidInput checker = (choice) -> choice >= 1 && choice <= 8;
            if (!checker.isValidInput(userChoice)) {
                Main.getOutput().displayOutput("Invalid selection");
                return -1;
            }
            return userChoice;
        } catch (InputMismatchException e) {
            input.nextLine(); // clear input
            Main.getOutput().displayOutput("Invalid input");
            return -1;
        }
    }

    @Override
    public void performUserChoice(int userChoice, Regions regions) {
        Scanner input = Main.getInputScanner();
        switch (userChoice) {
            case 1:
                MatchMaking.matchMake(regions.getCurrentRegion());
                break;
            case 2:
                regions.getCurrentRegion().getPlayerStats().displayStats();
                break;
            case 3:
                regions.getCurrentRegion().getChampionStats().displayStats();
                break;
            case 4:
                getPlayerMatchHistory(regions.getCurrentRegion());
                break;
            case 5:
                displayEmployees();
                break;
            case 6:
                switchRegion(regions);
                break;
            case 7:
                switchAccessLevel();
                break;
            case 8:
                Main.getOutput().displayOutput("Exiting");
                input.close();
                System.exit(0);
            default:
                throw new InvalidInputException("Invalid menu selection");
        }
    }

    private void displayEmployees() {
        ArrayList<Employee> employees = Main.getEmployeeManager().getEmployees();
        StringBuilder sb = new StringBuilder();
        sb.append("Employees:").append(System.lineSeparator());
        for (Employee employee : employees) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }
        Main.getOutput().displayOutput(sb.toString());
    }
}
