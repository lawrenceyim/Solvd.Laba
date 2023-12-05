package com.solvd.teamgamematch.game.players;

import com.solvd.teamgamematch.output.CurrentOutput;
import com.solvd.teamgamematch.person.AccessLevel;
import com.solvd.teamgamematch.person.Person;
import com.solvd.teamgamematch.utils.Generator;

import java.util.HashMap;

/**
 * Player class that contains the player's name and mastery level for every champion
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */

public class Player extends Person {
    private String userName;
    private HashMap<String, Integer> championMastery;  // Player's skill level for each champion (1 to 10)

    public Player(String name, String userName) {
        super(name, AccessLevel.Guest);
        this.userName = userName;
        this.championMastery = Generator.generateChampionMastery();
    }

    @Override
    public String toString() {
        return "Player Username: " + userName;
    }

    @Override
    public void personDetail() {
        CurrentOutput.getCurrentOutput().displayOutput(getName() + " is a player");
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
