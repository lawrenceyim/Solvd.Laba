package com.solvd.teamgamematch.game;

import java.util.ArrayList;

/**
 * Instantiate and store all the Champion objects
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class Champions {
    private static Champions instance;
    public static ArrayList<Champion> champions;

    static {
        instance = new Champions();
    }

    private Champions() {
        champions = new ArrayList<>();
        createChampions();
    }

    public static Champions getInstance() {
        if (instance == null) {
            instance = new Champions();
        }
        return instance;
    }

    public void createChampions () {
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
        champions.add(new Champion("Warwick", "Jungle", 580, 283,
                63, 0, 35, 32));
        champions.add(new Champion("Kennen", "Top", 541, 200,
                52, 0, 29, 30));
        champions.add(new Champion("Zed", "Mid", 584, 200,
                63, 0, 32, 30));
        champions.add(new Champion("Lucian", "ADC", 571, 348,
                61, 0, 26, 30));
        champions.add(new Champion("Leona", "Support", 576, 302,
                60, 0, 47, 30));
        champions.add(new Champion("Rengar", "Jungle", 585, 100,
                65, 0, 34, 32));
        champions.add(new Champion("Riven", "Top", 560, 250,
                64, 0, 33, 32));
        champions.add(new Champion("Syndra", "Mid", 511, 480,
                54, 0, 20, 30));
        champions.add(new Champion("Varus", "ADC", 537, 360,
                59, 0, 23, 30));
        champions.add(new Champion("Nami", "Support", 489, 365,
                48, 0, 19, 30));
        champions.add(new Champion("Nocturne", "Jungle", 585, 273,
                62, 0, 35, 32));
        champions.add(new Champion("Fiora", "Top", 550, 300,
                68, 0, 33, 32));
        champions.add(new Champion("Malzahar", "Mid", 537, 375,
                55, 0, 18, 30));
        champions.add(new Champion("Sivir", "ADC", 532, 284,
                63, 0, 26, 30));
        champions.add(new Champion("Sona", "Support", 482, 340,
                49, 0, 16, 30));
        champions.add(new Champion("Ekko", "Jungle", 585, 280,
                60, 0, 32, 32));
        champions.add(new Champion("Garen", "Top", 620, 0,
                57, 0, 36, 32));
        champions.add(new Champion("Akali", "Mid", 500, 200,
                62, 0, 22, 30));
        champions.add(new Champion("Ashe", "ADC", 539, 280,
                59, 0, 26, 30));
        champions.add(new Champion("Braum", "Support", 540, 310,
                55, 0, 47, 30));
        champions.add(new Champion("Graves", "Jungle", 551, 322,
                63, 0, 33, 32));
        champions.add(new Champion("Kled", "Top", 340, 100, 65, 0, 26, 30));
        champions.add(new Champion("Taliyah", "Mid", 532, 340,
                56, 0, 20, 30));
        champions.add(new Champion("Kai'Sa", "ADC", 500, 375,
                58, 0, 25, 30));
        champions.add(new Champion("Rakan", "Support", 510, 315,
                48, 0, 19, 30));
        champions.add(new Champion("Olaf", "Jungle", 597, 315,
                68, 0, 35, 32));
        champions.add(new Champion("Renekton", "Top", 572, 100,
                69, 0, 35, 32));
        champions.add(new Champion("Azir", "Mid", 552, 438,
                52, 0, 19, 30));
        champions.add(new Champion("Corki", "ADC", 512, 350,
                55, 0, 23, 30));
        champions.add(new Champion("Tahm Kench", "Support", 600, 315,
                56, 0, 47, 30));
        champions.add(new Champion("Hecarim", "Jungle", 580, 277,
                66, 0, 32, 32));
        champions.add(new Champion("Irelia", "Top", 580, 350,
                65, 0, 36, 32));
        champions.add(new Champion("Katarina", "Mid", 602, 0,
                58, 0, 27, 30));
    }

    public ArrayList<String> getChampionNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Champion c : champions) {
            names.add(c.getChampionName());
        }
        return names;
    }
}
