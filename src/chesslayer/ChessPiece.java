package chesslayer;

import boardlayer.Board;
import boardlayer.Piece;
import boardlayer.Position;

import chesslayer.enums.Color;

public abstract class ChessPiece extends Piece {
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public ChessPosition getChessPosition() {
        return null;
    }

    protected boolean isThereOpponentPiece(Position position) {
        return false;
    }

    protected void increaseMoveCount() {
    }

    protected void decreaseMoveCount() {
    }
}
