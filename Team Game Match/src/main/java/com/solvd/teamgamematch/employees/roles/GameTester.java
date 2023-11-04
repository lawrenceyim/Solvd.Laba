package com.solvd.teamgamematch.employees.roles;

import com.solvd.teamgamematch.Main;

/**
 * Game Tester role
 *
 * @version 1.0 31 Oct 2023
 * @author Lawrence Yim
 */

public class GameTester extends Role {
    public GameTester() {
        super("Game Tester",
                "Thoroughly test game features and functionality\n" +
                "Identify and report any software glitches\n" +
                "Try out different graphic settings to check system stability in varying load conditions\n" +
                "Communicate findings to the developers and product team members\n" +
                "Provide feedback to developers on game balance and overall fun factor\n");
    }

    @Override
    public void doWork(String employeeName) {
        Main.getOutput().displayOutput(employeeName + " tested a new feature");
    }
}
