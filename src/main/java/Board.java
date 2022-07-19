class Board {
    private final PlayerPiece[] spaces = new PlayerPiece[64];

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
        return this.spaces[convertCoordsToIndex(x, y)];
    }

    public void SetPiece(int x, int y, PlayerPiece piece) {
        this.spaces[convertCoordsToIndex(x, y)] = piece;
    }

    public void MakeMove(int sourceX, int sourceY, int destinationX, int destinationY) {
        var piece = this.GetPiece(sourceX, sourceY);
        this.SetPiece(sourceX, sourceY, null);
        this.SetPiece(destinationX, destinationY, piece);
    }
}