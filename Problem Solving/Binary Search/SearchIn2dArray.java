public class SearchIn2dArray {
  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    
    int rows = matrix.length;
    int cols = matrix[0].length;
    int left = 0;
    int right = rows * cols - 1;
    
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int midValue = matrix[mid / cols][mid % cols];
      
      if (midValue == target) {
        return true;
      } else if (midValue < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    
    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {1, 3, 5},
      {7, 9, 11},
      {13, 15, 17}
    };
    assert searchMatrix(matrix, 9) == true : "Test case 1 failed";
    assert searchMatrix(matrix, 2) == false : "Test case 2 failed";
    assert searchMatrix(matrix, 17) == true : "Test case 3 failed";
    assert searchMatrix(matrix, 10) == false : "Test case 4 failed";
    
    System.out.println("All test cases passed!");
  }
}
