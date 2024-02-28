package chesslayer;

import boardlayer.Board;
import chesslayer.enums.Color;

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
