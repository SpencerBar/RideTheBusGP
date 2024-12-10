package com.sheridan.Model.Players;

import java.util.ArrayList;
import java.util.Scanner;
import com.sheridan.Model.Cards.PlayingCard;
import com.sheridan.View.PlayerView;

public class HumanPlayer<T> extends Player<T> {
    private String name;
    protected static final Scanner input = new Scanner(System.in);

    public HumanPlayer(String name) {
        super();
        this.name = name;
    }

    // instantiate the PlayerView
    private PlayerView view = new PlayerView();

    @Override
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
        for (int r=0; r < cards.size(); r++)
        {

             // The system displays the first prompt “Red or Black?” 
             view.colourPrompt();
             // Player(s) makes their guess.
             guess = getGuess(view.colourPrompt(), validGuess);
            // The system scores the guess and displays the card.
            System.out.println("The Card is " + cards.get(r).toString());
            correct = redblack(cards.get(r), guess);
            if (correct)
            {
                System.out.println(view.correct() + this.getName());          
            // Players are awarded a point for correctly guessing.
                this.addScore();
            }
            else{

                System.out.println(view.incorrect() + this.getName());
            }
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
                guess = getGuess(view.highLowPrompt(),validGuess);
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
                    System.out.println(view.correct() +this.getName());
                    // Players are awarded a point for correctly guessing.
                    this.addScore();
                }
                else
                {
                    System.out.println(view.incorrect() +this.getName());
                }
            }

    }

    public void Round3(ArrayList<PlayingCard> cards, int i) {
        if (cards.size() < 3) {
            System.out.println("Not enough cards to play Round 3.");
            return;
        }
    
        boolean correct = false;
        String[] validGuess = {"between", "outside"};
        
        for (int r = 0; r < cards.size() - 2; r++) {
            PlayingCard card1 = cards.get(r);
            PlayingCard card2 = cards.get(r + 1);
            PlayingCard card3 = cards.get(r + 2);
    
            // Display the first two cards
            System.out.println("First Card: " + card1 + " Second Card: " + card2);
    
            // Get the player's guess
            String guess = getGuess(view.betweenOutsidePrompt(), validGuess);
    
            // Reveal the third card
            System.out.println("The Card is " + card3);
    
            // Determine if the guess is correct
            if (card3.getValue() == card1.getValue() || card3.getValue() == card2.getValue()) {
                correct = true; // Exact match with one of the bounds
            } else if (guess.equals("between")) {
                if ((card3.getValue() > Math.min(card1.getValue(), card2.getValue())) &&
                    (card3.getValue() < Math.max(card1.getValue(), card2.getValue()))) {
                    correct = true;
                } else {
                    correct = false;
                }
            } else if (guess.equals("outside")) {
                if ((card3.getValue() < Math.min(card1.getValue(), card2.getValue())) ||
                    (card3.getValue() > Math.max(card1.getValue(), card2.getValue()))) {
                    correct = true;
                } else {
                    correct = false;
                }
            }
    
            // Display the result and update the score
            if (correct) {
                System.out.println(view.correct() + this.getName());
                this.addScore();
            } else {
                System.out.println(view.incorrect() + this.getName());
            }
        }
    }

    @Override
    public void Round4(ArrayList<PlayingCard> cards, int i) {
        
        String[] validGuess = {"hearts", "diamonds", "clubs", "spades"}; 
        for (int r=0; r < cards.size(); r++)
        {
            String guess = "";
            // The system displays the first prompt “Guess the Suit”
            // make guess
            guess = getGuess(view.suitPrompt(), validGuess);
            
            System.out.println("The Card is " + cards.get(r).toString());   
            // The system scores the guess and displays the card.
            if (guess.equals(cards.get(r).getSuit())){           
            // Players are awarded a point for correctly guessing.
                System.out.println(view.correct() +this.getName());
                this.addScore();
            }
            else{
                System.out.println(view.incorrect() + this.getName());
            }
        }
        }

        @Override
public String getGuess(String prompt, String[] validGuesses) {
    boolean validInput = false;
    String guess = "";
    while (!validInput) {
        System.out.println(prompt);
        guess = input.nextLine().toLowerCase();
        for (String validGuess : validGuesses) {
            if (guess.equals(validGuess)) {
                validInput = true;
                break;
            }
        }
        if (!validInput) {
            System.out.println("Invalid input. Please choose from: " + String.join(", ", validGuesses));
        }
    }
    return guess;  
    } 
}
