package com.sheridan.Model.Rounds;
/**
 * A Class that defines round1, where each player chooses 
 * three times whether the next card will be red or black
 *
 * @author Spencer Barnes
 */

import java.util.ArrayList;
import com.sheridan.Model.Cards.DeckOfCards;
import com.sheridan.Model.Cards.PlayingCard;
import com.sheridan.Model.Players.Player;

public class Round1 {
    private ArrayList<PlayingCard> cards;
    private DeckOfCards deck;
    private ArrayList<Player<?>> playerList;

    public Round1(ArrayList<Player<?>> playerList) {
        this.cards = new ArrayList<PlayingCard>();
        this.deck =  new DeckOfCards();
        this.playerList = playerList;

    }

    public ArrayList<Player<?>> StartRound1(){
     
      
        for (int i=0; i < playerList.size();i++)   
        {
            // The system shuffles the card deck.
            deck.shuffle();
            // The system deals 3 cards in a line.
            cards = deck.dealCards(3);
            System.out.println("Player " + i + "'s Turn");
            playerList.get(i).Round1(cards, i); 
        }
        System.out.println("Scores after this round:");
        for (int i= 0; i < playerList.size();i++) {
            System.out.println("Player" + i  + ": " + playerList.get(i).getScore());
        }
        
        return playerList;
    }
}






