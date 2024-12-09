package com.sheridan.View;

/*@author Anita Kashani

*/

public class GameView {

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Ride the Bus!");
    }

    public void promptNumberOfPlayers() {
        System.out.println("Enter the number of players (1-4): ");
    }

    public void displayInvalidPlayerNumberMessage() {
        System.out.println("Invalid number of players. Please enter a number between 1 and 4.");
    }

    public void displayInvalidInputMessage() {
        System.out.println("Invalid input. Please enter a valid number.");
    }

    public void displayEndMessage() {
        System.out.println("Thank you for playing Ride the Bus!");
    }
}
