package com.solvd.teamgamematch.players;

import com.solvd.teamgamematch.utility.Pair;
import com.solvd.teamgamematch.utility.WaitForInput;

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
        The first string is the player's username
        The string in the pair is the champion name
        The boolean is true if the player won the game
     */
    private HashMap<String, ArrayList<Pair<String, Boolean>>> playerMatchHistory;

    public PlayerMatchHistory(PlayerManager playerManager) {
        playerMatchHistory = new HashMap<>();
        ArrayList<Player> players = playerManager.getPlayers();
        for (Player player : players) {
            playerMatchHistory.put(player.getUserName(), new ArrayList<>());
        }
    }

    public void addPlayerMatch(String userName, String championName, boolean gameWon) {
        var temp = playerMatchHistory.getOrDefault(userName, new ArrayList<>());
        temp.add(new Pair<>(championName, gameWon));
        playerMatchHistory.put(userName, temp);
    }

    public ArrayList<Pair<String, Boolean>> getPlayerMatchHistory(String userName) {
        return playerMatchHistory.getOrDefault(userName, new ArrayList<>());
    }

    public void displayPlayerMatchHistory(String userName) {
        if (!playerMatchHistory.containsKey(userName)) {
            System.out.println("Player does not exist");
        }

        ArrayList<Pair<String, Boolean>> history = playerMatchHistory.get(userName);
        if (history.isEmpty()) {
            System.out.println("Player has no matches");
            return;
        }

        System.out.println(userName + "'s match history:");
        System.out.printf("%-30s %-15s%n", "Champion Name", "Result");
        for (Pair<String, Boolean> match: history) {
            if (match.getSecond()) {
                System.out.printf("%-30s %-15s%n", match.getFirst(), "Victory");
            } else {
                System.out.printf("%-30s %-15s%n", match.getFirst(), "Defeat");
            }
        }
        WaitForInput.waitForAnyUserInput();
    }
}
