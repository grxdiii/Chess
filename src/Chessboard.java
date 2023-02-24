import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Chessboard {
    /* Variables for our Chess board */
    private JFrame frame;
    private ChessTile boardTiles[][];

    /* Stores Pieces information */
    private String boardState;
    private Image pieceImage[];
    private static Color light = Color.decode("#fafbfc");
    private static Color dark = Color.decode("#5b80ba");

    /* Constructor to generate our chess board */
    public Chessboard () throws HeadlessException {
        this.boardTiles = new ChessTile[8][8];
        this.boardState = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

        this.frame = new JFrame();
        this.frame.setTitle("Chess");
        this.frame.setSize(1080, 1108);
        this.frame.setDefaultCloseOperation(3);

        generateChessBoard(boardTiles);

        this.frame.setVisible(true);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
    }

    /* Function to draw our chess board */
    private void generateChessBoard(ChessTile boardTiles[][]) {
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
                tiles.setBounds(locationX * 135, locationY * 135, 135, 135);
                boardTiles[locationX][7 - locationY] = tiles;
                this.frame.add(tiles);
            }
        }
    }

    /* Function to generate our pieces and draw them on our board */
    private void generatePieces() throws IOException {
        this.pieceImage = new Image[12];

        pieceImage[0] = ImageIO.read(new File("../images/black_king.png"));
        pieceImage[1] = ImageIO.read(new File("../images/black_queen.png"));
        pieceImage[2] = ImageIO.read(new File("../image/black_rook.png"));
        pieceImage[3] = ImageIO.read(new File("../image/black_bishop.png"));
        pieceImage[4] = ImageIO.read(new File("../image/black_knight.png"));
        pieceImage[5] = ImageIO.read(new File("../image/black_pawn.png"));
        pieceImage[6] = ImageIO.read(new File("../image/white_king.png"));
        pieceImage[7] = ImageIO.read(new File("../image/white_queen.png"));
        pieceImage[8] = ImageIO.read(new File("../image/white_rook.png"));
        pieceImage[9] = ImageIO.read(new File("../image/white_bishop.png"));
        pieceImage[10] = ImageIO.read(new File("../image/white_knight.png"));
        pieceImage[11] = ImageIO.read(new File("../image/white_pawn.png"));
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
