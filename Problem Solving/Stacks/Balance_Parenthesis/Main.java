import java.util.Scanner;
import java.util.Stack;

/**
 * Represents a simple Person object.
*/
public class Main {
  /**
   * The Main Class.
  */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine().trim());
    for (int i = 0; i < n; i++) {
      String line = sc.nextLine();
      if (isBalanced(line)) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
    sc.close();
  }

  // Function to check if a string of () and [] is correct
  static boolean isBalanced(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[') {
        stack.push(c);
      } else if (c == ')') {
        if (stack.isEmpty() || stack.pop() != '(') {
          return false;
        }
      } else if (c == ']') {
        if (stack.isEmpty() || stack.pop() != '[') {
          return false;
        }
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }
}
