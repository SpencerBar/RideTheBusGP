package com.sheridan.Model.Rounds;
/**
 * A Class that defines round2, where each player chooses 
 * three times whether the next card will be higher or lower
 *
 * @author Spencer Barnes
 */

import java.util.ArrayList;
import java.util.Scanner;

import com.sheridan.Model.Cards.PlayingCard;
import com.sheridan.Model.Cards.DeckOfCards;
import com.sheridan.Model.Cards.PlayingCard;
import com.sheridan.Model.Players.Player;

public class Round2 {
    private ArrayList<PlayingCard> cards;
    private DeckOfCards deck;
    private ArrayList<Player> playerList;
    private PlayingCard card1;
    private PlayingCard card2;

    public Round2 (ArrayList<Player> playerList) {
        this.cards = new ArrayList<PlayingCard>();
        this.deck =  new DeckOfCards();
        this.playerList = playerList;

    }

    public ArrayList<Player> StartRound2(){
        Boolean correct;
        Scanner input = new Scanner(System.in);
        String[] validGuess = {"higher", "lower"}; 
        for (int i=0; i < playerList.size();i++)   
        {
            // The system shuffles the card deck.
            deck.shuffle();
            // The system deals 4 cards in a line.
            cards = deck.dealCards(4);
            System.out.println("Player " + i + "'s Turn");
            for (int r=0; r < cards.size()-1; r++)
            {
                card1 = cards.get(r);
                card2 = cards.get(r+1);
                // The system flips the first card and shows its value to the player.
                System.out.println("The Card is " + cards.get(r).toString());
                String guess = "";
                boolean validInput = false;

                while (!validInput) {
                    // The system displays the first prompt “Higher or Lower?”
                    System.out.println("Higher or Lower?");
                    // Player(s) makes their guess.
                    guess = input.nextLine().toLowerCase();

                    // Check if input is valid
                    for (String choices : validGuess) {
                        if (guess.equals(choices )) {
                            validInput = true;
                            break;
                        }
                    }
                    if (!validInput) {
                        System.out.println("Invalid input. Please guess one of the following: higher, lower");
                    }
                }

                System.out.println("The Card is " + cards.get(r+1).toString());
                // The system scores the guess
                if (card1.getValue() ==(card2.getValue()))
                {
                    correct = true;
                }
                else if (guess.equals("higher"))
                {   
                    if (card1.getValue() < card2.getValue())
                    {
                        correct = true;
                    }
                    else
                    {
                        correct = false;
                    }
                }
                else if(guess.equals("lower"))
                {
                    if (card1.getValue() > card2.getValue())
                    {
                        correct = true;
                    }
                    else
                    {
                        correct = false;
                    }
                }
                if (correct)
                {
                    System.out.println("Correct! Point for Player " + i);
                    // Players are awarded a point for correctly guessing.
                    playerList.get(i).addScore();
                }
                else
                {
                    System.out.println("Incorrect!No Point for Player " + i);
                }
            }
        }
        System.out.println("Scores after this round:");
        for (Player player : playerList) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
        
        return playerList;
    }
    
}










