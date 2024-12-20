package com.sheridan.Model.Rounds;
/**
 * A Class that defines round3, where each player chooses 
 * three times whether the next card will be between or outside
 *
 * @author Spencer Barnes
 */

import java.util.ArrayList;


import com.sheridan.Model.Cards.PlayingCard;
import com.sheridan.Model.Cards.DeckOfCards;
import com.sheridan.Model.Players.Player;
import com.sheridan.View.Rounds.Round3View;

public class Round3 {
    private ArrayList<PlayingCard> cards;
    private DeckOfCards deck;
    private ArrayList<Player<?>> playerList;
   

    public Round3(ArrayList<Player<?>> playerList, DeckOfCards deck) {
        this.cards = new ArrayList<PlayingCard>();
        this.deck =  deck;
        this.playerList = playerList;

    }

    public ArrayList<Player<?>> StartRound3(){

        Round3View view = new Round3View(playerList);
        // print ROUND 3 title card
        view.round3Start();
       
        for (int i=0; i < playerList.size();i++)   
        {
            // The system shuffles the card deck.
            deck.shuffle();
            // The system deals with 5 cards in a line.
            cards = deck.dealCards(5);
            
            System.out.println(playerList.get(i).getName() + "'s Turn");
            playerList.get(i).Round3(cards, i);
            
        }
        view.showScores();

        
        return playerList;
    }
}