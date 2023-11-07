package com.solvd.teamgamematch.players;

import com.solvd.teamgamematch.Main;
import com.solvd.teamgamematch.game.ChampionManager;
import com.solvd.teamgamematch.person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Player class that contains the player's name and mastery level for every champion
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class Player extends Person {
    private String userName;
    private HashMap<String, Integer> championMastery;  // Player's skill level for each champion (1 to 10)

    public Player(String name, String userName) {
        super(name);
        this.userName = userName;
        this.championMastery = generateChampionMastery();
    }

    @Override
    public String toString() {
        return "Player Username: " + userName;
    }

    @Override
    public void personDetail() {
        Main.getOutput().displayOutput(getName() + " is a player");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getChampionMastery(String championName) {
        return championMastery.getOrDefault(championName, 1);
    }

    public void setChampionMastery(HashMap<String, Integer> championMastery) {
        this.championMastery = championMastery;
    }

    private HashMap<String, Integer> generateChampionMastery() {
        HashMap<String, Integer> championMastery = new HashMap<>();
        Random random = new Random();
        ArrayList<String> championNames = ChampionManager.getInstance().getChampionNames();
        for (String championName : championNames) {
            championMastery.put(championName, random.nextInt(10) + 1); // Random number between 1-10
        }
        return championMastery;
    }
}
