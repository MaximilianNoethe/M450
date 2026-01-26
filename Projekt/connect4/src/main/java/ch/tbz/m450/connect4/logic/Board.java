package ch.tbz.m450.connect4.logic;

public class Board {

    private static final int COLS = 7;
    private static final int ROWS = 6;
    private final char[][] grid;

    public Board() {
        grid = new char[COLS][ROWS];
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public int getCols() {
        return COLS;
    }

    public int getRows() {
        return ROWS;
    }

    public char getCell(int col, int row) {
        if (col < 0 || col >= COLS || row < 0 || row >= ROWS) {
            throw new IllegalArgumentException("Coordinates out of bounds");
        }
        return grid[col][row];
    }

    public void dropToken(int col, char playerToken) {
        if (col < 0 || col >= COLS) {
            throw new IllegalArgumentException("Column out of bounds");
        }
        for (int row = 0; row < ROWS; row++) {
            if (grid[col][row] == ' ') {
                grid[col][row] = playerToken;
                return;
            }
        }
        throw new IllegalStateException("Column is full");
    }
}
