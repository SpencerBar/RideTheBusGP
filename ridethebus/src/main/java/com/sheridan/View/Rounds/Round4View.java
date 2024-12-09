package com.sheridan.View.Rounds;

import java.util.ArrayList;

import com.sheridan.Model.Players.Player;

public class Round4View {
    
    private ArrayList<Player<?>> playerList;
    public Round4View(ArrayList<Player<?>> playerList){
        this.playerList = playerList;
    }


    public void round4Start(){
        System.out.println(" #####    #####   ##   ##   ##   ##   #####     #   ##   ");
        System.out.println(" ##  ##  ##   ##  ##   ##   ###  ##  ##   ##    #   ##   ");
        System.out.println(" ##  ##  ##   ##  ##   ##   #### ##  ##   ##    #   ##   ");
        System.out.println(" #####   ##   ##  ##   ##   ## ####  ##   ##    ######   ");
        System.out.println(" ## ##   ##   ##  ##   ##   ##  ###  ##   ##        ##   ");
        System.out.println(" ##  ##  ##   ##   ## ##    ##   ##  ##   ##        ##   ");
        System.out.println(" ##   ##  #####     ###     ##   ##   #####         ##   ");
    }

    public void showScores(){
        System.out.println("Scores after this round:");
        for (int i= 0; i < playerList.size();i++) {
        System.out.println("Player" + i  + ": " + playerList.get(i).getScore());
        }
    }
}
