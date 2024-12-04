package com.sheridan.Model.Cards;

import java.util.ArrayList;


public class DeckOfCards extends GroupOfCards{
    private ArrayList<PlayingCard> deck = new ArrayList<>();

    public DeckOfCards() {
        super(52);

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        
        

        // Create 52 cards
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new PlayingCard(suit, rank));
            }
        }
        
    }

    public ArrayList<PlayingCard> dealCards(int numCards) {
        ArrayList<PlayingCard> dealtCards = new ArrayList<PlayingCard>();
        
        for (int i = 0; i < numCards; i++) {
            if (deck.isEmpty()) {
                break; 
            }
            dealtCards.add(deck.remove(0)); 
        }
    
        return dealtCards;
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
