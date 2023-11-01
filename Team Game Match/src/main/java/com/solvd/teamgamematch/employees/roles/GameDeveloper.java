package com.solvd.teamgamematch.employees.roles;

public class GameDeveloper extends Role {
    public GameDeveloper() {
        super("Game Developer", "Understand the game requirement.\n" +
                "Translate visual ideas into code\n" +
                "Prototype, iterate, and polish gameplay\n" +
                "Solving the bugs and errors in the game\n" +
                "Collaborate with designers, producers, artists, and game testers\n" +
                "Monitor game stability across platforms\n" +
                "Review existing code and recommend improvements");
    }

    @Override
    public void doWork(String employeeName) {
        System.out.println(employeeName + " implemented a new feature.");
    }
}
