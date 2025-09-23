public class SearchBitonicArray {
  public static int searchBitonic(int[] nums, int target) {
    int peakIndex = findPeak(nums);

    int leftResult = binarySearchAscending(nums, 0, peakIndex, target);
    if (leftResult != -1) {
      return leftResult;
    }
    
    return binarySearchDescending(nums, peakIndex + 1, nums.length - 1, target);
  }

  private static int findPeak(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    
    while (left < right) {
      int mid = left + (right - left) / 2;
      
      if (nums[mid] < nums[mid + 1]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    
    return left;
  }

  private static int binarySearchAscending(int[] nums, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    
    return -1;
  }

  private static int binarySearchDescending(int[] nums, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 8, 12, 4, 2};
    assert searchBitonic(arr, 4) == 4 : "Test case 1 failed";
    assert searchBitonic(arr, 12) == 3 : "Test case 2 failed";
    assert searchBitonic(arr, 5) == -1 : "Test case 3 failed";
    assert searchBitonic(arr, 1) == 0 : "Test case 4 failed";
    
    System.out.println("All test cases passed!");
  }
}
