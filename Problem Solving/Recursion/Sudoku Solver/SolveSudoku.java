/**
 * The SolveSudoku class provides a method to solve a given 9x9 Sudoku puzzle using backtracking.
 * The board is modified in-place to fill all empty cells ('.') with digits '1'-'9' such that
 * each row, column, and 3x3 sub-box contains all digits exactly once.
 */
public class SolveSudoku {

    /**
     * Solves the given Sudoku puzzle by filling empty cells.
     * Modifies the board in-place.
     *
     * @param board 2D char array representing the Sudoku board, with '.' for empty cells
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    /**
     * Helper method to solve the Sudoku using backtracking.
     *
     * @param board 2D char array representing the Sudoku board
     * @return true if the board can be solved, false otherwise
     */
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // all cells filled
    }

    /**
     * Checks if placing a digit at the given position is valid according to Sudoku rules.
     *
     * @param board 2D char array representing the Sudoku board
     * @param row Row index
     * @param col Column index
     * @param num Digit to place ('1'-'9')
     * @return true if valid, false otherwise
     */
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check row and column
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
            // Check 3x3 sub-box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == num) {
                return false;
            }
        }
        return true;
    }
}
