import javax.swing.*;

public class ChessTile extends JPanel {
    private int locationX;
    private int locationY;

    private boolean color;
    private boolean isOccupied;

    /* Constructor to represent our chess tiles
    *  Each tiles is given a location, a color, and a boolean values that tells us if its occupied */
    public ChessTile(int locationX, int locationY, boolean color) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.color = color;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public boolean isColor() {
        return color;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
