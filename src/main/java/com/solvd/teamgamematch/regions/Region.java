package com.solvd.teamgamematch.regions;

import com.solvd.teamgamematch.game.champions.ChampionStats;
import com.solvd.teamgamematch.game.players.PlayerManager;
import com.solvd.teamgamematch.game.players.PlayerMatchHistory;
import com.solvd.teamgamematch.game.players.PlayerStats;
import com.solvd.teamgamematch.utils.Generator;

public class Region {
    private RegionName regionName;
    private PlayerManager playerManager;
    private PlayerMatchHistory playerMatchHistory;
    private PlayerStats playerStats;
    private ChampionStats championStats;

    public Region(RegionName regionName) {
        this.regionName = regionName;
        playerManager = new PlayerManager();
        playerMatchHistory = new PlayerMatchHistory();
        playerStats = new PlayerStats();
        championStats = new ChampionStats();
    }

    @Override
    public String toString() {
        return "Region Name: " + regionName +
                "\nPlayer Count: " + playerManager.getPlayers().size();
    }

    public String getRegionName() {
        return regionName.getName();
    }

    public void setRegionName(RegionName regionName) {
        this.regionName = regionName;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public void setPlayerManager(PlayerManager playerManager) {
        this.playerManager = playerManager;
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
