public class SearchInsertPosition {
  public static int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    
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
    
    return left;
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 6};
    assert searchInsert(arr, 5) == 2 : "Test case 1 failed";
    assert searchInsert(arr, 2) == 1 : "Test case 2 failed";
    assert searchInsert(arr, 7) == 4 : "Test case 3 failed";
    assert searchInsert(arr, 0) == 0 : "Test case 4 failed";
    
    System.out.println("All test cases passed!");
  }
}
