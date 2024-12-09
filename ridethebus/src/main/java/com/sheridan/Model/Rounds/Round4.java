
package com.sheridan.Model.Rounds;
/**
 * A Class that defines round4, where each player chooses 
 * three times which suit the next card will be
 *
 * @author Spencer Barnes
 */
import com.sheridan.Model.Cards.PlayingCard;
import com.sheridan.Model.Cards.DeckOfCards;
import com.sheridan.Model.Players.Player;
import com.sheridan.View.Rounds.Round4View;

import java.util.ArrayList;

public class Round4 {
    private ArrayList<PlayingCard> cards;
    private DeckOfCards deck;
    private ArrayList<Player<?>> playerList;

    public Round4(ArrayList<Player<?>> playerList, DeckOfCards deck) {
        this.cards = new ArrayList<PlayingCard>();
        this.deck =  deck;
        this.playerList = playerList;

    }

    public ArrayList<Player<?>> StartRound4(){

        Round4View view = new Round4View(playerList);
        // print ROUND 4 Title Card
        view.round4Start();
        
        for (int i=0; i < playerList.size();i++)   
        {
            deck.shuffle();
            cards = deck.dealCards(3);
            System.out.println(playerList.get(i).getName() + "'s Turn");
           playerList.get(i).Round4(cards, i);
        }
        view.showScores();
        
        
        return playerList;
    }
}
