package chesslayer.pieces;

import boardlayer.Board;
import boardlayer.Position;
import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.enums.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return (p == null || p.getColor() != getColor());
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public final boolean[][] possibleMoves() {
        
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        
        // north
        p.setValues(position.getRow()-1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // west
        p.setValues(position.getRow(), position.getColumn()-1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // east
        p.setValues(position.getRow(), position.getColumn()+1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // west
        p.setValues(position.getRow()+1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // north-west
        p.setValues(position.getRow()-1, position.getColumn()-1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // north-east
        p.setValues(position.getRow()-1, position.getColumn()+1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // south-west
        p.setValues(position.getRow()+1, position.getColumn()-1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // south-east
        p.setValues(position.getRow()+1, position.getColumn()+1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // SPECIAL_MOVE CASTLING
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            Position positionRook1 = new Position(position.getRow(), position.getColumn() +3);
            if (testRookCastling(positionRook1)) {
                Position p1 = new Position(position.getRow(), position.getColumn()+1);
                Position p2 = new Position(position.getRow(), position.getColumn()+2);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getColumn()+2] = true;
                }
            }

            Position positionRook2 = new Position(position.getRow(), position.getColumn() -4);
            if (testRookCastling(positionRook2)) {
                Position p1 = new Position(position.getRow(), position.getColumn()-1);
                Position p2 = new Position(position.getRow(), position.getColumn()-2);
                Position p3 = new Position(position.getRow(), position.getColumn()-3);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat[position.getRow()][position.getColumn()-2] = true;
                }
            }
        }

        return mat;
    }

    @Override
    public final String toString() {
        return "K";
    }
}
