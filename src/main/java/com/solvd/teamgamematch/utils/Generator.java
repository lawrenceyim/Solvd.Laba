package com.solvd.teamgamematch.utils;

import com.solvd.teamgamematch.employees.Employee;
import com.solvd.teamgamematch.game.MatchMaking;
import com.solvd.teamgamematch.game.champions.Champion;
import com.solvd.teamgamematch.game.champions.ChampionManager;
import com.solvd.teamgamematch.game.champions.ChampionRole;
import com.solvd.teamgamematch.game.players.Player;
import com.solvd.teamgamematch.output.CurrentOutput;
import com.solvd.teamgamematch.person.AccessLevel;
import com.solvd.teamgamematch.regions.RegionName;
import com.solvd.teamgamematch.regions.Regions;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {
    public static void generateChampions(ArrayList<Champion> champions) {
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

    public static void generatePlayers(Regions regions) {
        regions.getRegions().keySet().stream()
                .forEach(key -> {
                    generatePlayers(regions.getRegion(key).getPlayerManager().getPlayers());
                });
    }

    public static void generatePlayers(ArrayList<Player> players) {
        IntStream.rangeClosed(0, 15)
                .forEach(i -> players.add(new Player("RandomName" + i, "Player " + i)));
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

    public static void generateMatches(Regions regions) {
        regions.getRegions().keySet().stream()
                .forEach(key -> {
                    IntStream.rangeClosed(0, 20).forEach(a ->
                            MatchMaking.matchMakeWithNoOutput(regions.getRegion(key)));
                });
    }

    public static void generateEmployees(ArrayList<Employee> employees) {
        employees.add(new Employee("Steve Gates",
                new BigDecimal("10000000.99"),
                "102002594",
                AccessLevel.Administrator));
        employees.add(new Employee("Mark Elonberg",
                new BigDecimal("3.50"),
                "1420125114",
                AccessLevel.Standard));

        try {
            employees.add((Employee) Class.forName("com.solvd.teamgamematch.employees.Employee")
                    .getDeclaredConstructor(String.class, BigDecimal.class, String.class)
                    .newInstance("Spiderman", new BigDecimal("7.50"), "12344567"));
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            CurrentOutput.getCurrentOutput().displayError(e.toString());
        }
    }
}
