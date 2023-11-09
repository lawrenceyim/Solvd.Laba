package com.solvd.teamgamematch.game.players;

import com.solvd.teamgamematch.Main;
import com.solvd.teamgamematch.person.Person;
import com.solvd.teamgamematch.utility.GenerateChampionMastery;

import java.util.HashMap;

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
        this.championMastery = GenerateChampionMastery.generateChampionMastery();
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


}
