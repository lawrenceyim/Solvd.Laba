package com.solvd.teamgamematch.regions;

import com.solvd.teamgamematch.game.ChampionStats;
import com.solvd.teamgamematch.players.PlayerMatchHistory;
import com.solvd.teamgamematch.players.PlayerStats;
import com.solvd.teamgamematch.players.Players;

public class Region {
    private String regionName;
    private Players players;
    private PlayerMatchHistory playerMatchHistory;
    private PlayerStats playerStats;
    private ChampionStats championStats;

    public Region(String regionName) {
        this.regionName = regionName;
        players = new Players();
        playerMatchHistory = new PlayerMatchHistory();
        playerStats = new PlayerStats();
        championStats = new ChampionStats();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public PlayerMatchHistory getPlayerMatchHistory() {
        return playerMatchHistory;
    }

    public void setPlayerMatchHistory(PlayerMatchHistory playerMatchHistory) {
        this.playerMatchHistory = playerMatchHistory;
    }

    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }

    public ChampionStats getChampionStats() {
        return championStats;
    }

    public void setChampionStats(ChampionStats championStats) {
        this.championStats = championStats;
    }
}
