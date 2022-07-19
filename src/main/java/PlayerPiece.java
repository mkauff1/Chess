//import java.awt.*;
//
//public abstract class PlayerPiece {
//        public java.awt.Color Color;
//        public Piece Piece;
//
//        public PlayerPiece(Color color, Piece piece) {
//            this.Color = color;
//            this.Piece = piece;
//        }
//    }
//    public PlayerPiece GetPiece(int x, int y) {
//        return this.squares[x, y];
//    }
//
//    public void SetPiece(int x, int y, PlayerPiece piece) {
//        this.squares[x, y] = piece;
//    }
//
//    public void MakeMove(int sourceX, int sourceY, int destinationX, int destinationY) {
//        var piece = this.GetPiece(sourceX, sourceY);
//
//        this.SetPiece(sourceX, sourceY, null);
//
//        this.SetPiece(destinationX, destinationY, piece);
//    }
//}
//    private boolean killed = false;
//    private boolean white = false;
//
//    public Piece (boolean white) {
//        this.setWhite(white);
//    }
//
//    public boolean isWhite(){
//        return this.white;
//    }
//
//
//}
