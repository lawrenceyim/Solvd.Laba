package com.solvd.teamgamematch.players;

import com.solvd.teamgamematch.utility.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerMatchHistory {
    /*
        The first string is the player's name
        The string in the pair is the champion name
        The boolean is true if the player won the game
     */
    private static PlayerMatchHistory instance;

    private HashMap<String, ArrayList<Pair<String, Boolean>>> playerMatchHistory;

    static {
        instance = new PlayerMatchHistory();
    }

    private PlayerMatchHistory() {
        this.playerMatchHistory = new HashMap<>();
    }

    public static PlayerMatchHistory getInstance() {
        if (instance == null) {
            instance = new PlayerMatchHistory();
        }
        return instance;
    }

    public void addPlayerMatch(String playerName, String championName, boolean gameWon) {
        playerMatchHistory.getOrDefault(playerName, new ArrayList<>()).add(new Pair<>(championName, gameWon));
    }

    public ArrayList<Pair<String, Boolean>> getPlayerMatchHistory(String playerName) {
        return playerMatchHistory.getOrDefault(playerName, new ArrayList<>());
    }
}
