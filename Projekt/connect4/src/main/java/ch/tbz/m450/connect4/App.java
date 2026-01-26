package ch.tbz.m450.connect4;

import ch.tbz.m450.connect4.logic.Board;
import ch.tbz.m450.connect4.logic.GameRules;
import ch.tbz.m450.connect4.ui.ConsoleUI;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Board board = new Board();
        GameRules rules = new GameRules();
        Scanner scanner = new Scanner(System.in);
        ConsoleUI ui = new ConsoleUI(board, rules, scanner);

        System.out.println("Welcome to Connect 4!");
        ui.printBoard();

        char currentPlayer = 'X';
        boolean gameRunning = true;

        while (gameRunning) {
            ui.processTurn(currentPlayer);
            if (rules.checkWin(board, currentPlayer)) {
                System.out.println("Player " + currentPlayer + " WINS!");
                gameRunning = false;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }
}
