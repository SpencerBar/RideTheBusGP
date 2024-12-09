
package com.sheridan.Model.Cards;

import java.util.ArrayList;

public class DeckOfCards extends GroupOfCards {

    public DeckOfCards() {
        super(52); 

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new PlayingCard(suit, rank)); 
            }
        }
    }

    public ArrayList<PlayingCard> dealCards(int numCards) {
        ArrayList<PlayingCard> dealtCards = new ArrayList<>();

        for (int i = 0; i < numCards; i++) {
            if (cards.isEmpty()) { 
                break;
            }
            dealtCards.add((PlayingCard) cards.remove(0)); // Remove from the top of the deck
        }

        return dealtCards;
    }

    public int getRemainingCards() {
        return cards.size(); 
    }

    public void resetDeck() {
        cards.clear(); 
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new PlayingCard(suit, rank));
            }
        }
        shuffle(); 
    }

    public void displayDeck() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
