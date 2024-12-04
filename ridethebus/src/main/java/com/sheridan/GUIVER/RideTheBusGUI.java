package com.sheridan.GUIVER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RideTheBusGUI {

    private JFrame frame;
    private JPanel menuPanel;
    private JPanel gamePanel;
    private ArrayList<Player> players;
    private int currentRound = 1;
    private int currentPlayerIndex = 0;
    private int numberOfPlayers = 2; // Default number of players set to 2
    private boolean gameStarted = false; // Track if the game has started
    private int[] playerScores;

    public RideTheBusGUI() {
        frame = new JFrame("Ride The Bus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);  // Set the size of the window
        frame.setLayout(new CardLayout());

        // Set background color for the JFrame
        frame.getContentPane().setBackground(Color.BLACK);

        // Initialize the menu screen and game screen
        menuPanel = createMenuScreen();
        gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());

        // Add the panels to the frame using CardLayout
        frame.add(menuPanel, "Menu");
        frame.add(gamePanel, "Game");

        frame.setLocationRelativeTo(null);  // Center the window
        frame.setVisible(true);
    }

    // Create the menu screen
    private JPanel createMenuScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));  // 5 rows for buttons, with spacing between

        panel.setBackground(Color.BLACK);

        // Start Game Button
        JButton startButton = createStyledButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameStarted) {
                    startGame();
                    gameStarted = true; // Set game as started
                }
            }
        });

        // Change Number of Players Button
        JButton changePlayersButton = createStyledButton("Change Number of Players");
        changePlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNumberOfPlayers();
            }
        });

        // Explain Button
        JButton explainButton = createStyledButton("Explain Rounds");
        explainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRoundsExplanation();
            }
        });

        // Add buttons to the panel
        panel.add(startButton);
        panel.add(changePlayersButton);
        panel.add(explainButton);
        panel.add(new JLabel());  // Empty label for spacing
        panel.add(new JLabel());  // Empty label for spacing

        return panel;
    }

    // Method to start the game directly with the default number of players (2)
    private void startGame() {
        // Initialize players with the default number (2)
        players = new ArrayList<>();
        playerScores = new int[numberOfPlayers]; // Track player scores
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("Player " + i));  // Create the players based on the number
        }

        // Switch to the game screen
        switchToGameScreen();
    }

    // Method to switch to the game screen
    private void switchToGameScreen() {
        // Remove the menu panel and show the game screen
        menuPanel.setVisible(false);
        gamePanel.setVisible(true);

        // Start the game rounds
        showRound();
    }

    // Method to show rounds explanation
    private void showRoundsExplanation() {
        String explanation = "Round 1: Red or Black - Players guess whether the next card drawn will be red or black.\n" +
        "Round 2: Higher or Lower - Players guess whether the next card will be higher or lower than the current card.\n" +
        "Round 3: Between or Outside - Players guess whether the next card will fall between or outside the range of two numbers based on the current card.\n" +
        "Round 4: Guess the Suit - Players guess the suit of the next card drawn (hearts, diamonds, clubs, or spades).";
        JOptionPane.showMessageDialog(frame, explanation, "Game Rounds Explanation", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to set the number of players
    private void setNumberOfPlayers() {
        String[] options = {"2", "3", "4", "5", "6"};
        String input = (String) JOptionPane.showInputDialog(
                frame,
                "Select Number of Players:",
                "Set Number of Players",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                "2"
        );

        if (input != null) {
            numberOfPlayers = Integer.parseInt(input); // Store the number of players
            JOptionPane.showMessageDialog(frame, "Number of players set to: " + numberOfPlayers);
        }
    }

    // Method to display the appropriate round based on currentRound
    private void showRound() {
        // Remove any existing components in the game panel
        gamePanel.removeAll();

        // Show the player's turn message
        Player currentPlayer = players.get(currentPlayerIndex);
        JLabel playerLabel = new JLabel(currentPlayer.getName() + "'s Turn", SwingConstants.CENTER);
        playerLabel.setForeground(Color.WHITE);
        playerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gamePanel.add(playerLabel, BorderLayout.NORTH);

        // Create a new JPanel for the buttons, and add it to the game panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10)); // 1 row, 2 columns, with spacing between buttons
        buttonPanel.setBackground(Color.BLACK);

        // Create buttons based on the current round
        if (currentRound == 1) {
            createRedOrBlackButtons(buttonPanel);
        } else if (currentRound == 2) {
            createHigherOrLowerButtons(buttonPanel);
        } else if (currentRound == 3) {
            createBetweenOrOutsideButtons(buttonPanel);
        } else if (currentRound == 4) {
            createGuessTheSuitButtons(buttonPanel);
        }

        // Center the buttons and add them to the frame
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        gamePanel.add(buttonPanel, BorderLayout.CENTER);

        // Refresh the window to update the UI
        gamePanel.revalidate();
        gamePanel.repaint();
    }

    // Create buttons for Round 1: Red or Black
    private void createRedOrBlackButtons(JPanel buttonPanel) {
        JButton redButton = createStyledButton("Red");
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateRedOrBlackChoice("Red");
            }
        });

        JButton blackButton = createStyledButton("Black");
        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateRedOrBlackChoice("Black");
            }
        });

        buttonPanel.add(redButton);
        buttonPanel.add(blackButton);
    }

    // Method to evaluate Red or Black choice
    private void evaluateRedOrBlackChoice(String choice) {
        // Simulating card draw: for now, randomly choose Red or Black
        String drawnCard = Math.random() > 0.5 ? "Red" : "Black";
        
        // Provide feedback
        String message = "You guessed: " + choice + "\n";
        message += "Card drawn: " + drawnCard + "\n";
        
        if (choice.equals(drawnCard)) {
            message += "Correct! You earn a point.";
            playerScores[currentPlayerIndex]++;
        } else {
            message += "Wrong! No point earned.";
        }

        // Show feedback to the player
        JOptionPane.showMessageDialog(frame, message);

        // Move to next player or next round
        nextPlayerOrRound();
    }

    // Create buttons for Round 2: Higher or Lower
    private void createHigherOrLowerButtons(JPanel buttonPanel) {
        JButton higherButton = createStyledButton("Higher");
        higherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateHigherOrLowerChoice("Higher");
            }
        });

        JButton lowerButton = createStyledButton("Lower");
        lowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateHigherOrLowerChoice("Lower");
            }
        });

        buttonPanel.add(higherButton);
        buttonPanel.add(lowerButton);
    }

    // Method to evaluate Higher or Lower choice
    private void evaluateHigherOrLowerChoice(String choice) {
        // Simulating card draw: for now, randomly choose a value for the card
        int drawnCardValue = (int) (Math.random() * 13) + 1;  // Value between 1 and 13

        int currentCardValue = (int) (Math.random() * 13) + 1;  // Random current card value

        String message = "Current Card Value: " + currentCardValue + "\n";
        message += "You guessed: " + choice + "\n";
        
        if ((choice.equals("Higher") && drawnCardValue > currentCardValue) || 
            (choice.equals("Lower") && drawnCardValue < currentCardValue)) {
            message += "Correct! You earn a point.";
            playerScores[currentPlayerIndex]++;
        } else {
            message += "Wrong! No point earned.";
        }

        // Show feedback to the player
        JOptionPane.showMessageDialog(frame, message);

        // Move to next player or next round
        nextPlayerOrRound();
    }

    // Create buttons for Round 3: Between or Outside
    private void createBetweenOrOutsideButtons(JPanel buttonPanel) {
        JButton betweenButton = createStyledButton("Between");
        betweenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateBetweenOrOutsideChoice("Between");
            }
        });

        JButton outsideButton = createStyledButton("Outside");
        outsideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateBetweenOrOutsideChoice("Outside");
            }
        });

        buttonPanel.add(betweenButton);
        buttonPanel.add(outsideButton);
    }

    // Method to evaluate Between or Outside choice
    private void evaluateBetweenOrOutsideChoice(String choice) {
        // Simulating card draw: for now, randomly choose two values for the cards
        int card1 = (int) (Math.random() * 13) + 1;
        int card2 = (int) (Math.random() * 13) + 1;

        int drawnCard = (int) (Math.random() * 13) + 1; // Random drawn card value

        String message = "Card 1: " + card1 + ", Card 2: " + card2 + "\n";
        message += "You guessed: " + choice + "\n";
        
        if ((choice.equals("Between") && drawnCard > card1 && drawnCard < card2) || 
            (choice.equals("Outside") && (drawnCard < card1 || drawnCard > card2))) {
            message += "Correct! You earn a point.";
            playerScores[currentPlayerIndex]++;
        } else {
            message += "Wrong! No point earned.";
        }

        // Show feedback to the player
        JOptionPane.showMessageDialog(frame, message);

        // Move to next player or next round
        nextPlayerOrRound();
    }

    // Create buttons for Round 4: Guess the Suit
    private void createGuessTheSuitButtons(JPanel buttonPanel) {
        JButton heartsButton = createStyledButton("Hearts");
        heartsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateGuessTheSuitChoice("Hearts");
            }
        });

        JButton diamondsButton = createStyledButton("Diamonds");
        diamondsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateGuessTheSuitChoice("Diamonds");
            }
        });

        JButton clubsButton = createStyledButton("Clubs");
        clubsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateGuessTheSuitChoice("Clubs");
            }
        });

        JButton spadesButton = createStyledButton("Spades");
        spadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateGuessTheSuitChoice("Spades");
            }
        });

        buttonPanel.add(heartsButton);
        buttonPanel.add(diamondsButton);
        buttonPanel.add(clubsButton);
        buttonPanel.add(spadesButton);
    }

    // Method to evaluate Guess the Suit choice
    private void evaluateGuessTheSuitChoice(String choice) {
        // Simulating card suit draw: for now, randomly choose a suit
        String drawnSuit = getRandomSuit();
        
        String message = "You guessed: " + choice + "\n";
        message += "Card drawn: " + drawnSuit + "\n";
        
        if (choice.equals(drawnSuit)) {
            message += "Correct! You earn a point.";
            playerScores[currentPlayerIndex]++;
        } else {
            message += "Wrong! No point earned.";
        }

        // Show feedback to the player
        JOptionPane.showMessageDialog(frame, message);

        // Move to next player or next round
        nextPlayerOrRound();
    }

    // Method to get a random suit
    private String getRandomSuit() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        return suits[(int) (Math.random() * suits.length)];
    }

    // Method to move to the next player or round
    private void nextPlayerOrRound() {
        // Update player index and check if it's time to move to the next round
        currentPlayerIndex++;
        if (currentPlayerIndex >= numberOfPlayers) {
            currentPlayerIndex = 0;
            currentRound++;
        }
        
        // If all rounds have been played, end the game
        if (currentRound > 4) {
            JOptionPane.showMessageDialog(frame, "Game over! Final Scores:\n" +
                    getFinalScores(), "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else {
            showRound();
        }
    }

    // Method to return the final scores of players
    private String getFinalScores() {
        StringBuilder scores = new StringBuilder();
        for (int i = 0; i < numberOfPlayers; i++) {
            scores.append(players.get(i).getName()).append(": ").append(playerScores[i]).append("\n");
        }
        return scores.toString();
    }

    // Utility method to create styled buttons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);  // Set button color to red
        button.setForeground(Color.WHITE);  // Set text color to white
        button.setFont(new Font("Arial", Font.BOLD, 16));  // Set font style
        return button;
    }

    // Player class to hold player information
    class Player {
        private String name;

        public Player(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        new RideTheBusGUI();
    }
}
