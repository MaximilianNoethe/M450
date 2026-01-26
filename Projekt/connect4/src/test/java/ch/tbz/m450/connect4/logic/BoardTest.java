package ch.tbz.m450.connect4.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testNewBoardShouldHaveCorrectDimensionsAndBeEmpty() {
        Board board = new Board();

        // Connect 4 standard size: 7 columns, 6 rows
        assertEquals(7, board.getCols(), "Board should have 7 columns");
        assertEquals(6, board.getRows(), "Board should have 6 rows");

        // Check that all cells are initialized to empty char, e.g., ' ' or '\0'
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getCols(); col++) {
                assertEquals(' ', board.getCell(col, row), "Board should be empty initially");
            }
        }
    }

    @Test
    public void testDropTokenShouldPlaceTokenAtBottom() {
        Board board = new Board();

        // Drop token in column 0
        board.dropToken(0, 'X');

        // Row 0 (bottom) should have 'X'
        assertEquals('X', board.getCell(0, 0), "Token should settle at the bottom (row 0)");

        // Row 1 should still be empty
        assertEquals(' ', board.getCell(0, 1), "Row above should be empty");

        // Drop another token in column 0
        board.dropToken(0, 'O');

        // Row 1 should now have 'O'
        assertEquals('O', board.getCell(0, 1), "Second token should stack on top");
    }
}
