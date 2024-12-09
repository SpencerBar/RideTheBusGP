package com.sheridan.View;

public class PlayerView {
    
    /* 
    this class contains the prompts/text used throughout the game.
    any edits to prompts can be made here.
    */ 

    // CORRECT INCORRECT 
    public String correct(){
        return "Correct! Point for ";
    }

    public String incorrect(){
        return "Incorrect! No Point for ";
    }

    // BLACK OR RED PROMPTS
    public String colourPrompt(){
        return "Red or Black?";
    }

    public void colourPromptError(){
        System.out.println("Invalid input. Please guess one of the following: red, black");
    }

    // HIGHER OR LOWER PROMPTS
    public String highLowPrompt(){
        return "Higher or Lower?";
    }

    public void highLowPromptError(){
        System.out.println("Invalid input. Please guess one of the following: higher, lower");
    }

    // BETWEEEN OUTSIDE PROMPTS
    public String betweenOutsidePrompt(){
       return "Between or Outside?";
    }

    public void betweenOutsidePromptError(){
        System.out.println("Invalid input. Please guess one of the following: between, outside");
    }

    // SUIT PROMPT
    public String suitPrompt(){
        return "Guess the suit! (hearts, diamonds, clubs, spades)";
    }

    public void suitPromptError(){
        System.out.println("Invalid input. Please guess one of the following: hearts, diamonds, clubs, spades.");
    }

    
    public void aiChoice(String choice){
        System.out.println(choice);
    }
}
