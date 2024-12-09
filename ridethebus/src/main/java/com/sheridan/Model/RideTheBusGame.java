package com.sheridan.Model;

/*@author Anita Kashani

*/

import com.sheridan.Model.Players.Player;
import com.sheridan.Model.Players.HumanPlayer;
import com.sheridan.Model.Cards.DeckOfCards;
import com.sheridan.Model.Players.AIPlayer;
import com.sheridan.Model.Rounds.Round1;
import com.sheridan.Model.Rounds.Round2;
import com.sheridan.Model.Rounds.Round3;
import com.sheridan.Model.Rounds.Round4;

import java.util.ArrayList;
import java.util.Scanner;

public class RideTheBusGame {
    private ArrayList<Player<?>> players;
    private final Scanner scanner;

    public RideTheBusGame() {
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public ArrayList<Player<?>> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player<?>> players) {
        this.players = players;
    }

    public void startGame() {
        System.out.println("Welcome to Ride the Bus!");
        int numPlayers = getNumPlayers();
        initializePlayers(numPlayers);
        System.out.println("Let's begin!");

        DeckOfCards deck = new DeckOfCards();

        Round1 round1 = new Round1(players, deck);
        players = round1.StartRound1();

        Round2 round2 = new Round2(players, deck);
        players = round2.StartRound2();

        Round3 round3 = new Round3(players, deck);
        players = round3.StartRound3();

        Round4 round4 = new Round4(players, deck);
        players = round4.StartRound4();

        declareWinner();
    }

    private int getNumPlayers() {
        int numPlayers = 0;
        while (numPlayers < 1 || numPlayers > 4) {
            System.out.print("Enter number of players (1-4): ");
            try {
                numPlayers = Integer.parseInt(scanner.nextLine());
                if (numPlayers < 1 || numPlayers > 4) {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
            }
        }
        return numPlayers;
    }

    private void initializePlayers(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            if (i == 0) { // First player is always human
                players.add(new HumanPlayer<>("Player " + (i + 1)));
            } else {
                players.add(new AIPlayer<>("Player " + (i + 1)));
            }
        }
    }

    public void declareWinner() {
        int highestScore = 0;
        ArrayList<Player<?>> winners = new ArrayList<>();

        for (Player<?> player : players) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
                winners.clear();
                winners.add(player);
            } else if (player.getScore() == highestScore) {
                winners.add(player);
            }
        }

        System.out.println("Game Over!");
        if (winners.size() == 1) {
            System.out.println("Congratulations " + winners.get(0).getName() + "! You are the winner with " + highestScore + " points.");
        } else {
            System.out.println("It's a tie between:");
            for (Player<?> winner : winners) {
                System.out.println(winner.getName() + " with " + highestScore + " points.");
            }
        }
    }
}
