package com.sheridan.Model.Rounds;

import com.sheridan.Model.Cards.DeckOfCards;
import com.sheridan.Model.Cards.GroupOfCards;
import com.sheridan.Model.Cards.Card;
import com.sheridan.Model.Players.Player;
import java.util.ArrayList;

import java.util.Scanner;

public class Round4 {
    private ArrayList<Card> cards;
    private DeckOfCards deck;
    private ArrayList<Player> playerList;

    public Round4(ArrayList<Player> playerList) {
        this.cards = new ArrayList<Card>();
        this.deck =  new DeckOfCards();
        this.playerList = playerList;

    }

    public ArrayList<Player> StartRound4(){
      
        for (int i; i < playerList.size();i++)   
        {
            deck.shuffle();
            cards = deck.dealCard(3);
            
            for (int r; r < cards.size(); r++)
            {
                // The system displays the first prompt “Guess the Suit”
                System.out.println("Player " + i + "'s Turn");
                Scanner input = new Scanner(System.in);
                System.out.println("Guess the Suit!");
                String guess = input.nextLine().toLowerCase();

                if (guess.equals(cards.get(i).getSuit())){
                    System.out.println("Correct! Point for Player " + i);
                    playerList.get(i).addScore();
                }
                else{
                    System.out.println("Incorrect!No Point for Player " + i);
                }
            }
        }
    
        return playerList;
    }




 



// Player(s) makes their guess.

// The system scores the guess and displays the card.

// Players are awarded a point for correctly guessing.

}
