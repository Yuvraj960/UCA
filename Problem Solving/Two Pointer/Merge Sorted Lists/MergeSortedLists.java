import java.util.Arrays;

public class MergeSortedLists {
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1;        // pointer for nums1
    int p2 = n - 1;        // pointer for nums2
    int p = m + n - 1;     // pointer for merged position

    while (p1 >= 0 && p2 >= 0) {
      if (nums1[p1] > nums2[p2]) {
        nums1[p] = nums1[p1];
        p1--;
      } else {
        nums1[p] = nums2[p2];
        p2--;
      }
      p--;
    }

    // If nums2 still has remaining elements
    while (p2 >= 0) {
      nums1[p] = nums2[p2];
      p--;
      p2--;
    }
  }

  public static void main(String[] args) {
    // Normal merge with overlaps
    int[] nums1a = {1,2,3,0,0,0};
    int[] nums2a = {2,5,6};
    merge(nums1a, 3, nums2a, 3);
    assert Arrays.equals(nums1a, new int[]{1,2,2,3,5,6}) : "Test Case 1 Failed";

    // nums2 smaller elements
    int[] nums1b = {4,5,6,0,0,0};
    int[] nums2b = {1,2,3};
    merge(nums1b, 3, nums2b, 3);
    assert Arrays.equals(nums1b, new int[]{1,2,3,4,5,6}) : "Test Case 2 Failed";

    // nums2 larger elements
    int[] nums1c = {1,2,3,0,0,0};
    int[] nums2c = {4,5,6};
    merge(nums1c, 3, nums2c, 3);
    assert Arrays.equals(nums1c, new int[]{1,2,3,4,5,6}) : "Test Case 3 Failed";

    // nums1 initially empty
    int[] nums1d = {0,0,0};
    int[] nums2d = {2,5,6};
    merge(nums1d, 0, nums2d, 3);
    assert Arrays.equals(nums1d, new int[]{2,5,6}) : "Test Case 4 Failed";

    // nums2 empty
    int[] nums1e = {1,2,3};
    int[] nums2e = {};
    merge(nums1e, 3, nums2e, 0);
    assert Arrays.equals(nums1e, new int[]{1,2,3}) : "Test Case 5 Failed";

    System.out.println("🎉 All test cases passed!");
  }
}
