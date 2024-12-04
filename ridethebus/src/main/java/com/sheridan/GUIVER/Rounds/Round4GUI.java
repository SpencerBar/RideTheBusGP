package com.sheridan.GUIVER.Rounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sheridan.GUIVER.Player;
import java.util.ArrayList;
import java.util.Random;

public class Round4GUI {

    private JFrame frame;
    private ArrayList<Player> players;
    private int currentPlayerIndex = 0;

    public Round4GUI(ArrayList<Player> players) {
        this.players = players;
        frame = new JFrame("Round 4: Guess the Suit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

        // Show the player's turn
        showPlayerTurn();

        // Suit buttons (Hearts, Diamonds, Clubs, Spades)
        JButton heartsButton = new JButton("Hearts");
        heartsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound("Hearts");
            }
        });

        JButton diamondsButton = new JButton("Diamonds");
        diamondsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound("Diamonds");
            }
        });

        JButton clubsButton = new JButton("Clubs");
        clubsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound("Clubs");
            }
        });

        JButton spadesButton = new JButton("Spades");
        spadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound("Spades");
            }
        });

        frame.add(heartsButton);
        frame.add(diamondsButton);
        frame.add(clubsButton);
        frame.add(spadesButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Display the current player's turn
    private void showPlayerTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        JOptionPane.showMessageDialog(frame, currentPlayer.getName() + "'s turn to guess!", "Player Turn", JOptionPane.INFORMATION_MESSAGE);
    }

    // Play round logic: Compare player guess with the actual suit
    private void playRound(String playerGuess) {
        // Simulate a random suit
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String actualSuit = suits[new Random().nextInt(suits.length)];

        Player currentPlayer = players.get(currentPlayerIndex);
        if (playerGuess.equals(actualSuit)) {
            currentPlayer.setScore(currentPlayer.getScore() + 1);
            JOptionPane.showMessageDialog(frame, "Correct! You earned 1 point.");
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect! No points earned.");
        }

        // Move to the next player
        currentPlayerIndex++;
        if (currentPlayerIndex < players.size()) {
            showPlayerTurn();
        } else {
            JOptionPane.showMessageDialog(frame, "Round 4 complete. Game Over!");
            frame.dispose();  // End the game or go to a score screen
        }
    }
}
