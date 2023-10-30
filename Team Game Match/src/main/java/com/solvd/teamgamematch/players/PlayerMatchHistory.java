package com.solvd.teamgamematch.players;

import com.solvd.teamgamematch.utility.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Stores the match history of every player
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */


public class PlayerMatchHistory {
    /*
        The first string is the player's name
        The string in the pair is the champion name
        The boolean is true if the player won the game
     */
    private HashMap<String, ArrayList<Pair<String, Boolean>>> playerMatchHistory;

    public PlayerMatchHistory() {
        this.playerMatchHistory = new HashMap<>();
    }

    public void addPlayerMatch(String playerName, String championName, boolean gameWon) {
        var temp = playerMatchHistory.getOrDefault(playerName, new ArrayList<>());
        temp.add(new Pair<>(championName, gameWon));
        playerMatchHistory.put(playerName, temp);
    }

    public ArrayList<Pair<String, Boolean>> getPlayerMatchHistory(String playerName) {
        return playerMatchHistory.getOrDefault(playerName, new ArrayList<>());
    }

    public void displayPlayerMatchHistory(String playerName) {
        ArrayList<Pair<String, Boolean>> history = playerMatchHistory.getOrDefault(playerName, new ArrayList<>());
        if (history.isEmpty()) {
            System.out.println("Player has no matches");
            return;
        }
        System.out.println(playerName + "'s match history:");
        System.out.printf("%-30s %-15s%n", "Champion Name", "Result");
        for (Pair<String, Boolean> match: history) {
            if (match.getSecond()) {
                System.out.printf("%-30s %-15s%n", match.getFirst(), "Victory");
            } else {
                System.out.printf("%-30s %-15s%n", match.getFirst(), "Defeat");
            }
        }
    }
}
