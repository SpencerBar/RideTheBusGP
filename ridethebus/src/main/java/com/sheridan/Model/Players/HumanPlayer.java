package com.sheridan.Model.Players;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;


import com.sheridan.Model.Cards.PlayingCard;

public class HumanPlayer<T> extends Player<T> {
    private String name;
    protected static final Scanner input = new Scanner(System.in);

    public HumanPlayer(String name) {
        super();
        this.name = name;
    }


    public String getName() {
        return name;
    }

 
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void Round1(ArrayList<PlayingCard> cards, int i) {
        Boolean correct = false;
        String[] validGuess = {"red", "black"};
        String guess = "";
        boolean validInput = false;
  
        for (int r=0; r < cards.size(); r++)
        {
            
       
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
            System.out.println("The Card is " + cards.get(r).toString());
            correct = redblack(cards.get(r), guess);
            if (correct)
            {
                System.out.println("Correct! Point for Player " + i);          
            // Players are awarded a point for correctly guessing.
                this.addScore();
            }
            else{
                System.out.println("Incorrect!No Point for Player " + i);
            }
        }
    }
    
    public Boolean redblack(PlayingCard card, String guess) {
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



    @Override
    public void Round2(ArrayList<PlayingCard> cards, int i) {
        Boolean correct = false;
        String[] validGuess = {"higher", "lower"};
        PlayingCard card1;
        PlayingCard card2; 
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
                    this.addScore();
                }
                else
                {
                    System.out.println("Incorrect!No Point for Player " + i);
                }
            }

    }


    @Override
    public void Round3(ArrayList<PlayingCard> cards, int i) {
        PlayingCard card1;
        PlayingCard card2;
        PlayingCard card3;
        Boolean correct= false;
   
        String[] validGuess = {"higher", "lower"};
        for (int r=0; r < cards.size()-1; r++)
            {
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
                if(card3.getValue() ==card1.getValue() || card3.getValue() == card2.getValue())
                {
                    correct = true;
                }  
                else if (guess.equals("between")){
                    if (card3.getValue() > card1.getValue() && card3.getValue() < card2.getValue())

                    {
                        correct = true;
                    }
                    else
                    {
                        correct = false;
                    }
                }
                else if(guess.equals("outside")){
                    if (card3.getValue() < card1.getValue() && card3.getValue() > card2.getValue())
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
                    this.addScore();
                }
                else{
                    System.out.println("Incorrect!No Point for Player " + i);
                }
            }

    }


    @Override
    public void Round4(ArrayList<PlayingCard> cards, int i) {
        
        String[] validGuess = {"hearts", "diamonds", "clubs", "spades"}; 
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
                this.addScore();
            }
            else{
                System.out.println("Incorrect!No Point for Player " + i);
            }
        }
      
    }

    
    
}
