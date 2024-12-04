package com.sheridan;

import java.util.ArrayList;
import com.sheridan.Model.Players.Player;

public abstract class Game {

    private final String name;//the title of the game
    private ArrayList<Player<?>> players;// the players of the game

    public Game(String name) {
        this.name = name;
        players = new ArrayList<Player<?>>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player<?>> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player<?>> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner();

}//end class
