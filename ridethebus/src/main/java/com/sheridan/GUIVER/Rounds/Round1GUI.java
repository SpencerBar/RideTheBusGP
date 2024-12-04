package com.sheridan.GUIVER.Rounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sheridan.GUIVER.Player;
import java.util.ArrayList;
import java.util.Random;

public class Round1GUI {

    private JFrame frame;
    private ArrayList<Player> players;
    private int currentPlayerIndex = 0;

    public Round1GUI(ArrayList<Player> players) {
        this.players = players;
        frame = new JFrame("Round 1: Red or Black");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

        // Show the player's turn
        showPlayerTurn();

        // Red or Black buttons
        JButton redButton = new JButton("Red");
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound("Red");
            }
        });

        JButton blackButton = new JButton("Black");
        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound("Black");
            }
        });

        frame.add(redButton);
        frame.add(blackButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Display the current player's turn
    private void showPlayerTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        JOptionPane.showMessageDialog(frame, currentPlayer.getName() + "'s turn to guess!", "Player Turn", JOptionPane.INFORMATION_MESSAGE);
    }

    // Play round logic: Compare player guess with actual result
    private void playRound(String playerGuess) {
        // Simulate a random card (Red or Black)
        String actualCard = new Random().nextBoolean() ? "Red" : "Black";

        Player currentPlayer = players.get(currentPlayerIndex);
        if (playerGuess.equals(actualCard)) {
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
            JOptionPane.showMessageDialog(frame, "Round 1 complete. Proceeding to Round 2.");
            frame.dispose();
            new Round2GUI(players);  // Move to the next round with the updated players list
        }
    }
}
