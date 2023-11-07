package com.solvd.teamgamematch.utility;

import com.solvd.teamgamematch.players.Player;

import java.util.ArrayList;

public class GeneratePlayers {

    public static ArrayList<Player> generatePlayers(int count) {
        if (count < 10) {
            count = 10;  // Minimum number of players needed to create two teams of 5
        }
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            players.add(new Player("RandomName" + i, "Player " + i));
        }
        return players;
    }
}
