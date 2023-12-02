package com.solvd.teamgamematch.utils;

import com.solvd.teamgamematch.employees.Employee;
import com.solvd.teamgamematch.game.MatchMaking;
import com.solvd.teamgamematch.game.champions.Champion;
import com.solvd.teamgamematch.game.champions.ChampionManager;
import com.solvd.teamgamematch.game.champions.ChampionRole;
import com.solvd.teamgamematch.game.players.Player;
import com.solvd.teamgamematch.person.AccessLevel;
import com.solvd.teamgamematch.regions.Region;
import com.solvd.teamgamematch.regions.RegionName;
import com.solvd.teamgamematch.regions.Regions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {
    public static ArrayList<Champion> generateChampions() {
        ArrayList<Champion> champions = new ArrayList<>();
        champions.add(new Champion("Aatrox", ChampionRole.TOP, 580, 100,
                60, 0, 38, 32));
        champions.add(new Champion("Zoe", ChampionRole.MID, 560, 495,
                58, 0, 20, 30));
        champions.add(new Champion("Jinx", ChampionRole.ADC, 517, 245,
                63, 0, 22, 30));
        champions.add(new Champion("Thresh", ChampionRole.SUPP, 560, 273,
                55, 0, 16, 30));
        champions.add(new Champion("Lee Sin", ChampionRole.JG, 570, 200,
                65, 0, 36, 32));
        champions.add(new Champion("Ahri", ChampionRole.MID, 526, 418,
                53, 0, 20, 30));
        champions.add(new Champion("Caitlyn", ChampionRole.ADC, 481, 313,
                63, 0, 22, 30));
        champions.add(new Champion("Lulu", ChampionRole.SUPP, 535, 350,
                47, 0, 19, 30));
        champions.add(new Champion("Jarvan IV", ChampionRole.JG, 571, 302,
                64, 0, 33, 32));
        champions.add(new Champion("Darius", ChampionRole.TOP, 582, 263,
                64, 0, 39, 32));
        champions.add(new Champion("Orianna", ChampionRole.MID, 530, 418,
                48, 0, 17, 30));
        champions.add(new Champion("Ezreal", ChampionRole.ADC, 500, 375,
                56, 0, 22, 30));
        champions.add(new Champion("Janna", ChampionRole.SUPP, 500, 350,
                45, 0, 16, 30));
        return champions;
    }

    public static HashMap<String, Integer> generateChampionMastery() {
        Random random = new Random();
        ArrayList<String> championNames = ChampionManager.getInstance().getChampionNames();
        Map<String, Integer> championMastery = championNames.stream()
                .collect(Collectors.toMap(
                        championName -> championName,
                        championName -> random.nextInt(10) + 1 // Random number between 1-10
                ));
        return new HashMap<>(championMastery);
    }

    public static ArrayList<Player> generatePlayers(int count) {
        if (count < 10) {
            count = 10;  // Minimum number of players needed to create two teams of 5
        }
        ArrayList<Player> players = new ArrayList<>();
        IntStream.rangeClosed(0, 15)
                .forEach(i -> players.add(new Player("RandomName" + i, "Player " + i)));
        return players;
    }

    public static void generateRegions(Regions regions) {
        regions.addRegion(RegionName.NA);
        regions.addRegion(RegionName.EU);
        regions.addRegion(RegionName.SA);
        regions.addRegion(RegionName.OCE);
        regions.addRegion(RegionName.KR);
        regions.addRegion(RegionName.JP);
        regions.setCurrentRegion(RegionName.NA);
    }

    public static void generateMatches(Region region) {
        // Populate the statistics with matches on instantiation
        IntStream.rangeClosed(0, 20).forEach(a -> MatchMaking.matchMakeWithNoOutput(region));
    }

    public static ArrayList<Employee> generateEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Steve Gates",
                new BigDecimal("10000000.99"),
                "102002594",
                AccessLevel.Administrator));
        employees.add(new Employee("Mark Elonberg",
                new BigDecimal("3.50"),
                "1420125114",
                AccessLevel.Standard));
        return employees;
    }
}
