package com.solvd.teamgamematch.game;

import com.solvd.teamgamematch.players.Player;
import com.solvd.teamgamematch.players.Players;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Implementation of the match making algorithm to randomly generate
 * two teams of five players and determine the outcome
 *
 * @version 1.0 25 Oct 2023
 * @author Lawrence Yim
 */

public class MatchMaking {
    public static void matchMake() {
        try {
            // Players and champions will be randomly selected and paired based on their arraylist index
            // Indices 0-4 will be team one and 5-9 will be team two
            ArrayList<Player> players = generateRandomTeams();
            ArrayList<String> champions = randomlySelectChampions();

            // Determine the winner and update the player and champion stats
        } catch (RuntimeException e) {
            return;
        }
    }

    private static ArrayList<Player> generateRandomTeams() {
        ArrayList<Player> players = Players.getInstance().getPlayers();

        if (players.size() < 10) {
            throw new RuntimeException("Insufficient number of players to start matchmaking");
        }

        HashSet<Integer> randomPlayers = new HashSet<>();
        Random random = new Random();

        while (randomPlayers.size() < 10) {
            int randomIndex = random.nextInt(players.size());
            randomPlayers.add(randomIndex);
        }

        ArrayList<Player> selectedPlayers = new ArrayList<>();
        for (Integer playerIndex : randomPlayers) {
            selectedPlayers.add(players.get(playerIndex));
        }

        return selectedPlayers;
    }

    private static ArrayList<String> randomlySelectChampions() {
        ArrayList<String> championNames = Champions.getInstance().getChampionNames();
        HashSet<Integer> randomChampions = new HashSet<>();
        Random random = new Random();

        while (randomChampions.size() < 10) {
            int randomIndex = random.nextInt(championNames.size());
            randomChampions.add(randomIndex);
        }

        ArrayList<String> selectedChampions = new ArrayList<>();
        for (Integer championIndex : randomChampions) {
            selectedChampions.add(championNames.get(championIndex));
        }
        return selectedChampions;
    }

    private static void determineResult(ArrayList<Player> players, ArrayList<String> champions) {
        int teamOneScore = 0;
        int teamTwoScore = 0;

        for (int i = 0; i < 5; i++) {
            teamOneScore += players.get(i).getChampionMastery(champions.get(i));
        }
        for (int i = 5; i < 10; i++) {
            teamTwoScore += players.get(i).getChampionMastery(champions.get(i));
        }

        boolean teamOneWon = teamOneScore >= teamOneScore;  // Team one wins if the scores are equal

    }

}
