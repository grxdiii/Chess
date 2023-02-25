import javax.swing.*;
import java.awt.*;

public class Chessboard {
    /* Variables for our Chess board */
    private final JFrame frame;
    private ChessTile[][] boardTiles;

    /* Stores Pieces information */
    private String boardState;
    private static final Color light = Color.decode("#f0f0f0");
    private static final Color dark = Color.decode("#5b80ba");

    /* Constructor to generate our chess board */
    public Chessboard () throws HeadlessException {
        this.boardTiles = new ChessTile[8][8];
        this.boardState = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

        /* Sets up our frame */
        this.frame = new JFrame();
        this.frame.setTitle("Chess");
        this.frame.setLayout(null);
        this.frame.setSize(920, 948);
        this.frame.setDefaultCloseOperation(3);

        /* Generates our initial board */
        generateChessBoard();
        generatePieces();

        /* More frame settings */
        this.frame.setVisible(true);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
    }

    /* Function to draw our chess board */
    private void generateChessBoard() {
        Color tileColor;

        /* Chess boards are represented using 2d arrays, hence why we have a for loop within another */
        for(int locationX = 0; locationX < 8; locationX++) {
            for(int locationY = 0; locationY < 8; locationY++) {

                /* Sets the color of our chess tile */
                if((locationX % 2) == (locationY % 2)) tileColor = light;
                else tileColor = dark;

                /* Creates an instance of our chess tile */
                ChessTile tiles = new ChessTile(locationX, locationY, tileColor);

                /* Adds our tile to our frame */
                tiles.setBackground(tileColor);
                tiles.setBounds(locationX * 115, locationY * 115, 115, 115);
                this.boardTiles[locationX][7 - locationY] = tiles;
                this.frame.add(tiles);
            }
        }
    }

    /* Generates piece (helper function) */
    private void pieceCase(char piece, String color, int locationX, int locationY) {
        piece = Character.toLowerCase(piece);

        /* Generates piece based on the letters we read */
        if(piece == 'k') boardTiles[locationX][locationY].setPiece(new King("king", color, locationX, locationY));
        if(piece == 'q') boardTiles[locationX][locationY].setPiece(new Queen("queen", color, locationX, locationY));
        if(piece == 'r') boardTiles[locationX][locationY].setPiece(new Rook("rook", color, locationX, locationY));
        if(piece == 'n') boardTiles[locationX][locationY].setPiece(new Knight("knight", color, locationX, locationY));
        if(piece == 'b') boardTiles[locationX][locationY].setPiece(new Bishop("bishop", color, locationX, locationY));
        if(piece == 'p') boardTiles[locationX][locationY].setPiece(new Pawn("pawn", color, locationX, locationY));

        /* Adds our piece to our board and tile */
        boardTiles[locationX][locationY].setOccupied(true);
        boardTiles[locationX][locationY].addPiece();
    }

    /* Function to generate our pieces and draw them on our board */
    private void generatePieces() {
        char buffer; int locationX = 0; int locationY = 0;

        /* Reads our FEN string - one character at a time */
        for(int i = 0; i < this.boardState.length(); i++) {
            buffer = this.boardState.charAt(i);

            /* If our character is alphabetic, we know that it represents a piece */
            if(Character.isAlphabetic(buffer)) {

                /* Generates our piece */
                if(Character.isLowerCase(buffer)) pieceCase(buffer, "light", locationX, locationY);
                else pieceCase(buffer, "dark", locationX, locationY);
                locationX++;

            /* If our character is a numebr, we know that it represents spaces */
            } else if (Character.isDigit(buffer)) {
                locationX += Character.getNumericValue(buffer) - 1;

            /* If our character is anything else, we know that we should go to another row */
            } else if(buffer == '/') {
                locationX = 0; locationY++;
            }
        }
    }

    public ChessTile[][] getBoardTiles() {
        return boardTiles;
    }

    public void setBoardTiles(ChessTile[][] boardTiles) {
        this.boardTiles = boardTiles;
    }

    public String getBoardState() {
        return boardState;
    }

    public void setBoardState(String boardState) {
        this.boardState = boardState;
    }
}