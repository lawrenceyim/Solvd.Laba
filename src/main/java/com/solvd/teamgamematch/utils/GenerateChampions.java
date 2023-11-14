package com.solvd.teamgamematch.utils;

import com.solvd.teamgamematch.game.champions.Champion;

import java.util.ArrayList;

public class GenerateChampions {

    public static ArrayList<Champion> generateChampions() {
        ArrayList<Champion> champions = new ArrayList<>();
        champions.add(new Champion("Aatrox", "Top", 580, 100,
                60, 0, 38, 32));
        champions.add(new Champion("Zoe", "Mid", 560, 495,
                58, 0, 20, 30));
        champions.add(new Champion("Jinx", "ADC", 517, 245,
                63, 0, 22, 30));
        champions.add(new Champion("Thresh", "Support", 560, 273,
                55, 0, 16, 30));
        champions.add(new Champion("Lee Sin", "Jungle", 570, 200,
                65, 0, 36, 32));
        champions.add(new Champion("Ahri", "Mid", 526, 418,
                53, 0, 20, 30));
        champions.add(new Champion("Caitlyn", "ADC", 481, 313,
                63, 0, 22, 30));
        champions.add(new Champion("Lulu", "Support", 535, 350,
                47, 0, 19, 30));
        champions.add(new Champion("Jarvan IV", "Jungle", 571, 302,
                64, 0, 33, 32));
        champions.add(new Champion("Darius", "Top", 582, 263,
                64, 0, 39, 32));
        champions.add(new Champion("Orianna", "Mid", 530, 418,
                48, 0, 17, 30));
        champions.add(new Champion("Ezreal", "ADC", 500, 375,
                56, 0, 22, 30));
        champions.add(new Champion("Janna", "Support", 500, 350,
                45, 0, 16, 30));
        return champions;
    }
}
