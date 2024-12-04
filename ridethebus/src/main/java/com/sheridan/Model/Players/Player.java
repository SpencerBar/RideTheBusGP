package com.sheridan.Model.Players;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import com.sheridan.Model.Cards.PlayingCard;

public abstract class Player<T> {
    private int score;

    public Player() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        score++;
    }

    public abstract void Round1(ArrayList<PlayingCard> cards , int i);
    public abstract void Round2(ArrayList<PlayingCard> cards, int i);
    public abstract void Round3(ArrayList<PlayingCard> cards, int i);
    public abstract void Round4(ArrayList<PlayingCard> cards, int i);

    public Boolean redblack(PlayingCard card, String guess) {
        Dictionary<String, Integer> dict= new Hashtable<>();
        dict.put("hearts",1);
        dict.put("diamonds",1);
        dict.put("clubs",0);
        dict.put("spades",0);
       
        String cardsuit = card.getSuit().toLowerCase();
        if (dict.get(cardsuit) == dict.get(guess))
        {   
            return true;
        }
        else
        {
            return false;
        }
     
    }
}
