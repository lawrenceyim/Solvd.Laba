package com.solvd.teamgamematch.game;

import com.solvd.teamgamematch.game.abilities.*;

import java.util.ArrayList;

/**
 * Instantiate and store all the Champion objects
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class ChampionManager {
    private static ChampionManager instance;
    public static ArrayList<Champion> champions;

    static {
        instance = new ChampionManager();
    }

    private ChampionManager() {
        champions = new ArrayList<>();
        createChampions();
    }

    public static ChampionManager getInstance() {
        if (instance == null) {
            instance = new ChampionManager();
        }
        return instance;
    }

    public void createChampions () {
        champions.add(new Champion("Aatrox", "Top", 580, 100,
                60, 0, 38, 32, new TheDarkinBlade()));
        champions.add(new Champion("Zoe", "Mid", 560, 495,
                58, 0, 20, 30, new PaddleStar()));
        champions.add(new Champion("Jinx", "ADC", 517, 245,
                63, 0, 22, 30, new Switcheroo()));
        champions.add(new Champion("Thresh", "Support", 560, 273,
                55, 0, 16, 30, new DeathSentence()));
        champions.add(new Champion("Lee Sin", "Jungle", 570, 200,
                65, 0, 36, 32, new SonicWaveResonatingStrike()));
        champions.add(new Champion("Ahri", "Mid", 526, 418,
                53, 0, 20, 30, new OrbOfDeception()));
        champions.add(new Champion("Caitlyn", "ADC", 481, 313,
                63, 0, 22, 30, new PiltoverPeacemaker()));
        champions.add(new Champion("Lulu", "Support", 535, 350,
                47, 0, 19, 30, new Glitterlance()));
        champions.add(new Champion("Jarvan IV", "Jungle", 571, 302,
                64, 0, 33, 32, new DragonStrike()));
        champions.add(new Champion("Darius", "Top", 582, 263,
                64, 0, 39, 32, new Decimate()));
        champions.add(new Champion("Orianna", "Mid", 530, 418,
                48, 0, 17, 30, new CommandAttack()));
        champions.add(new Champion("Ezreal", "ADC", 500, 375,
                56, 0, 22, 30, new MysticShot()));
        champions.add(new Champion("Janna", "Support", 500, 350,
                45, 0, 16, 30, new HowlingGale()));
    }

    public ArrayList<String> getChampionNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Champion c : champions) {
            names.add(c.getChampionName());
        }
        return names;
    }
}
