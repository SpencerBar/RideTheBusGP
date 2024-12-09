package com.sheridan.Model.Rounds;

import java.util.ArrayList;
import com.sheridan.Model.Cards.DeckOfCards;
import com.sheridan.Model.Cards.PlayingCard;
import com.sheridan.Model.Players.Player;
import com.sheridan.View.Rounds.Round1View;

public class Round1 {
    private ArrayList<PlayingCard> cards;
    private DeckOfCards deck;
    private ArrayList<Player<?>> playerList;

    public Round1(ArrayList<Player<?>> playerList, DeckOfCards deck) {
        this.cards = new ArrayList<>();
        this.deck = deck; 
        this.playerList = playerList;
    }

    public ArrayList<Player<?>> StartRound1() {
        Round1View view = new Round1View();
        view.round1Start();

        for (Player<?> player : playerList) {
            deck.shuffle();
            cards = deck.dealCards(3);

            System.out.println(player.getName() + "'s Turn");

            for (PlayingCard card : cards) {
                String cardColor = card.getColor();
                String guess = player.getGuess("Red or Black?", new String[]{"red", "black"});

                if (cardColor.equalsIgnoreCase(guess)) {
                    System.out.println("The Card is " + card + " (" + cardColor + ")");
                    System.out.println("Correct! Point for " + player.getName());
                    player.addScore();
                } else {
                    System.out.println("The Card is " + card + " (" + cardColor + ")");
                    System.out.println("Incorrect! No Point for " + player.getName());
                }
            }
        }

        view.showScores();
        for (Player<?> player : playerList) {
            System.out.println(player.getName() + ": " + player.getScore());
        }

        return playerList;
    }
}
