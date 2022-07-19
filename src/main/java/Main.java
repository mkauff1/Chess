import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        var board = new Board();
        var renderer = new ConsoleRenderer();

        while (true) {

            Draw(board, renderer);

            System.out.println();
            System.out.print("Next Move: ");

            var sourceInput = sc.nextLine();
            var sourceParts = sourceInput.split(",");
            var sourceX = parseInt(sourceParts[0]);
            var sourceY = parseInt(sourceParts[1]);
            var destinationInput = sc.nextLine();
            var destinationParts = destinationInput.split(",");
            var destinationX = parseInt(destinationParts[0]);
            var destinationY = parseInt(destinationParts[1]);

            board.MakeMove(sourceX, sourceY, destinationX, destinationY);
        }
    }

    public static void Draw(Board board, Renderer renderer) throws IOException {
        renderer.ClearScreen();
        for (var y = 0; y < board.getHeight(); y++) {
            for (var x = 0; x < board.getWidth(); x++) {
                var piece = board.GetPiece(x, y);

                if (piece != null)
                    renderer.DrawPiece(x, y, piece.Piece, piece.PlayerColor);
            }
        }
        renderer.Flush();
    }
}

class Board {
    private final PlayerPiece[] squares = new PlayerPiece[64];

    public int getWidth() {
        return 8;
    }
    public int getHeight() {
        return 8;
    }
    private int convertCoordsToIndex(int x, int y){
        return y * getWidth() + x;
    }

    public Board() {
        this.SetPiece(0, 0, new PlayerPiece(PlayerColor.BLACK, Piece.Rook));
        this.SetPiece(1, 0, new PlayerPiece(PlayerColor.BLACK, Piece.Knight));
        this.SetPiece(2, 0, new PlayerPiece(PlayerColor.BLACK, Piece.Bishop));
        this.SetPiece(3, 0, new PlayerPiece(PlayerColor.BLACK, Piece.Queen));
        this.SetPiece(4, 0, new PlayerPiece(PlayerColor.BLACK, Piece.King));
        this.SetPiece(5, 0, new PlayerPiece(PlayerColor.BLACK, Piece.Bishop));
        this.SetPiece(6, 0, new PlayerPiece(PlayerColor.BLACK, Piece.Knight));
        this.SetPiece(7, 0, new PlayerPiece(PlayerColor.BLACK, Piece.Rook));

        this.SetPiece(0, 1, new PlayerPiece(PlayerColor.BLACK, Piece.Pawn));
        this.SetPiece(1, 1, new PlayerPiece(PlayerColor.BLACK, Piece.Pawn));
        this.SetPiece(2, 1, new PlayerPiece(PlayerColor.BLACK, Piece.Pawn));
        this.SetPiece(3, 1, new PlayerPiece(PlayerColor.BLACK, Piece.Pawn));
        this.SetPiece(4, 1, new PlayerPiece(PlayerColor.BLACK, Piece.Pawn));
        this.SetPiece(5, 1, new PlayerPiece(PlayerColor.BLACK, Piece.Pawn));
        this.SetPiece(6, 1, new PlayerPiece(PlayerColor.BLACK, Piece.Pawn));
        this.SetPiece(7, 1, new PlayerPiece(PlayerColor.BLACK, Piece.Pawn));

        this.SetPiece(0, 7, new PlayerPiece(PlayerColor.WHITE, Piece.Rook));
        this.SetPiece(1, 7, new PlayerPiece(PlayerColor.WHITE, Piece.Knight));
        this.SetPiece(2, 7, new PlayerPiece(PlayerColor.WHITE, Piece.Bishop));
        this.SetPiece(3, 7, new PlayerPiece(PlayerColor.WHITE, Piece.Queen));
        this.SetPiece(4, 7, new PlayerPiece(PlayerColor.WHITE, Piece.King));
        this.SetPiece(5, 7, new PlayerPiece(PlayerColor.WHITE, Piece.Bishop));
        this.SetPiece(6, 7, new PlayerPiece(PlayerColor.WHITE, Piece.Knight));
        this.SetPiece(7, 7, new PlayerPiece(PlayerColor.WHITE, Piece.Rook));

        this.SetPiece(0, 6, new PlayerPiece(PlayerColor.WHITE, Piece.Pawn));
        this.SetPiece(1, 6, new PlayerPiece(PlayerColor.WHITE, Piece.Pawn));
        this.SetPiece(2, 6, new PlayerPiece(PlayerColor.WHITE, Piece.Pawn));
        this.SetPiece(3, 6, new PlayerPiece(PlayerColor.WHITE, Piece.Pawn));
        this.SetPiece(4, 6, new PlayerPiece(PlayerColor.WHITE, Piece.Pawn));
        this.SetPiece(5, 6, new PlayerPiece(PlayerColor.WHITE, Piece.Pawn));
        this.SetPiece(6, 6, new PlayerPiece(PlayerColor.WHITE, Piece.Pawn));
        this.SetPiece(7, 6, new PlayerPiece(PlayerColor.WHITE, Piece.Pawn));
    }

    public PlayerPiece GetPiece(int x, int y) {
        return this.squares[convertCoordsToIndex(x, y)];
    }

    public void SetPiece(int x, int y, PlayerPiece piece) {
        this.squares[convertCoordsToIndex(x, y)] = piece;
    }

    public void MakeMove(int sourceX, int sourceY, int destinationX, int destinationY) {
        var piece = this.GetPiece(sourceX, sourceY);
        this.SetPiece(sourceX, sourceY, null);
        this.SetPiece(destinationX, destinationY, piece);
    }
}

class PlayerPiece {
    public PlayerColor PlayerColor;
    public Piece Piece;

    public PlayerPiece(PlayerColor playerColor, Piece piece) {
        this.PlayerColor = playerColor;
        this.Piece = piece;
    }

    public PlayerColor getColor() {
        return PlayerColor;
    }

    public void setColor(PlayerColor playerColor) {
        PlayerColor = playerColor;
    }

    public Piece getPiece() {
        return Piece;
    }

    public void setPiece(Piece piece) {
        Piece = piece;
    }
}

enum PlayerColor {
    BLACK,
    WHITE,
}

enum Piece {
    Rook,
    Knight,
    Bishop,
    King,
    Queen,
    Pawn,
}

interface Renderer {
    void ClearScreen() throws IOException;
    void DrawPiece(int x, int y, Piece Piece, PlayerColor PlayerColor) throws IOException;

    void Flush() throws IOException;
}

class ConsoleRenderer implements Renderer {
    private final DefaultTerminalFactory factory;
    Terminal terminal;
    public ConsoleRenderer() throws IOException {
        factory = new DefaultTerminalFactory();
        terminal = factory.createTerminal();
    }

    public void ClearScreen() throws IOException {
        terminal.clearScreen();
    }

    public void DrawPiece(int x, int y, Piece piece, PlayerColor playerColor) throws IOException {
       terminal.setCursorPosition(terminal.getCursorPosition().withColumn(x).withRow(y));

        terminal.setBackgroundColor(TextColor.ANSI.BLUE);
        terminal.setForegroundColor(playerColor == PlayerColor.BLACK ? TextColor.ANSI.BLACK : TextColor.ANSI.WHITE);
//                Console.BackgroundColor = ConsoleColor.Gray;
//                Console.ForegroundColor = color == Color.Black ? ConsoleColor.Black : ConsoleColor.White;

        switch (piece) {
            case Rook: terminal.putCharacter('R'); break;
            case Knight: terminal.putCharacter('N'); break;
            case Bishop: terminal.putCharacter('B'); break;
            case King: terminal.putCharacter('K'); break;
            case Queen: terminal.putCharacter('Q'); break;
            case Pawn: terminal.putCharacter('P'); break;
        }
    }

    @Override
    public void Flush() throws IOException {
        terminal.flush();
    }
}
