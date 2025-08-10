import java.util.ArrayList;
import java.util.Arrays;

public class BruteForce {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        // For each bar i, try to expand left and right as far as bars are >= heights[i]
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int left = i;
            int right = i;

            // Expand to left while bars are >= height
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                left--;
            }

            // Expand to right while bars are >= height
            while (right + 1 < n && heights[right + 1] >= height) {
                right++;
            }

            // Calculate the area with bar i height
            int width = right - left + 1;
            int area = height * width;

            // Update maxArea if needed
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        BruteForce solution = new BruteForce();

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
