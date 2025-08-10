import java.util.*;

public class Optimised {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n]; // dp[i] stores the length of the longest valid substring ending at i
        int maxLen = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                // Case 1: Previous char is '(' -> found a pair "()"
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                // Case 2: Previous char is ')' and matching '(' exists before the valid substring ending at i-1
                else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 
                            + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Optimised solution = new Optimised();

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

