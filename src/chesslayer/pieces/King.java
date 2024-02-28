package chesslayer.pieces;

import boardlayer.Board;
import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.enums.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public final String toString() {
        return "K";
    }

    @Override
    public final boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}
