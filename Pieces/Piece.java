public abstract class Piece {
    private boolean killed = false;
    private boolean white = false;

    public Piece (boolean white) {
        this.setWhite(white);
    }

    public boolean isWhite(){
        return this.white;
    }

    
}
