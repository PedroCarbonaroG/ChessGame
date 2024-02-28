package chesslayer;

import boardlayer.Board;
import boardlayer.Piece;
import boardlayer.Position;
import chesslayer.enums.Color;
import chesslayer.exceptions.ChessException;
import chesslayer.pieces.King;
import chesslayer.pieces.Rook;

public class ChessMatch {
    
    private short turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;
    private ChessPiece enPassantVulnerable;
    private ChessPiece promoted;

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    private void placeNewPiece(char column, int row, ChessPiece chessPiece) {
        board.placePiece(chessPiece, new ChessPosition(column, row).toPosition());
    }
    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] chessMat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                chessMat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return chessMat;
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        return null;
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourePosition(source);
        Piece capturedPiece = makeMove(source, target);

        return (ChessPiece)capturedPiece;
    }
    private void validateSourePosition(Position position) {
        if (!board.thereIsAPiece(position)) { throw new ChessException("There is no piece on source position"); }
    }
    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);

        board.placePiece(p, target);

        return capturedPiece;
    }

    public ChessPiece replacePromotedPiece(String type) {
        return null;
    }
}
