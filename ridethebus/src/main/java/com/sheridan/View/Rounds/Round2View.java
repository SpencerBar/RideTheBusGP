package com.sheridan.View.Rounds;

import java.util.ArrayList;

import com.sheridan.Model.Players.Player;

public class Round2View {

    private ArrayList<Player<?>> playerList;
    public Round2View(ArrayList<Player<?>> playerList){
        this.playerList = playerList;
    }

    public void round2Start(){
        System.out.println(" #####    #####   ##   ##   ##   ##  ## # #      ######  ");
        System.out.println(" ##  ##  ##   ##  ##   ##   ###  ##  ##   ##    #     ##   ");
        System.out.println(" ##  ##  ##   ##  ##   ##   #### ##  ##   ##        ##    ");
        System.out.println(" #####   ##   ##  ##   ##   ## ####  ##   ##       ##     ");
        System.out.println(" ## ##   ##   ##  ##   ##   ##  ###  ##   ##      ##      ");
        System.out.println(" ##  ##  ##   ##  ##   ##   ##   ##  ##   ##     ##       ");
        System.out.println(" ##   ##  #####     ###     ##   ##  ## # #     #######   ");
    }

    public void showScores(){
        System.out.println("Scores after this round:");
        for (int i= 0; i < playerList.size();i++) {
        System.out.println("Player " + (i+1)  + ": " + playerList.get(i).getScore());
        }
    }

}
