package com.solvd.teamgamematch.players;

/**
 * Instantiate and stores all Player objects
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

import java.util.ArrayList;

public class PlayerManager {
    ArrayList<Player> players;

    public PlayerManager() {
        players = new ArrayList<>();
        populatePlayerBase(15);
    }

    public void populatePlayerBase(int count) {
        if (count < 10) {
            count = 10;  // Minimum number of players needed to create two teams of 5
        }
        for (int i = 0; i < count; i++) {
            players.add(new Player("RandomName" + i, "Player " + i));
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
