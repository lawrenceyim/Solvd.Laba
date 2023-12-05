package com.solvd.teamgamematch.game.players;

import com.solvd.teamgamematch.output.CurrentOutput;
import com.solvd.teamgamematch.utils.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Stores the match history of every player
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */


public class PlayerMatchHistory {
    /*
        The first string is the player's username
        The string in the pair is the champion name
        The boolean is true if the player won the game
     */
    private final HashMap<String, ArrayList<Pair<String, Boolean>>> playerMatchHistory;

    public PlayerMatchHistory() {
        playerMatchHistory = new HashMap<>();
    }

    public void addPlayerMatch(String userName, String championName, boolean gameWon) {
        ArrayList<Pair<String, Boolean>> temp = playerMatchHistory.getOrDefault(userName, new ArrayList<>());
        temp.add(new Pair<>(championName, gameWon));
        playerMatchHistory.put(userName, temp);
    }

    public ArrayList<Pair<String, Boolean>> getPlayerMatchHistory(String userName) {
        return playerMatchHistory.getOrDefault(userName, new ArrayList<>());
    }

    public void displayPlayerMatchHistory(String userName) {
        if (!playerMatchHistory.containsKey(userName)) {
            CurrentOutput.getCurrentOutput().displayOutput("Player does not exist");
            return;
        }

        ArrayList<Pair<String, Boolean>> history = playerMatchHistory.get(userName);
        if (history.isEmpty()) {
            CurrentOutput.getCurrentOutput().displayOutput("Player has no matches");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(userName + "'s match history:\n");
        sb.append(String.format("%-30s %-15s%n", "Champion Name", "Result"));
        history.stream().forEach(match -> {
            if (match.getSecond()) {
                sb.append(String.format("%-30s %-15s%n", match.getFirst(), "Victory"));
            } else {
                sb.append(String.format("%-30s %-15s%n", match.getFirst(), "Defeat"));
            }
        });
        CurrentOutput.getCurrentOutput().displayOutput(sb.toString());
    }
}
