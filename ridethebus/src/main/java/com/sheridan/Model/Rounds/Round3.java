package com.sheridan.Model.Rounds;
/**
 * A Class that defines round3, where each player chooses 
 * three times whether the next card will be between or outside
 *
 * @author Spencer Barnes
 */

import java.util.ArrayList;
import java.util.Scanner;

import com.sheridan.Model.Cards.Card;
import com.sheridan.Model.Cards.DeckOfCards;
import com.sheridan.Model.Players.Player;

public class Round3 {
    private ArrayList<Card> cards;
    private DeckOfCards deck;
    private ArrayList<Player> playerList;
    private Card card1;
    private Card card2;
    private Card card3;

    public Round3(ArrayList<Player> playerList) {
        this.cards = new ArrayList<Card>();
        this.deck =  new DeckOfCards();
        this.playerList = playerList;

    }

    public ArrayList<Player> StartRound3(){
      
        for (int i; i < playerList.size();i++)   
        {
            // The system shuffles the card deck.
            deck.shuffle();
            // The system deals with 5 cards in a line.
            cards = deck.dealCards(5);
            
            System.out.println("Player " + i + "'s Turn");
            for (int r; r < cards.size()-1; r++)
            {
                Boolean correct;
                Scanner input = new Scanner(System.in);
                String[] validGuess = {"between", "outside"}; 
                card1 = cards.get(r);
                card2 = cards.get(r+1);
                card3 = cards.get(r+2);
                // The system flips and displays the first two cards in the line.
                System.out.println("First Card: " + card1.toString() + " Second Card: " + card2.toString());
                String guess = "";
                boolean validInput = false;

                while (!validInput) {
                    // The system displays the first prompt “Between or Outside?” 
                    System.out.println("Between or Outside?");
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
                if(card3.getValue().equals(card1.getValue()) || card3.getValue().equals(card2.getValue()) )
                {
                    correct = true;
                }  
                else if (guess.equals("between")){
                    if (card3.getValue() > card1 && card3.getValue() < card2)
                    {
                        correct = true;
                    }
                    else
                    {
                        correct = false;
                    }
                }
                else if(guess.equals("outside")){
                    if (card3.getValue() < card1 && card3.getValue() > card2)
                    {
                        correct = true;
                    }
                    else
                    {
                        correct = false;
                    }   
                }
                

                if (correct){
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
}
