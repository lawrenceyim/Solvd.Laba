package com.solvd.teamgamematch.employees.roles;

public class GameTester extends Role {
    public GameTester() {
        super("Game Tester", "Thoroughly testing game features and functionality\n" +
                "Completing all in-game missions and side-missions, possibly multiple times\n" +
                "Identifying and reporting any software glitches\n" +
                "Exploring different ways to approach the game, such as trying it with other in-game characters\n" +
                "Playing the game for long periods to identify any issues that may arise\n" +
                "Trying out different graphic settings to check system stability in varying load conditions\n" +
                "Playing the game with all difficulty levels\n" +
                "Writing detailed reports on their findings\n" +
                "Verbally communicating findings to the developers and product team members\n" +
                "Providing feedback to developers on game balance and overall fun factor\n" +
                "Reporting any stability issues");
    }

    @Override
    public void doWork(String employeeName) {
        System.out.println(employeeName + " tested a new feature");
    }
}
