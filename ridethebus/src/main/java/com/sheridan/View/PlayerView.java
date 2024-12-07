package com.sheridan.View;

public class PlayerView {
    
    /* 
    this class contains the prompts/text used throughout the game.
    any edits to prompts can be made here.
    */ 

    // CORRECT INCORRECT 
    public String correct(){
        return "Correct! Point for Player ";
    }

    public String incorrect(){
        return "Incorrect! No Point for Player ";
    }

    // BLACK OR RED PROMPTS
    public void colourPrompt(){
        System.out.println("Red or Black?");
    }

    public void colourPromptError(){
        System.out.println("Invalid input. Please guess one of the following: red, black");
    }

    // HIGHER OR LOWER PROMPTS
    public void highLowPrompt(){
        System.out.println("Higher or Lower?");
    }

    public void highLowPromptError(){
        System.out.println("Invalid input. Please guess one of the following: higher, lower");
    }

    // BETWEEEN OUTSIDE PROMPTS
    public void betweenOutsidePrompt(){
        System.out.println("Between or Outside?");
    }

    public void betweenOutsidePromptError(){
        System.out.println("Invalid input. Please guess one of the following: between, outside");
    }

    // SUIT PROMPT
    public void suitPrompt(){
        System.out.println("Guess the suit! (hearts, diamonds, clubs, spades)");
    }

    public void suitPromptError(){
        System.out.println("Invalid input. Please guess one of the following: hearts, diamonds, clubs, spades.");
    }
    




    

}
