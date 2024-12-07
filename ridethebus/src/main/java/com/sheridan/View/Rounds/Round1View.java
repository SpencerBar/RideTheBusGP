package com.sheridan.View.Rounds;

import java.util.Scanner;
import com.sheridan.Model.Cards.PlayingCard;

public class Round1View {

    public String promptRedorBlack(){
        try (// get user input
        Scanner colourGuess = new Scanner(System.in)) {
            // question prompt
            System.out.println("Is the next card going to be red or black?");
   
            // take guess and format
            String playerGuess = colourGuess.nextLine().trim().toLowerCase();

            // error check, only accept "red" or "black"
            while (!playerGuess.equals("red") && playerGuess.equals("black")){
                System.out.println(playerGuess);
                playerGuess = colourGuess.nextLine().trim().toLowerCase();
            }

            return playerGuess;
        }
    }

    public void displayCard(PlayingCard card){
        System.out.println("The card is: " + card.toString());
    }


}
