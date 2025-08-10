import java.util.*;

public class BruteForce {
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        int n = s.length();

        // Check every possible substring
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end < n; end += 2) { // only even lengths
                if (isValid(s, start, end)) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }
        return maxLen;
    }

    // Helper method to check if substring s[start..end] is a valid parentheses string
    private static boolean isValid(String s, int start, int end) {
        int balance = 0;  // track '(' count

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) return false; // more ')' than '('
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        BruteForce solution = new BruteForce();

        // Test case 1
        String s1 = "(()";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Longest valid parentheses length = " + solution.longestValidParentheses(s1));
        System.out.println();

        // Test case 2
        String s2 = ")()())";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Longest valid parentheses length = " + solution.longestValidParentheses(s2));
        System.out.println();

        // Test case 3
        String s3 = "";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Longest valid parentheses length = " + solution.longestValidParentheses(s3));
        System.out.println();

        // Test case 4
        String s4 = "((((((((";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Longest valid parentheses length = " + solution.longestValidParentheses(s4));
        System.out.println();

        // Test case 5
        String s5 = "()(()))))";
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Longest valid parentheses length = " + solution.longestValidParentheses(s5));
        System.out.println();
    }
}
