package four;

import javax.swing.*;
import java.awt.*;

public class ConnectFour extends JFrame {

    final int ROWS = 6;
    final int COLUMNS = 7;
    Character player = 'X'; // Set X as starting player
    boolean winnerFound = false; // flag to keep track of whether there is a winner or not
    JButton[][] gameButtons = new JButton[ROWS][COLUMNS]; // 2-dim array containing the buttons to insert pieces

    /**
     * Constructor of ConnectFour class
     */
    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Connect Four");
        setVisible(true);
        setSize(700, 610);
        setLocationRelativeTo(null); // center frame on screen
        JPanel gamePanel = new JPanel(); // panel to hold the cells
        gamePanel.setBounds(0, 0, 700, 600);
        gamePanel.setLayout(new GridLayout(6, 7)); // define layout having 6 rows and 7 column
        JPanel resetPanel = new JPanel();
        resetPanel.setBounds(0,0,700,10);
        Character[] columnLetters = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        /* Two for loops to create (rows * columns) buttons with proper labels and names
           and add these buttons to the gamePanel.
         */
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < columnLetters.length; j++) {
                int sortRow = ROWS - i; // make row numbering shift from ascending to descending
                JButton button = new JButton(" "); // label button with empty -space-
                button.setName("Button" + columnLetters[j] + sortRow);
                button.setBackground(Color.lightGray);
                button.addActionListener(e -> actionPerformed(button)); // on btnClick do what's in actionPerformed method
                gameButtons[i][j] = button;
                gamePanel.add(button);
            }
        }

        // add reset button on top of gamePanel
        JButton ButtonReset = new JButton("Reset");
        ButtonReset.setName("ButtonReset");
        ButtonReset.addActionListener(e -> resetGame());
        resetPanel.add(ButtonReset);
        add(gamePanel, BorderLayout.CENTER);
        add(resetPanel, BorderLayout.SOUTH);
    }

    /**
     * Action performed by any of the gameButtons
     * @param button : clicked button of the gamePanel
     */
    public void actionPerformed(JButton button) {
        if (!winnerFound) { // check if there is a winner
            addPiece(button);
            checkWinner();
        }
    }

    /**
     * Function for placing 'X' or 'O' on the gamePanel
     * @param button : clicked button of the gamePanel
     */
    protected void addPiece(JButton button) {
        char columnLetter = button.getName().charAt(6); // get column letter from clicked button name.
        int columnIndex = columnLetter - 'A';  // convert to index number of column -> char - char = int !

        /* Find row index of the lowest available empty cell in column
         * Set initial value to -1, for a full column
         */
        int lowestEmptyRow = -1;

        // From the bottom row up find the first cell that is empty
        for (int i = ROWS - 1; i >= 0; i--) {
            JButton currentButton = gameButtons[i][columnIndex];
            if (currentButton.getText().equals(" ")) {
                lowestEmptyRow = i;
                break;
            }
        }

        // if column is full, do nothing
        if (lowestEmptyRow == -1) {
            return;
        }

        // set text of the lowest empty button to the current player symbol
        JButton lowestEmptyButton = gameButtons[lowestEmptyRow][columnIndex];
        lowestEmptyButton.setText(String.valueOf(player));

        // Change player turn
        if (player.equals('X')) {
            player = 'O';
        } else {
            player = 'X';
        }
    }

    /**
     * Function after each turn to check if 4 of the same player symbols connect.
     * Horizontal, vertical and 2 diagonal checks.
     * when a winner is determined, highlight the connecting 4 symbols.
     */
    public void checkWinner() {
        // Check for horizontal wins
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                JButton button1 = gameButtons[i][j];
                JButton button2 = gameButtons[i][j+1];
                JButton button3 = gameButtons[i][j+2];
                JButton button4 = gameButtons[i][j+3];
                if (!button1.getText().equals(" ") &&
                        button1.getText().equals(button2.getText()) &&
                        button1.getText().equals(button3.getText()) &&
                        button1.getText().equals(button4.getText())) {
                    // Highlight winning cells
                    button1.setBackground(Color.YELLOW);
                    button2.setBackground(Color.YELLOW);
                    button3.setBackground(Color.YELLOW);
                    button4.setBackground(Color.YELLOW);
                    winnerFound = true;
                    return;
                }
            }
        }
        // Check for vertical wins
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                JButton button1 = gameButtons[i][j];
                JButton button2 = gameButtons[i+1][j];
                JButton button3 = gameButtons[i+2][j];
                JButton button4 = gameButtons[i+3][j];
                if (!button1.getText().equals(" ") &&
                        button1.getText().equals(button2.getText()) &&
                        button1.getText().equals(button3.getText()) &&
                        button1.getText().equals(button4.getText())) {
                    // Highlight winning cells
                    button1.setBackground(Color.YELLOW);
                    button2.setBackground(Color.YELLOW);
                    button3.setBackground(Color.YELLOW);
                    button4.setBackground(Color.YELLOW);
                    winnerFound = true;
                    return;
                }
            }
        }
        // Check for diagonal wins (left to right)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                JButton button1 = gameButtons[i][j];
                JButton button2 = gameButtons[i+1][j+1];
                JButton button3 = gameButtons[i+2][j+2];
                JButton button4 = gameButtons[i+3][j+3];
                if (!button1.getText().equals(" ") &&
                        button1.getText().equals(button2.getText()) &&
                        button1.getText().equals(button3.getText()) &&
                        button1.getText().equals(button4.getText())) {
                    // Highlight winning cells
                    button1.setBackground(Color.YELLOW);
                    button2.setBackground(Color.YELLOW);
                    button3.setBackground(Color.YELLOW);
                    button4.setBackground(Color.YELLOW);
                    winnerFound = true;
                    return;
                }
            }
        }
        // Check for diagonal wins (right to left)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 3; j < COLUMNS; j++) {
                JButton button1 = gameButtons[i][j];
                JButton button2 = gameButtons[i+1][j-1];
                JButton button3 = gameButtons[i+2][j-2];
                JButton button4 = gameButtons[i+3][j-3];
                if (!button1.getText().equals(" ") &&
                        button1.getText().equals(button2.getText()) &&
                        button1.getText().equals(button3.getText()) &&
                        button1.getText().equals(button4.getText())) {
                    // Highlight winning cells
                    button1.setBackground(Color.YELLOW);
                    button2.setBackground(Color.YELLOW);
                    button3.setBackground(Color.YELLOW);
                    button4.setBackground(Color.YELLOW);
                    winnerFound = true;
                    return;
                }
            }
        }
    }

    /**
     * Action performed by ResetButton
     */
    public void resetGame() {
        for (int i = 0; i < this.ROWS; i++) {
            for (int j = 0; j < this.COLUMNS; j++) {

                this.gameButtons[i][j].setText(" ");
                this.gameButtons[i][j].setBackground(Color.green);
                this.gameButtons[i][j].setEnabled(true);
            }
        }
        player = 'X';
        winnerFound = false;
    }
}