package com.solvd.teamgamematch.regions;

import com.solvd.teamgamematch.game.ChampionStats;
import com.solvd.teamgamematch.players.PlayerMatchHistory;
import com.solvd.teamgamematch.players.PlayerStats;
import com.solvd.teamgamematch.players.PlayerManager;

public class Region {
    private String regionName;
    private PlayerManager players;
    private PlayerMatchHistory playerMatchHistory;
    private PlayerStats playerStats;
    private ChampionStats championStats;

    public Region(String regionName) {
        this.regionName = regionName;
        players = new PlayerManager();
        playerMatchHistory = new PlayerMatchHistory();
        playerStats = new PlayerStats();
        championStats = new ChampionStats();
    }

    @Override
    public String toString() {
        return "Region Name: " + regionName +
                "\nPlayer Count: " + players.getPlayers().size();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public PlayerManager getPlayers() {
        return players;
    }

    public void setPlayers(PlayerManager players) {
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
