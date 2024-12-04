package com.sheridan.Model.Players;

import java.util.ArrayList;

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
        
    }


    @Override
    public void Round2(ArrayList<PlayingCard> cards, int i) {
     
    }


    @Override
    public void Round3(ArrayList<PlayingCard> cards, int i) {
     
    }


    @Override
    public void Round4(ArrayList<PlayingCard> cards, int i) {
      
    }

    
    
}
