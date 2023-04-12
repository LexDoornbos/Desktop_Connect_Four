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
