package com.solvd.teamgamematch.menu;

import com.solvd.teamgamematch.employees.Employee;
import com.solvd.teamgamematch.employees.EmployeeManager;
import com.solvd.teamgamematch.exceptions.InvalidInputException;
import com.solvd.teamgamematch.game.MatchMaking;
import com.solvd.teamgamematch.input.CurrentInput;
import com.solvd.teamgamematch.output.CurrentOutput;
import com.solvd.teamgamematch.regions.Regions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdministratorMenu extends CommandPromptMenu implements IMenu {
    @Override
    public void displayMenu() {
        CurrentOutput.getCurrentOutput().displayOutput("League of Legends simulator");
        CurrentOutput.getCurrentOutput().displayOutput("Access Level: Administrator");
        CurrentOutput.getCurrentOutput().displayOutput("1. New Match");
        CurrentOutput.getCurrentOutput().displayOutput("2. View Players Stats");
        CurrentOutput.getCurrentOutput().displayOutput("3. View Champion Win Rates");
        CurrentOutput.getCurrentOutput().displayOutput("4. View Player Match History");
        CurrentOutput.getCurrentOutput().displayOutput("5. View Employees");
        CurrentOutput.getCurrentOutput().displayOutput("6. Switch Region");
        CurrentOutput.getCurrentOutput().displayOutput("7. Switch Access Level");
        CurrentOutput.getCurrentOutput().displayOutput("8. Exit Program");
    }

    @Override
    public int getUserChoice() {
        Scanner input = CurrentInput.getCurrentInput();
        try {
            int userChoice = input.nextInt();
            IIsValidInput checker = (choice) -> choice >= 1 && choice <= 8;
            if (!checker.isValidInput(userChoice)) {
                CurrentOutput.getCurrentOutput().displayOutput("Invalid selection");
                return -1;
            }
            return userChoice;
        } catch (InputMismatchException e) {
            input.nextLine(); // clear input
            CurrentOutput.getCurrentOutput().displayOutput("Invalid input");
            return -1;
        }
    }

    @Override
    public void performUserChoice(int userChoice, Regions regions) {
        Scanner input = CurrentInput.getCurrentInput();
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
                CurrentOutput.getCurrentOutput().displayOutput("Exiting");
                input.close();
                System.exit(0);
            default:
                throw new InvalidInputException("Invalid menu selection");
        }
    }

    private void displayEmployees() {
        ArrayList<Employee> employees = EmployeeManager.getInstance().getEmployees();
        StringBuilder sb = new StringBuilder();
        sb.append("Employees:").append(System.lineSeparator());
        employees.stream().forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));
        CurrentOutput.getCurrentOutput().displayOutput(sb.toString());
    }
}
