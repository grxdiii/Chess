import javax.swing.*;
import java.awt.*;

public class Chessboard extends JFrame {
    private ChessTile boardTiles[][];
    private String boardState;

    /* Constructor to generate our chess board */
    public Chessboard () throws HeadlessException {
        this.boardTiles = new ChessTile[8][8];

        /* The state of the game will be represented using FEN notation */
        this.boardState = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

        setTitle("Chess By Gradi");
        setSize(1080, 1108);

        generateChessBoard(boardTiles);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); setResizable(false);
    }

    /* Colors our chess tiles */
    private void generateChessBoard(ChessTile boardTiles[][]){

        /* The color value "true" represent a light/white tile */
        boolean color = true;

        for(int locationX = 0; locationX < 8; locationX++) {
            for(int locationY = 0; locationY < 8; locationY++) {
                ChessTile tiles = new ChessTile(locationX, locationY, color);

                if(color == true) tiles.setBackground(Color.decode("#fafbfc"));
                else tiles.setBackground(Color.decode("#5b80ba"));
                tiles.setBounds(locationX * 135, locationY * 135, 135, 135);
                boardTiles[locationX][7 - locationY] = tiles; add(tiles); color = !color;
            }
            color = !color;
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
