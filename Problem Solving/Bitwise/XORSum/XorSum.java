import java.util.Arrays;

/**
 * The XORSum Class for taking the XOR of elements in the array.
*/
public class XorSum {
  /**
   * Function to calculate the sum of XOR.
   * of all subarrays.
  */
  public static int findXorSum(int[] arr, int n) {
    // variable to store
    // the final sum
    int sum = 0;
    for (int i = 0; i < n; i++) {
      int xorr = 0;
      for (int j = i; j < n; j++) {
        xorr = xorr ^ arr[j];
        sum += xorr;
      }
    }
    return sum;
  }

  /**
   * Main Driver Code.
   *
   * @param args for the CLI arguments.
  */
  public static void main(String[] args) {
    int[] arr = { 3, 8, 13 };
    int n = arr.length;

    System.out.println(findXorSum(arr, n));
  }
}
