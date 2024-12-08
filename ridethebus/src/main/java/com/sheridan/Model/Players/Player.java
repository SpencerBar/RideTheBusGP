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

    // Abstract methods for rounds
    public abstract void Round1(ArrayList<PlayingCard> cards, int i);
    public abstract void Round2(ArrayList<PlayingCard> cards, int i);
    public abstract void Round3(ArrayList<PlayingCard> cards, int i);
    public abstract void Round4(ArrayList<PlayingCard> cards, int i);

    // Abstract method for retrieving the player's name
    public abstract String getName();

    public abstract String getGuess(String prompt, String[] validGuesses);

    // Method to compare the player's guess with the card's color
    public Boolean redblack(PlayingCard card, String guess) {
        String cardColor = card.getColor().toLowerCase(); // Retrieve card's color
        return cardColor.equals(guess); // Compare with player's guess
    }
}
