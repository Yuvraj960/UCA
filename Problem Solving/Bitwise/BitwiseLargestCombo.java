/**
 * This is the Leetcode 2275 question.
 * It is the Largest Combination with Bitwise AND Greater Than Zero.
*/

class BitwiseLargestCombo {
  /**
   * largestCombination The main logic.
   *
   * @param candidates the number array
  */
  public int largestCombination(int[] candidates) {
    int[] bitCount = new int[32];
    int max = 0;
    for (int candidate : candidates) {
      int i = 0;
      while (candidate != 0) {
        bitCount[i] += ((candidate) & 1);
        max = Math.max(max, bitCount[i]);
        i++;
        candidate >>= 1;
      }
    }
    return max;
  }

  /**
   * The Main function.
  */
  public static void main(String[] args) {
    BitwiseLargestCombo solution = new BitwiseLargestCombo();
    // Sample test case
    int[] candidates = {16, 17, 71, 62, 12, 24, 14};  // You can change this to any test case
    int result = solution.largestCombination(candidates);
    System.out.println("Largest Combination with Bitwise AND > 0: " + result);
  }
}
