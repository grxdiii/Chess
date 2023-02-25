import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;

public abstract class Piece {
    /* The coordinate of our piece */
    private int locationX;
    private int locationY;

    /* Our piece type, color, and image */
    private String name;
    private String color;
    private JLabel pieceImage;

    /* Constructor */
    public Piece(String name, String color, int locationX, int locationY) {
        this.name = name;
        this.color = color;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    /* Generate our piece image */
    public void generatePiece() {
        ImageIcon temp = null;
        ImageIcon finalImage;

        this.pieceImage = new JLabel();

        /* Black Pieces */
        if(this.name.equals("king") && this.color.equals("dark")) temp = new ImageIcon("/Users/gradileroi/Desktop/Chess/images/black_king.png");
        if(this.name.equals("queen") && this.color.equals("dark")) temp = new ImageIcon("/Users/gradileroi/Desktop/Chess/images/black_queen.png");
        if(this.name.equals("rook") && this.color.equals("dark")) temp = new ImageIcon("/Users/gradileroi/Desktop/Chess/images/black_rook.png");
        if(this.name.equals("knight") && this.color.equals("dark")) temp = new ImageIcon("/Users/gradileroi/Desktop/Chess/images/black_knight.png");
        if(this.name.equals("bishop") && this.color.equals("dark")) temp = new ImageIcon("/Users/gradileroi/Desktop/Chess/images/black_bishop.png");
        if(this.name.equals("pawn") && this.color.equals("dark")) temp = new ImageIcon("/Users/gradileroi/Desktop/Chess/images/black_pawn.png");

        /* White Pieces */
        if(this.name.equals("king") && this.color.equals("light")) temp = new ImageIcon("/Users/gradileroi/Desktop/Chess/images/white_king.png");
        if(this.name.equals("queen") && this.color.equals("light")) temp = new ImageIcon("/Users/gradileroi/Desktop/Chess/images/white_queen.png");
        if(this.name.equals("rook") && this.color.equals("light")) temp = new ImageIcon("/Users/gradileroi/Desktop/Chess/images/white_rook.png");
        if(this.name.equals("knight") && this.color.equals("light")) temp = new ImageIcon("/Users/gradileroi/Desktop/Chess/images/white_knight.png");
        if(this.name.equals("bishop") && this.color.equals("light")) temp = new ImageIcon("/Users/gradileroi/Desktop/Chess/images/white_bishop.png");
        if(this.name.equals("pawn") && this.color.equals("light")) temp = new ImageIcon("/Users/gradileroi/Desktop/Chess/images/white_pawn.png");

        assert temp != null;
        finalImage = new ImageIcon(temp.getImage().getScaledInstance(105, 105, Image.SCALE_SMOOTH));

        this.pieceImage.setIcon(finalImage);
    }

    abstract void move();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public JLabel getPieceImage() {
        return pieceImage;
    }
}