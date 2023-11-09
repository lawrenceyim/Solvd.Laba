package com.solvd.teamgamematch.game.players;

/**
 * Instantiate and stores all Player objects
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

import com.solvd.teamgamematch.utility.GeneratePlayers;

import java.util.ArrayList;

public class PlayerManager {
    ArrayList<Player> players;

    public PlayerManager() {
        players = GeneratePlayers.generatePlayers(15);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
