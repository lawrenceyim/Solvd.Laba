package com.solvd.teamgamematch.employees.roles;

import com.solvd.teamgamematch.Main;

/**
 * Artist role
 *
 * @version 1.0 31 Oct 2023
 * @author Lawrence Yim
 */

public class Artist extends Role {
    public Artist() {
        super("Artist",
                "Collaborate with other artists and graphic designers\n" +
                        "Create sketches for storyboards\n" +
                        "Turn sketches into 2D or 3D computer graphics");
    }

    @Override
    public void doWork(String employeeName) {
        Main.getOutput().displayOutput(employeeName + " drew another concept model for a character.");
    }
}
