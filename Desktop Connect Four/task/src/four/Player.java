/**
 *  Obsolete file and class
 *  I was trying out a few things from the theory: constructor, setters and getters, ...
 *  In the end I didn't have any use for this class
 */

package four;

public class Player {
    public String name;
    public Character playerSymbol = 'X';

    // constructor
    public void Player(String name, Character playerSymbol) {
        this.name = name;
        this.playerSymbol = playerSymbol;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerSymbol(Character playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public String getName() {
        return name;
    }

    public Character getPlayerSymbol() {
        return playerSymbol;
    }

    public Character changeTurn() {
        if (playerSymbol.equals('X')) {
            playerSymbol = 'O';
        } else {
            playerSymbol = 'X';
        }
        return playerSymbol;
    }
}
