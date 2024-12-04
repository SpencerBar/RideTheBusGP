package com.sheridan.Model.Rounds;
/**
 * A Class that defines round1, where each player chooses 
 * three times whether the next card will be red or black
 *
 * @author Spencer Barnes
 */

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

import com.sheridan.Model.Cards.Card;
import com.sheridan.Model.Cards.DeckOfCards;
import com.sheridan.Model.Players.Player;

public class Round1 {
        private ArrayList<Card> cards;
    private DeckOfCards deck;
    private ArrayList<Player> playerList;

    public Round1(ArrayList<Player> playerList) {
        this.cards = new ArrayList<Card>();
        this.deck =  new DeckOfCards();
        this.playerList = playerList;

    }

    public ArrayList<Player> StartRound1(){
        Boolean correct;
        Scanner input = new Scanner(System.in);
        String[] validGuess = {"red", "black"}; 
      
        for (int i; i < playerList.size();i++)   
        {
            // The system shuffles the card deck.
            deck.shuffle();
            // The system deals 3 cards in a line.
            cards = deck.dealCards(3);
            System.out.println("Player " + i + "'s Turn");
            for (int r; r < cards.size(); r++)
            {
                String guess = "";
                boolean validInput = false;
          

                while (!validInput) {
                    // The system displays the first prompt “Red or Black?” 
                    System.out.println("Red or Black?");
                    // Player(s) makes their guess.
                    guess = input.nextLine().toLowerCase();
                    // Check if input is valid
                    for (String choices : validGuess) {
                        if (guess.equals(choices)) {
                            validInput = true;
                            break;
                        }
                    }
                    if (!validInput) {
                        System.out.println("Invalid input. Please guess one of the following: red, black");
                    }
                }
                // The system scores the guess and displays the card.
                System.out.println("The Card is " + cards.get(i).toString());
                correct = redblack(cards.get(r), guess);
                if (correct)
                {
                    System.out.println("Correct! Point for Player " + i);          
                // Players are awarded a point for correctly guessing.
                    playerList.get(i).addScore();
                }
                else{
                    System.out.println("Incorrect!No Point for Player " + i);
                }
            }
        }
    
        return playerList;
    }

    public Boolean redblack(Card card, String guess) {
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






