package com.sheridan.GUIVER.Rounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sheridan.GUIVER.Player;
import java.util.ArrayList;
import java.util.Random;

public class Round2GUI {

    private JFrame frame;
    private ArrayList<Player> players;
    private int currentPlayerIndex = 0;
    private int currentCardValue;

    public Round2GUI(ArrayList<Player> players) {
        this.players = players;
        this.currentCardValue = new Random().nextInt(13) + 1;  // Random card value between 1 and 13
        frame = new JFrame("Round 2: Higher or Lower");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

        // Show the player's turn
        showPlayerTurn();

        // Higher or Lower buttons
        JButton higherButton = new JButton("Higher");
        higherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound("Higher");
            }
        });

        JButton lowerButton = new JButton("Lower");
        lowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound("Lower");
            }
        });

        frame.add(higherButton);
        frame.add(lowerButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Display the current player's turn
    private void showPlayerTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        JOptionPane.showMessageDialog(frame, currentPlayer.getName() + "'s turn to guess!", "Player Turn", JOptionPane.INFORMATION_MESSAGE);
    }

    // Play round logic: Compare player guess with actual card value
    private void playRound(String playerGuess) {
        // Simulate a random next card value between 1 and 13
        int nextCardValue = new Random().nextInt(13) + 1;

        Player currentPlayer = players.get(currentPlayerIndex);
        if ((playerGuess.equals("Higher") && nextCardValue > currentCardValue) ||
            (playerGuess.equals("Lower") && nextCardValue < currentCardValue)) {
            currentPlayer.setScore(currentPlayer.getScore() + 1);
            JOptionPane.showMessageDialog(frame, "Correct! You earned 1 point.");
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect! No points earned.");
        }

        // Update the current card value for the next round
        currentCardValue = nextCardValue;

        // Move to the next player
        currentPlayerIndex++;
        if (currentPlayerIndex < players.size()) {
            showPlayerTurn();
        } else {
            JOptionPane.showMessageDialog(frame, "Round 2 complete. Proceeding to Round 3.");
            frame.dispose();
            new Round3GUI(players);  // Move to the next round with the updated players list
        }
    }
}
