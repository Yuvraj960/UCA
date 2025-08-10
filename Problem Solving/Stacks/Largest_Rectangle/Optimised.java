import java.util.Stack;
import java.util.Arrays;

public class Optimised {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Current height is zero when i == n to flush all remaining bars
            int currentHeight = (i == n) ? 0 : heights[i];

            // Pop bars taller than current bar and calculate areas
            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int height = heights[stack.pop()];  // Height of the popped bar
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek(); // Previous smaller bar's index
                int width = i - leftBoundary - 1; // Width of rectangle with popped height
                int area = height * width;
                if (area > maxArea) maxArea = area;
            }
            stack.push(i);  // Push current bar index
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Optimised solution = new Optimised();

        // Test case 1
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("Test case 1: " + Arrays.toString(heights1));
        System.out.println("Largest rectangle area = " + solution.largestRectangleArea(heights1));

        // Test case 2
        int[] heights2 = {2, 4};
        System.out.println("\nTest case 2: " + Arrays.toString(heights2));
        System.out.println("Largest rectangle area = " + solution.largestRectangleArea(heights2));

        // Test case 3
        int[] heights3 = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("\nTest case 3: " + Arrays.toString(heights3));
        System.out.println("Largest rectangle area = " + solution.largestRectangleArea(heights3));

        // Test case 4 - single bar
        int[] heights4 = {4};
        System.out.println("\nTest case 4: " + Arrays.toString(heights4));
        System.out.println("Largest rectangle area = " + solution.largestRectangleArea(heights4));

        // Test case 5 - all bars equal height
        int[] heights5 = {3, 3, 3, 3};
        System.out.println("\nTest case 5: " + Arrays.toString(heights5));
        System.out.println("Largest rectangle area = " + solution.largestRectangleArea(heights5));
    }
}
