public class ConvertStringToInteger {
  /**
   * Converts a string to an integer using recursion, without loops or built-in parsing.
   * Handles negative numbers and invalid input as per constraints.
   *
   * @param s Input string representing an integer.
   * @return The integer value represented by the string, or 0 if invalid.
   */
  public int convertStringToInteger(String s) {
    return s.length() == 0 ? 0 : parseRecursive(s, 0, 0, false);
  }

  /**
   * Recursively parses the string to build the integer value.
   * Handles negative sign and digit validation.
   *
   * @param s The input string.
   * @param index Current index in the string.
   * @param result Accumulated integer value.
   * @param isNegative True if the number is negative.
   * @return The parsed integer value, or 0 if invalid.
   */
  private int parseRecursive(String s, int index, int result, boolean isNegative) {
    if (index == s.length()) {
      return isNegative ? -result : result;
    }
    char ch = s.charAt(index);
    if (index == 0 && ch == '-') {
      return s.length() == 1 ? 0 : parseRecursive(s, index + 1, 0, true);
    }
    if (ch < '0' || ch > '9') {
      return 0;
    }
    return parseRecursive(s, index + 1, result * 10 + (ch - '0'), isNegative);
  }

  /**
   * Main method for testing the ConvertStringToInteger class.
   * 
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    ConvertStringToInteger converter = new ConvertStringToInteger();
    String[] testStrings = {"123", "-456", "0", "789a", "", "-0", "2147483647", "-2147483648"};
    int[] expectedResults = {123, -456, 0, 0, 0, 0, 2147483647, -2147483648};

    for (int i = 0; i < testStrings.length; i++) {
      int result = converter.convertStringToInteger(testStrings[i]);
      System.out.println("Input: \"" + testStrings[i] + "\" -> Output: " + result + " (Expected: " + expectedResults[i] + ")");
      assert result == expectedResults[i] : "Test case " + (i + 1) + " failed";
    }
    System.out.println("All test cases passed!");
  }
}