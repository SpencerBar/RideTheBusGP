package com.sheridan.Model.Rounds;
/**
 * A Class that defines round2, where each player chooses 
 * three times whether the next card will be higher or lower
 *
 * @author Spencer Barnes
 */

import java.util.ArrayList;
import com.sheridan.Model.Cards.PlayingCard;
import com.sheridan.Model.Cards.DeckOfCards;
import com.sheridan.Model.Players.Player;
import com.sheridan.View.Rounds.Round2View;

public class Round2 {
    private ArrayList<PlayingCard> cards;
    private DeckOfCards deck;
    private ArrayList<Player<?>> playerList;


    public Round2 (ArrayList<Player<?>> playerList, DeckOfCards deck) {
        this.cards = new ArrayList<PlayingCard>();
        this.deck =  deck;
        this.playerList = playerList;

    }

    public ArrayList<Player<?>> StartRound2(){

        Round2View view = new Round2View(playerList);
        // print the ROUND 2 Title
        view.round2Start(); 
      
        for (int i=0; i < playerList.size();i++)   
        {
            // The system shuffles the card deck.
            deck.shuffle();
            // The system deals 4 cards in a line.
            cards = deck.dealCards(4);
            System.out.println(playerList.get(i).getName() + "'s Turn");            
            playerList.get(i).Round2(cards, i);  
        }
        view.showScores();
        for (int i= 0; i < playerList.size();i++) {
            System.out.println(playerList.get(i).getName() + ": " + playerList.get(i).getScore());
        }
        
        return playerList;
    }
    
}










