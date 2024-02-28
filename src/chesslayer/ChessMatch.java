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

    public ChessPiece[][] getPieces() {

    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {

    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {

    }

    public ChessPiece replacePromotedPiece(String type) {

    }
}
