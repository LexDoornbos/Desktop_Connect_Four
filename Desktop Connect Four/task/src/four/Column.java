/**
 *  Obsolete file and class
 *  I was trying out a few things from the theory: constructor, setters and getters, ...
 *  In the end I didn't have any use for this class
 */
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