import java.io.IOException;

interface Renderer {
    void ClearScreen() throws IOException;
    void DrawPiece(int x, int y, Piece Piece, PlayerColor PlayerColor) throws IOException;

    void Flush() throws IOException;
}