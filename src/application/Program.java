package application;

import java.util.Scanner;

import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.ChessPosition;

public class Program {
    
    private static Scanner sc = new Scanner(System.in, "UTF-8");

    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source: "); ChessPosition source = UI.readChessPosition(sc);

            System.out.println();
            System.out.print("Target: "); ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
        }
    }
}