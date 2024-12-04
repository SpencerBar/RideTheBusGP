package com.sheridan.Model.Players;

import java.util.ArrayList;

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
}
