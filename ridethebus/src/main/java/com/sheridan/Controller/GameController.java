package com.sheridan.Controller;

import com.sheridan.Model.Rounds.Round1;
import com.sheridan.Model.Rounds.Round2;
import com.sheridan.Model.Rounds.Round3;
import com.sheridan.Model.Rounds.Round4;
import com.sheridan.Model.Players.*;
import com.sheridan.Model.RideTheBusGame;
import com.sheridan.Model.Cards.DeckOfCards;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {

    private RideTheBusGame game;

    public GameController() {
        this.game = new RideTheBusGame();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        int numPlayers;
        do {
            System.out.println("Enter the number of players (1-4): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); 
            }
            numPlayers = scanner.nextInt();
        } while (numPlayers < 1 || numPlayers > 4);

        ArrayList<Player<?>> players = new ArrayList<>();
        if (numPlayers == 1) {
            players.add(new HumanPlayer<>("Player 1")); 
            players.add(new AIPlayer<>("AI Player"));   
        } else {
            for (int i = 0; i < numPlayers; i++) {
                players.add(new HumanPlayer<>("Player " + (i + 1)));
            }
        }

        game.setPlayers(players);

        DeckOfCards deck = new DeckOfCards();

        System.out.println("Starting Ride the Bus game!");
        players = playRounds(players, deck);

        game.declareWinner();
        
        scanner.close();
    }

    private ArrayList<Player<?>> playRounds(ArrayList<Player<?>> players, DeckOfCards deck) {
        Round1 round1 = new Round1(players, deck);
        players = round1.StartRound1();

        Round2 round2 = new Round2(players, deck);
        players = round2.StartRound2();

        Round3 round3 = new Round3(players, deck);
        players = round3.StartRound3();

        Round4 round4 = new Round4(players, deck);
        players = round4.StartRound4();

        return players;
    }
}
