package com.solvd.teamgamematch.players;

/**
 * Instantiate and stores all Player objects
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

import com.solvd.teamgamematch.person.IdNumberManager;

import java.util.ArrayList;

public class PlayerManager {
    ArrayList<Player> players;

    public PlayerManager() {
        players = new ArrayList<>();
        populatePlayerBase(15);
    }

    public void populatePlayerBase(int count) {
        IdNumberManager idNumberManager = IdNumberManager.getInstance();
        if (count < 10) {
            count = 10;  // Minimum number of players needed to create two teams of 5
        }
        for (int i = 0; i < count; i++) {
            players.add(new Player("RandomName" + i, idNumberManager.generateIdNumber(), "Player " + i));
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
