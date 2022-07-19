import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

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