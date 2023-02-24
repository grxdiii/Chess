import javax.swing.*;
import java.awt.*;

public class ChessTile extends JPanel {
    /* Variables for our tile location */
    private int locationX;
    private int locationY;
    private Color color;
    private boolean isOccupied;

    /* Constructor */
    public ChessTile(int locationX, int locationY, Color color) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.color = color;
        this.isOccupied = false;
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

    public Color isColor() {
        return color;
    }

    public boolean isOccupied() {
        return isOccupied;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
