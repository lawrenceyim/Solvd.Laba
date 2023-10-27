package com.solvd.teamgamematch.players;

import com.solvd.teamgamematch.game.Champion;
import com.solvd.teamgamematch.game.Champions;

import java.util.ArrayList;

public class Players {
    private static Players instance;
    ArrayList<Player> players;

    private Players() {
        players = new ArrayList<>();
        populatePlayerBase(100);
    }

    public static Players getInstance() {
        if (instance == null) {
            instance = new Players();
        }
        return instance;
    }

    public void populatePlayerBase(int count) {
        if (count < 10) {
            count = 10;  // Minimum number of players needed to create two teams of 5
        }
        for (int i = 0; i < count; i++) {
            players.add(new Player("Player " + String.valueOf(count)));
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
