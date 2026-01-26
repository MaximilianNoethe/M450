package ch.tbz.m450.connect4.logic;

public class GameRules {

    public boolean checkWin(Board board, char playerToken) {
        int cols = board.getCols();
        int rows = board.getRows();

        // Horizontal
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols - 3; c++) {
                if (board.getCell(c, r) == playerToken &&
                        board.getCell(c + 1, r) == playerToken &&
                        board.getCell(c + 2, r) == playerToken &&
                        board.getCell(c + 3, r) == playerToken) {
                    return true;
                }
            }
        }

        // Vertical
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows - 3; r++) {
                if (board.getCell(c, r) == playerToken &&
                        board.getCell(c, r + 1) == playerToken &&
                        board.getCell(c, r + 2) == playerToken &&
                        board.getCell(c, r + 3) == playerToken) {
                    return true;
                }
            }
        }

        // Diagonal / (Up-Right)
        for (int c = 0; c < cols - 3; c++) {
            for (int r = 0; r < rows - 3; r++) {
                if (board.getCell(c, r) == playerToken &&
                        board.getCell(c + 1, r + 1) == playerToken &&
                        board.getCell(c + 2, r + 2) == playerToken &&
                        board.getCell(c + 3, r + 3) == playerToken) {
                    return true;
                }
            }
        }

        // Diagonal \ (Down-Right)
        for (int c = 0; c < cols - 3; c++) {
            for (int r = 3; r < rows; r++) {
                if (board.getCell(c, r) == playerToken &&
                        board.getCell(c + 1, r - 1) == playerToken &&
                        board.getCell(c + 2, r - 2) == playerToken &&
                        board.getCell(c + 3, r - 3) == playerToken) {
                    return true;
                }
            }
        }

        return false;
    }
}
