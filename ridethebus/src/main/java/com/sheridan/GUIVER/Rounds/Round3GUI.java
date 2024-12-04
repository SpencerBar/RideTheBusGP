package com.sheridan.GUIVER.Rounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sheridan.GUIVER.Player;
import java.util.ArrayList;
import java.util.Random;

public class Round3GUI {

    private JFrame frame;
    private ArrayList<Player> players;
    private int currentPlayerIndex = 0;
    private int currentCardValue;

    public Round3GUI(ArrayList<Player> players) {
        this.players = players;
        this.currentCardValue = new Random().nextInt(13) + 1;  // Random card value between 1 and 13
        frame = new JFrame("Round 3: Between or Outside");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

        // Show the player's turn
        showPlayerTurn();

        // Between or Outside buttons
        JButton betweenButton = new JButton("Between");
        betweenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound("Between");
            }
        });

        JButton outsideButton = new JButton("Outside");
        outsideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playRound("Outside");
            }
        });

        frame.add(betweenButton);
        frame.add(outsideButton);

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

        // For simplicity, assume the range is 4 and 10 (adjust as needed)
        if ((playerGuess.equals("Between") && nextCardValue >= 4 && nextCardValue <= 10) ||
            (playerGuess.equals("Outside") && (nextCardValue < 4 || nextCardValue > 10))) {
            Player currentPlayer = players.get(currentPlayerIndex);
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
            JOptionPane.showMessageDialog(frame, "Round 3 complete. Proceeding to Round 4.");
            frame.dispose();
            new Round4GUI(players);  // Move to the next round with the updated players list
        }
    }
}