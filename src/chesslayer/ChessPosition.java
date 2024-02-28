package chesslayer;

import boardlayer.Position;

public class ChessPosition {
    
    private char column;
    private int row;

    public ChessPosition() {
    }
    public ChessPosition(char column, int row) {
        this.column = column;
        this.row = row;
    }

    protected Position toPosition() {
        
    }

    protected ChessPosition fromPosition(Position position) {

    }
}
