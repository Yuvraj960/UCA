public class SearchInSortedArray {
  public static int binarySearch(int[] nums, int target) {
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
    return -1;
  }

  public static void main(String[] args) {    
    int[] arr1 = {1, 2, 3, 4, 5};
    assert binarySearch(arr1, 1) == 0 : "Test case 1 failed";
    assert binarySearch(arr1, 3) == 2 : "Test case 2 failed";
    assert binarySearch(arr1, 5) == 4 : "Test case 3 failed";
    assert binarySearch(arr1, 6) == -1 : "Test case 4 failed";
    
    System.out.println("All test cases passed!");
  }
}