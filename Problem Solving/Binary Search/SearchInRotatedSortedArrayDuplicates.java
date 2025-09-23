public class SearchInRotatedSortedArrayDuplicates {
  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    
    while (left <= right) {
      int mid = left + (right - left) / 2;
      
      if (nums[mid] == target) {
        return mid;
      }
      
      if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
        left++;
        right--;
      }
      else if (nums[left] <= nums[mid]) {
        if (target >= nums[left] && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      else {
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
    int[] arr1 = {2, 5, 6, 0, 0, 1, 2};
    int result1 = search(arr1, 0);
    assert (result1 == 3 || result1 == 4) : "Test case 1 failed";
    
    int[] arr2 = {2, 2, 2, 3, 4, 2};
    assert search(arr2, 3) == 3 : "Test case 2 failed";
    assert search(arr2, 5) == -1 : "Test case 3 failed";
    
    System.out.println("All test cases passed!");
  }
}
