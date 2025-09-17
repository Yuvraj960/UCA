import java.util.*;

/**
 * Leetcode 611: Valid Triangle Number
 */
public class Triangle {
  public static int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int count = 0;

    for (int k = n - 1; k >= 2; k--) {
      int i = 0, j = k - 1;
      while (i < j) {
        if (nums[i] + nums[j] > nums[k]) {
          count += (j - i);
          j--;
        } else {
          i++;
        }
      }
    }
    return count;
  }

  /**
   * Main method to test triangleNumber with 5 test cases including edge cases.
   */
  public static void main(String[] args) {
    // Test case 1: Basic valid triangles
    int[] nums1 = {2, 2, 3, 4};
    assert triangleNumber(nums1) == 3 : "Test case 1 failed";

    // Test case 2: No valid triangles
    int[] nums2 = {1, 1, 1, 3};
    assert triangleNumber(nums2) == 0 : "Test case 2 failed";

    // Test case 3: All sides equal
    int[] nums3 = {3, 3, 3, 3};
    assert triangleNumber(nums3) == 4 : "Test case 3 failed";

    // Test case 4: Large numbers
    int[] nums4 = {10, 21, 22, 100, 101, 200, 300};
    assert triangleNumber(nums4) == 6 : "Test case 4 failed";

    // Test case 5: Edge case - less than 3 elements
    int[] nums5 = {5, 6};
    assert triangleNumber(nums5) == 0 : "Test case 5 failed";

    System.out.println("All test cases passed.");
  }
}
