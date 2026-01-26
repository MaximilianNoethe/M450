package ch.tbz.m450.connect4.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameRulesTest {

    @Test
    public void testHorizontalWin() {
        Board board = new Board();
        // Place 4 'X' in row 0
        board.dropToken(0, 'X');
        board.dropToken(1, 'X');
        board.dropToken(2, 'X');
        board.dropToken(3, 'X');

        GameRules rules = new GameRules();
        assertTrue(rules.checkWin(board, 'X'), "Should return true for 4 horizontal tokens");
        assertFalse(rules.checkWin(board, 'O'), "Should return false for opponent");
    }

    @Test
    public void testVerticalWin() {
        Board board = new Board();
        // Place 4 'O' in column 0
        board.dropToken(0, 'O');
        board.dropToken(0, 'O');
        board.dropToken(0, 'O');
        board.dropToken(0, 'O');

        GameRules rules = new GameRules();
        assertTrue(rules.checkWin(board, 'O'), "Should return true for 4 vertical tokens");
    }

    @Test
    public void testDiagonalWin() {
        Board board = new Board();
        // Create diagonal /
        board.dropToken(0, 'X');

        board.dropToken(1, 'O');
        board.dropToken(1, 'X');

        board.dropToken(2, 'O');
        board.dropToken(2, 'O');
        board.dropToken(2, 'X');

        board.dropToken(3, 'O');
        board.dropToken(3, 'O');
        board.dropToken(3, 'O');
        board.dropToken(3, 'X');

        GameRules rules = new GameRules();
        assertTrue(rules.checkWin(board, 'X'), "Should return true for 4 diagonal tokens");
    }
}
