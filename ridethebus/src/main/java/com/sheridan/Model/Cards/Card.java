package com.sheridan.Model.Cards;


/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author Carlos Rebelo
 */
public abstract class Card {
    protected String suit;
    protected String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getters
    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public abstract String toString();

}
