package ch.tbz.m450.connect4.ui;

import ch.tbz.m450.connect4.logic.Board;
import ch.tbz.m450.connect4.logic.GameRules;
import java.util.Scanner;

public class ConsoleUI {
    private final Board board;
    private final GameRules gameRules;
    private final Scanner scanner;

    public ConsoleUI(Board board, GameRules gameRules, Scanner scanner) {
        this.board = board;
        this.gameRules = gameRules;
        this.scanner = scanner;
    }

    public void processTurn(char player) {
        System.out.println("Player " + player + ", enter column (0-" + (board.getCols() - 1) + "):");
        if (scanner.hasNextInt()) {
            int col = scanner.nextInt();
            try {
                board.dropToken(col, player);
                printBoard();
            } catch (Exception e) {
                System.out.println("Invalid move: " + e.getMessage());
            }
        }
    }

    public void printBoard() {
        for (int r = board.getRows() - 1; r >= 0; r--) {
            System.out.print("|");
            for (int c = 0; c < board.getCols(); c++) {
                System.out.print(board.getCell(c, r) + "|");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
}
