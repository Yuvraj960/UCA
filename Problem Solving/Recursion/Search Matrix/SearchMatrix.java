public class SearchMatrix {
  /**
   * Search a 2D matrix where rows and columns are sorted in non-decreasing order.
   * Uses recursion starting from top-right corner to eliminate rows/columns efficiently.
   * 
   * @param matrix A 2D array of integers representing the sorted matrix.
   * @param target The integer to search for in the matrix.
   * @return True if target is found in the matrix, otherwise false.
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    // Start from top-right corner
    return search(matrix, target, 0, matrix[0].length - 1);
  }

  /**
   * Recursively searches for target starting from position (row, col).
   * Starting from top-right allows us to eliminate a row or column each time.
   * 
   * @param matrix The sorted 2D matrix.
   * @param target The value to search for.
   * @param row Current row position.
   * @param col Current column position.
   * @return True if target is found, false otherwise.
   */
  private boolean search(int[][] matrix, int target, int row, int col) {
    // Base case: out of bounds
    if (row >= matrix.length || col < 0) {
      return false;
    }
    
    int current = matrix[row][col];
    
    // Found the target
    if (current == target) {
      return true;
    }
    
    // If current is greater than target, move left (eliminate this column)
    if (current > target) {
      return search(matrix, target, row, col - 1);
    }
    
    // If current is less than target, move down (eliminate this row)
    return search(matrix, target, row + 1, col);
  }

    /**
     * Main method for testing the SearchMatrix class.
     */
    public static void main(String[] args) {
        SearchMatrix sm = new SearchMatrix();
        
        int[][] matrix1 = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        assert sm.searchMatrix(matrix1, 5) == true : "Test case 1 failed";
        assert sm.searchMatrix(matrix1, 20) == false : "Test case 2 failed";

        int[][] matrix2 = {
            {-1, 3}
        };
        assert sm.searchMatrix(matrix2, 3) == true : "Test case 3 failed";
        assert sm.searchMatrix(matrix2, -1) == true : "Test case 4 failed";
        assert sm.searchMatrix(matrix2, 0) == false : "Test case 5 failed";
    }
}

