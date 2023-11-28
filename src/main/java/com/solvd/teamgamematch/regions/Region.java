package com.solvd.teamgamematch.regions;

import com.solvd.teamgamematch.game.champions.ChampionStats;
import com.solvd.teamgamematch.game.players.PlayerManager;
import com.solvd.teamgamematch.game.players.PlayerMatchHistory;
import com.solvd.teamgamematch.game.players.PlayerStats;
import com.solvd.teamgamematch.utils.Generator;

public class Region {
    private String regionName;
    private PlayerManager players;
    private PlayerMatchHistory playerMatchHistory;
    private PlayerStats playerStats;
    private ChampionStats championStats;

    public Region(RegionName regionName) {
        this.regionName = regionName.getName();
        players = new PlayerManager();
        playerMatchHistory = new PlayerMatchHistory(players);
        playerStats = new PlayerStats();
        championStats = new ChampionStats();
        Generator.generateMatches(this);
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
