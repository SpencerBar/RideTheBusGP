package com.sheridan.Model.Players;

import java.util.ArrayList;
import java.util.Random;

import com.sheridan.Model.Cards.PlayingCard;

public class AIPlayer<T> extends Player<T> {
    private String name;

    public AIPlayer(String name) {
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
        String guess = "";
        Random random = new Random();
        int randomNum;

        for (int r = 0; r < cards.size(); r++) {
            // The system displays the first prompt “Red or Black?”
            System.out.println("Red or Black?");
            // Player(s) makes their guess.
            randomNum = random.nextInt(2);
            if (randomNum == 0) {
                guess = "red";
            } else {
                guess = "black";
            }
            // The system scores the guess and displays the card.
            System.out.println("The Card is " + cards.get(r).toString());
            correct = redblack(cards.get(r), guess);
            if (correct) {
                System.out.println("Correct! Point for Player " + i);
                // Players are awarded a point for correctly guessing.
                this.addScore();
            } else {
                System.out.println("Incorrect! No Point for Player " + i);
            }

        }

    }

    

    

    @Override
    public void Round2(ArrayList<PlayingCard> cards, int i) {
        Boolean correct = false;
        PlayingCard card1;
        PlayingCard card2;
        Random random = new Random();
        int randomNum;
        for (int r = 0; r < cards.size() - 1; r++) {
            card1 = cards.get(r);
            card2 = cards.get(r + 1);
            // The system flips the first card and shows its value to the player.
            System.out.println("The Card is " + cards.get(r).toString());
            String guess = "";

            // The system displays the first prompt “Higher or Lower?”
            System.out.println("Higher or Lower?");
            // Player(s) makes their guess.
            randomNum = random.nextInt(2);
            if (randomNum == 0) {
                guess = "higher";
            } else {
                guess = "lower";
            }

            System.out.println("The Card is " + cards.get(r + 1).toString());
            // The system scores the guess
            if (card1.getValue() == (card2.getValue())) {
                correct = true;
            } else if (guess.equals("higher")) {
                if (card1.getValue() < card2.getValue()) {
                    correct = true;
                } else {
                    correct = false;
                }
            } else if (guess.equals("lower")) {
                if (card1.getValue() > card2.getValue()) {
                    correct = true;
                } else {
                    correct = false;
                }
            }
            if (correct) {
                System.out.println("Correct! Point for Player " + i);
                // Players are awarded a point for correctly guessing.
                this.addScore();
            } else {
                System.out.println("Incorrect! No Point for Player " + i);
            }
        }

    }

    @Override
    public void Round3(ArrayList<PlayingCard> cards, int i) {
        PlayingCard card1;
        PlayingCard card2;
        PlayingCard card3;
        Boolean correct = false;
        Random random = new Random();
        int randomNum;
        for (int r = 0; r < cards.size() - 2; r++) {
            card1 = cards.get(r);
            card2 = cards.get(r + 1);
            card3 = cards.get(r + 2);
            // The system flips and displays the first two cards in the line.
            System.out.println("First Card: " + card1.toString() + " Second Card: " + card2.toString());
            String guess = "";

            // The system displays the first prompt “Between or Outside?”
            System.out.println("Between or Outside?");
            // Player(s) makes their guess.
            randomNum = random.nextInt(2);
            if (randomNum == 0) {
                guess = "between";
            } else {
                guess = "outside";
            }

            // The system scores the guess and displays the card.
            System.out.println("The Card is " + cards.get(i).toString());
            if (card3.getValue() == card1.getValue() || card3.getValue() == card2.getValue()) {
                correct = true;
            } else if (guess.equals("between")) {
                if (card3.getValue() > card1.getValue() && card3.getValue() < card2.getValue())

                {
                    correct = true;
                } else {
                    correct = false;
                }
            } else if (guess.equals("outside")) {
                if (card3.getValue() < card1.getValue() && card3.getValue() > card2.getValue()) {
                    correct = true;
                } else {
                    correct = false;
                }
            }

            if (correct) {
                System.out.println("Correct! Point for Player " + i);
                // Players are awarded a point for correctly guessing.
                this.addScore();
            } else {
                System.out.println("Incorrect! No Point for Player " + i);
            }
        }

    }

    @Override
    public void Round4(ArrayList<PlayingCard> cards, int i) {
        Random random = new Random();
        int randomNum;
        for (int r=0; r < cards.size(); r++)
        {
            String guess = "";
            // The system displays the first prompt “Guess the Suit”
            System.out.println("Guess the Suit!");
            // Player(s) makes their guess.
            
                System.out.println("Guess the Suit! (hearts, diamonds, clubs, spades)");
                randomNum = random.nextInt(4);
                if (randomNum == 0) {
                    guess = "hearts";
                } else if (randomNum == 1) {
                    guess = "diamonds";
                } else if (randomNum == 2) {
                    guess = "clubs";
                } else {
                    guess = "spades";
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
