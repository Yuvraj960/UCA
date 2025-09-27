/**
 * The Sudoku class provides a method to validate a partially filled 9x9 Sudoku board.
 * Only filled cells are validated according to Sudoku rules:
 * - Each row must contain the digits 1-9 without repetition.
 * - Each column must contain the digits 1-9 without repetition.
 * - Each 3x3 sub-box must contain the digits 1-9 without repetition.
 */
public class ValidSudoku {
  /**
   * Checks if a given 9x9 Sudoku board is valid.
   * Only filled cells (digits '1'-'9') are validated.
   *
   * @param board 2D char array representing the Sudoku board
   * @return true if the board is valid, false otherwise
   */
  public static boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      boolean[] seenRow = new boolean[9];
      boolean[] seenCol = new boolean[9];
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int num = board[i][j] - '1';
          if (seenRow[num]) return false;
            seenRow[num] = true;
          }
          if (board[j][i] != '.') {
            int num = board[j][i] - '1';
            if (seenCol[num]) return false;
              seenCol[num] = true;
            }
          }
        }

      for (int boxRow = 0; boxRow < 3; boxRow++) {
        for (int boxCol = 0; boxCol < 3; boxCol++) {
          boolean[] seenBox = new boolean[9];
          for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
              int row = boxRow * 3 + i;
              int col = boxCol * 3 + j;
              if (board[row][col] != '.') {
                int num = board[row][col] - '1';
                if (seenBox[num]) return false;
                seenBox[num] = true;
              }
            }
          }
        }
      }
      return true;
    }

  /**
   * Main method to test isValidSudoku with various test cases, including edge cases.
   * Uses assertions to validate correctness.
   *
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    // Test case 1: Valid board (Example 1)
    char[][] board1 = {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
    };
    assert isValidSudoku(board1);

    // Test case 2: Invalid board (duplicate in sub-box, Example 2)
    char[][] board2 = {
        {'8','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
    };
    assert !isValidSudoku(board2);

    // Test case 3: Empty board (edge case, should be valid)
    char[][] board3 = new char[9][9];
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++)
        board3[i][j] = '.';
    assert isValidSudoku(board3);

    // Test case 4: Invalid board (duplicate in row)
    char[][] board4 = {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','6','.','1','9','5','.','.','.'}, // duplicate '6' in row
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
    };
    assert !isValidSudoku(board4);

    // Test case 5: Invalid board (duplicate in column)
    char[][] board5 = {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'5','.','.','.','8','.','.','7','9'} // duplicate '5' in column
    };
    assert !isValidSudoku(board5);

    System.out.println("All test cases passed.");
  }
}
