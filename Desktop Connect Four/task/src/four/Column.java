package four;

public class Column {
    int colSize;

    String[] buttons;

    public void Column(int colSize, String[] buttons) {
        this.colSize = colSize;
        this.buttons = buttons;
    }

    public void setColSize(int colSize) {
        this.colSize = colSize;
    }

    public void setButtons(String[] buttons) {
        this.buttons = buttons;
    }
}