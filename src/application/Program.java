package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.ChessPosition;
import chesslayer.exceptions.ChessException;

public class Program {
    
    private static Scanner sc = new Scanner(System.in, "UTF-8");

    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch);
                System.out.println();
                System.out.print("Source: "); ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: "); ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
            catch (ChessException e) { System.out.print(e.getMessage() + ", Press enter to do other move."); sc.nextLine(); }
            catch (InputMismatchException e) { System.out.print(e.getMessage() + ", Press enter to do other move."); sc.nextLine(); }
        }
    }
}