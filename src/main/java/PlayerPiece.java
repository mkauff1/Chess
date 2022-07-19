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