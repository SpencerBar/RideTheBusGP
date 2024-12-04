package com.sheridan.Model.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private List<Card> deck;

    public DeckOfCards() {
        deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        // Create 52 cards
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new PlayingCard(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        if (deck.isEmpty()) {
            return null;  // No cards left
        }
        return deck.remove(0);  // Remove and return the top card
    }

    public int getRemainingCards() {
        return deck.size();
    }


    //Testing
    public void displayDeck() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

}
