package com.sheridan.Model.Rounds;
/**
 * A Class that defines round4, where each player chooses 
 * three times which suit the next card will be
 *
 * @author Spencer Barnes
 */
import com.sheridan.Model.Cards.PlayingCard;
import com.sheridan.Model.Cards.DeckOfCards;
import com.sheridan.Model.Cards.GroupOfCards;

import com.sheridan.Model.Players.Player;
import java.util.ArrayList;

import java.util.Scanner;

public class Round4 {
    private ArrayList<PlayingCard> cards;
    private DeckOfCards deck;
    private ArrayList<Player> playerList;

    public Round4(ArrayList<Player> playerList) {
        this.cards = new ArrayList<PlayingCard>();
        this.deck =  new DeckOfCards();
        this.playerList = playerList;

    }

    public ArrayList<Player> StartRound4(){
        Scanner input = new Scanner(System.in);
        String[] validGuess = {"hearts", "diamonds", "clubs", "spades"}; 
      
        for (int i=0; i < playerList.size();i++)   
        {
            deck.shuffle();
            cards = deck.dealCards(3);
            System.out.println("Player " + i + "'s Turn");
            for (int r=0; r < cards.size(); r++)
            {
                String guess = "";
                boolean validInput = false;
// The system displays the first prompt “Guess the Suit”
                System.out.println("Guess the Suit!");
// Player(s) makes their guess.
                while (!validInput) {
                    System.out.println("Guess the Suit! (hearts, diamonds, clubs, spades)");
                    guess = input.nextLine().toLowerCase();

                    // Check if input is valid
                    for (String choices : validGuess) {
                        if (guess.equals(choices)) {
                            validInput = true;
                            break;
                        }
                    }
                    if (!validInput) {
                        System.out.println("Invalid input. Please guess one of the following: hearts, diamonds, clubs, spades.");
                    }
                }
                System.out.println("The Card is " + cards.get(r).toString());   
// The system scores the guess and displays the card.
                if (guess.equals(cards.get(r).getSuit())){           
// Players are awarded a point for correctly guessing.
                    System.out.println("Correct! Point for Player " + i);
                    playerList.get(i).addScore();
                }
                else{
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

