package chesslayer;

import boardlayer.Board;
import boardlayer.Position;
import chesslayer.enums.Color;

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

    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITE), new Position(0, 7));
        board.placePiece(new Rook(board, Color.WHITE), new Position(1, 7));
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

    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {

    }

    public ChessPiece replacePromotedPiece(String type) {

    }
}
