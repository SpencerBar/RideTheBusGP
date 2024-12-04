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
import java.util.ArrayList;

public class Round4 {
    private ArrayList<PlayingCard> cards;
    private DeckOfCards deck;
    private ArrayList<Player<?>> playerList;

    public Round4(ArrayList<Player<?>> playerList) {
        this.cards = new ArrayList<PlayingCard>();
        this.deck =  new DeckOfCards();
        this.playerList = playerList;

    }

    public ArrayList<Player<?>> StartRound4(){
        
        for (int i=0; i < playerList.size();i++)   
        {
            deck.shuffle();
            cards = deck.dealCards(3);
            System.out.println("Player " + i + "'s Turn");
           playerList.get(i).Round4(cards, i);
        }
        System.out.println("Scores after this round:");
        for (int i= 0; i < playerList.size();i++) {
            System.out.println("Player" + i  + ": " + playerList.get(i).getScore());
        }
        
        return playerList;
    }
}

