package com.sheridan.Model.Cards;

public class PlayingCard extends Card{

    public PlayingCard(String suit, String rank) {
        super(suit, rank);
    }


    @Override
    public String toString() {
        return rank + " of " + suit;
    }
    
}
