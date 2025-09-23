public class SearchInRotatedSortedArray {
  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    
    while (left <= right) {
      int mid = left + (right - left) / 2;
      
      if (nums[mid] == target) {
        return mid;
      }
      
      if (nums[left] <= nums[mid]) {
        if (target >= nums[left] && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (target > nums[mid] && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
    assert search(arr1, 0) == 4 : "Test case 1 failed";
    assert search(arr1, 3) == -1 : "Test case 2 failed";
    int[] arr2 = {3, 1};
    assert search(arr2, 3) == 0 : "Test case 3 failed";
    
    System.out.println("All test cases passed!");
  }
}
