package com.sheridan.Model.Rounds;

import java.util.ArrayList;
import com.sheridan.Model.Cards.DeckOfCards;
import com.sheridan.Model.Cards.PlayingCard;
import com.sheridan.Model.Players.Player;
import com.sheridan.View.Rounds.Round1View;

public class Round1 {
    private ArrayList<PlayingCard> cards;
    private DeckOfCards deck;
    private ArrayList<Player<?>> playerList;

    public Round1(ArrayList<Player<?>> playerList, DeckOfCards deck) {
        this.cards = new ArrayList<>();
        this.deck = deck; 
        this.playerList = playerList;
    }

    public ArrayList<Player<?>> StartRound1() {
        Round1View view = new Round1View(playerList);
        view.round1Start();
        for (int i=0; i < playerList.size();i++) {
            deck.shuffle();
            cards = deck.dealCards(3);
            System.out.println(playerList.get(i).getName() + "'s Turn");
            playerList.get(i).Round1(cards, i);
        }

        view.showScores();

        return playerList;
    }
}
