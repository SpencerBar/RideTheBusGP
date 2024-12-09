package com.sheridan.Model.Cards;

import java.util.Dictionary;
import java.util.Hashtable;

public class PlayingCard extends Card{
    private static final Dictionary<String, Integer> values = new Hashtable<>();

    static {
        values.put("2", 2);
        values.put("3", 3);
        values.put("4", 4);
        values.put("5", 5);
        values.put("6", 6);
        values.put("7", 7);
        values.put("8", 8);
        values.put("9", 9);
        values.put("10", 10);
        values.put("J", 11);
        values.put("Q", 12);
        values.put("K", 13);
        values.put("A", 14);
    }
    
    public PlayingCard(String suit, String rank) {
        super(suit, rank);
    }

    public int getValue() {
        return values.get(rank);
    }

    public String getColor() {
        return (suit.equalsIgnoreCase("Hearts") || suit.equalsIgnoreCase("Diamonds")) ? "red" : "black";
    }    

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
    
}
