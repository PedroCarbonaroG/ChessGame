package chesslayer.pieces;

import boardlayer.Board;
import boardlayer.Position;
import chesslayer.ChessPiece;
import chesslayer.enums.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // north-west1
        p.setValues(position.getRow()-2, position.getColumn()-1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // north-west2
        p.setValues(position.getRow()-1, position.getColumn()-2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // north-east1
        p.setValues(position.getRow()-2, position.getColumn()+1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // north-east2
        p.setValues(position.getRow()-1, position.getColumn()+2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // south-west1
        p.setValues(position.getRow()+1, position.getColumn()-2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // // south-west2
        p.setValues(position.getRow()+2, position.getColumn()-1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // // south-east1
        p.setValues(position.getRow()+1, position.getColumn()+2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // // south-east2
        p.setValues(position.getRow()+2, position.getColumn()+1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) || getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }

    @Override
    public final String toString() {
        return "H";
    }
}
