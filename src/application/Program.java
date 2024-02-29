package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.ChessPosition;
import chesslayer.exceptions.ChessException;

public class Program {
    
    private static Scanner sc = new Scanner(System.in, "UTF-8");
    private static ChessMatch chessMatch = new ChessMatch();
    private static List<ChessPiece> capturedPieces = new ArrayList<>();

    public static void main(String[] args) {

        while (!chessMatch.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, capturedPieces);
                System.out.println();
                System.out.print("Source: "); ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: "); ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                if (capturedPiece != null) { capturedPieces.add(capturedPiece); }

                if (chessMatch.getPromoted() != null) {
                    System.out.print("Enter piece for promotion (B/N/R/Q): ");
                    String type = sc.nextLine();
                    chessMatch.replacePromotedPiece(type.toUpperCase());
                }
            }
            catch (ChessException e) { System.out.print(e.getMessage() + ", Press enter to do other move."); sc.nextLine(); }
            catch (InputMismatchException e) { System.out.print(e.getMessage() + ", Press enter to do other move."); sc.nextLine(); }
        }

        UI.clearScreen();
        UI.printMatch(chessMatch, capturedPieces);
    }
}