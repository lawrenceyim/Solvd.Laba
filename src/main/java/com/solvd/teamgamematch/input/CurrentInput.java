package com.solvd.teamgamematch.input;

import java.util.Scanner;

public class CurrentInput {
    private static Scanner input = new Scanner(System.in);

    public static Scanner getCurrentInput() {
        return input;
    }
}
