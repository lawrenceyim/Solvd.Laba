package com.solvd.teamgamematch.game.players;

/**
 * Instantiate and stores all Player objects
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

import com.solvd.teamgamematch.utils.Generator;

import java.util.ArrayList;

public class PlayerManager {
    ArrayList<Player> players;

    public PlayerManager() {
        players = Generator.generatePlayers(15);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void removePlayer(Player player) {
        if (players.contains(player)) {
            players.remove(player);
        }
    }

    public void addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }
}
