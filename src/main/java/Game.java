import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Game {
    private Scanner sc = new Scanner(System.in);
    private Renderer renderer;
    private Board board;

    public Game() throws IOException {
        board = new Board();
        renderer = new ConsoleRenderer();
    }

    public void Run() throws IOException {
        while (true) {
            Draw();
            PerformTurn();
        }
    }

    private void Draw() throws IOException {
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

    private void PerformTurn() {
        System.out.println();
        System.out.print("Choose the piece you want to move: ");

        var sourceInput = sc.nextLine();
        var sourceParts = sourceInput.split(",");
        var sourceX = parseInt(sourceParts[0]);
        var sourceY = parseInt(sourceParts[1]);

        System.out.println();
        System.out.print("Choose where you want to move that piece to: ");
        var destinationInput = sc.nextLine();
        var destinationParts = destinationInput.split(",");
        var destinationX = parseInt(destinationParts[0]);
        var destinationY = parseInt(destinationParts[1]);

        board.MakeMove(sourceX, sourceY, destinationX, destinationY);
    }
}

//public validMove(){
//    MakeMove < PlayerPiece;
//}