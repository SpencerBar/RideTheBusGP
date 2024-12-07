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
                view.colourPrompt();
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
                    view.colourPromptError();
                }
            }
            
            // The system scores the guess and displays the card.
            System.out.println("The Card is " + cards.get(r).toString());
            correct = redblack(cards.get(r), guess);
            if (correct)
            {
                System.out.println(view.correct() + i);          
            // Players are awarded a point for correctly guessing.
                this.addScore();
            }
            else{
                System.out.println(view.incorrect() + i);
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
                boolean validInput = false;

                while (!validInput) {
                    // The system displays the first prompt “Higher or Lower?”
                    view.highLowPrompt();
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
                        view.highLowPromptError();
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
                    System.out.println(view.correct() + i);
                    // Players are awarded a point for correctly guessing.
                    this.addScore();
                }
                else
                {
                    System.out.println(view.incorrect() + i);
                }
            }

    }

    @Override
    public void Round3(ArrayList<PlayingCard> cards, int i) {
        PlayingCard card1;
        PlayingCard card2;
        PlayingCard card3;
        Boolean correct= false;
        String[] validGuess = {"between", "outside"};
        for (int r=0; r < cards.size()-2; r++)
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
                    view.betweenOutsidePrompt();;
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
                        view.betweenOutsidePromptError();
                    }
                }
                // The system scores the guess and displays the card. 
                System.out.println("The Card is " + cards.get(i).toString());
                if(card3.getValue() == card1.getValue() || card3.getValue() == card2.getValue())
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
                    System.out.println(view.correct() + i);
                // Players are awarded a point for correctly guessing.
                    this.addScore();
                }
                else{
                    System.out.println(view.incorrect() + i);
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
            view.suitPrompt();
            // Player(s) makes their guess.
            while (!validInput) {
                view.suitPrompt();
                guess = input.nextLine().toLowerCase();

                // Check if input is valid
                for (String choices : validGuess) {
                    if (guess.equals(choices)) {
                        validInput = true;
                        break;
                    }
                }
                if (!validInput) {
                    view.suitPromptError();
                }
            }
            System.out.println("The Card is " + cards.get(r).toString());   
            // The system scores the guess and displays the card.
            if (guess.equals(cards.get(r).getSuit())){           
            // Players are awarded a point for correctly guessing.
                System.out.println(view.correct() + i);
                this.addScore();
            }
            else{
                System.out.println(view.incorrect() + i);
            }
        }
      
    }

    
    
}
