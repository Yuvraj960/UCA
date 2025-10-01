/**
 * The TotalHammingDistance class provides a method to calculate the total Hamming distance
 * between all pairs of integers in the array.
 * The Hamming distance between two integers is the number of bit positions in which they differ.
 */
public class TotalHammingDistance {
    /**
     * Calculates the total Hamming distance between all pairs of integers in the array.
     * Uses bitwise counting for O(32*n) time complexity.
     *
     * @param nums an array of non-negative integers
     * @return the total Hamming distance between all unique pairs in the array
     */
    public static int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;
        // For each bit position (0 to 31)
        for (int i = 0; i < 32; i++) {
            int countOnes = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    countOnes++;
                }
            }
            int countZeros = n - countOnes;
            total += countOnes * countZeros;
        }
        return total;
    }

    /**
     * Main method for testing the TotalHammingDistance class with sample cases.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Expected 8: " + totalHammingDistance(new int[]{4, 14, 4, 14}));
        System.out.println("Expected 4: " + totalHammingDistance(new int[]{1, 2, 3}));
        System.out.println("Expected 0: " + totalHammingDistance(new int[]{0, 0, 0}));
    }
}


