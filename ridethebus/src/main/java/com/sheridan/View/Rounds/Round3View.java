package com.sheridan.View.Rounds;

import java.util.ArrayList;

import com.sheridan.Model.Players.Player;

public class Round3View {
    

    private ArrayList<Player<?>> playerList;
    public Round3View(ArrayList<Player<?>> playerList){
        this.playerList = playerList;
    }



    public void round3Start(){
        System.out.println(" #####    #####   ##   ##   ##   ##  ## # #     #######  ");
        System.out.println(" ##  ##  ##   ##  ##   ##   ###  ##  ##   ##         ##   ");
        System.out.println(" ##  ##  ##   ##  ##   ##   #### ##  ##   ##         ##   ");
        System.out.println(" #####   ##   ##  ##   ##   ## ####  ##   ##     ######   ");
        System.out.println(" ## ##   ##   ##  ##   ##   ##  ###  ##   ##         ##   ");
        System.out.println(" ##  ##  ##   ##  ##   ##   ##   ##  ##   ##         ##   ");
        System.out.println(" ##   ##  #####     ###     ##   ##  ## # #     #######   ");
    }

    public void showScores(){
        System.out.println("Scores after this round:");
        for (int i= 0; i < playerList.size();i++) {
        System.out.println("Player" + i+1 + ": " + playerList.get(i).getScore());
        }
    }
}
