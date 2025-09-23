public class ValidParenthesis {
  /**
   * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
   * determine if the input string is valid.
   *
   * An input string is valid if:
   * 1. Open brackets must be closed by the same type of brackets.
   * 2. Open brackets must be closed in the correct order.
   * 3. Every close bracket has a corresponding open bracket of the same type.
   * 
   * @param s - Input string containing parentheses. 1 <= s.length <= 10^4
   * @returns boolean - True if the string is valid, false otherwise.
   */

  /**
   * Checks if the input string of parentheses is valid using recursion.
   * No loops or collections are used; only recursion and a char array as stack.
   *
   * @param s Input string containing parentheses.
   * @return True if the string is valid, false otherwise.
   */
  public boolean isValidRecursive(String s) {
    char[] stack = new char[s.length()];
    return check(s, 0, stack, 0);
  }

  /**
   * Recursively checks each character and simulates stack operations.
   *
   * @param s The input string.
   * @param index Current index in the string.
   * @param stack Char array simulating a stack.
   * @param top Current stack top index.
   * @return True if valid so far, false otherwise.
   */
  private boolean check(String s, int index, char[] stack, int top) {
    // Base case: end of string
    if (index == s.length()) {
      return top == 0;
    }
    char ch = s.charAt(index);
    // If opening bracket, push to stack
    if (ch == '(' || ch == '{' || ch == '[') {
      stack[top] = ch;
      return check(s, index + 1, stack, top + 1);
    }
    // If closing bracket, check for match
    if (ch == ')' || ch == '}' || ch == ']') {
      if (top == 0) {
        return false;
      }
      char open = stack[top - 1];
      if ((open == '(' && ch == ')') ||
          (open == '{' && ch == '}') ||
          (open == '[' && ch == ']')) {
        return check(s, index + 1, stack, top - 1);
      } else {
        return false;
      }
    }
    // Invalid character
    return false;
  }

  /**
   * Main method for testing the ValidParenthesis class.
   */
  public static void main(String[] args) {
    ValidParenthesis vp = new ValidParenthesis();
    String test1 = "()";
    String test2 = "()[]{}";
    String test3 = "(]";
    String test4 = "([)]";
    String test5 = "{[]}";
    String test6 = "{[()]}";

    assert vp.isValidRecursive(test1) == true : "Test case 1 failed";
    assert vp.isValidRecursive(test2) == true : "Test case 2 failed";
    assert vp.isValidRecursive(test3) == false : "Test case 3 failed";
    assert vp.isValidRecursive(test4) == false : "Test case 4 failed";
    assert vp.isValidRecursive(test5) == true : "Test case 5 failed";
    assert vp.isValidRecursive(test6) == true : "Test case 6 failed";

    System.out.println("All test cases passed!");
  }
}