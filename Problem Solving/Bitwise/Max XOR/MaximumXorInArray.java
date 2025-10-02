import java.util.HashSet;

/**
 * The MaximumXorInArray class provides a method to find the maximum XOR of any two elements in the array.
 * Uses a greedy approach with bit manipulation for O(32*n) time complexity.
 */
public class MaximumXorInArray {
    /**
     * Finds the maximum XOR of any two elements in the array.
     * Uses a prefix set to greedily build the maximum XOR bit by bit.
     *
     * @param nums an array of non-negative integers
     * @return the maximum XOR value of any two distinct elements in the array
     */
    public static int findMaximumXor(int[] nums) {
        int max = 0;
        int mask = 0;
        // Iterate over each bit position from high to low
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            int candidate = max | (1 << i);
            boolean found = false;
            for (int prefix : prefixes) {
                if (prefixes.contains(prefix ^ candidate)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                max = candidate;
            }
        }
        return max;
    }
    /**
     * Main method for testing the MaximumXorInArray class with sample cases.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Expected 126: " + findMaximumXor(new int[]{26, 100, 25, 13, 4, 14}));
        System.out.println("Expected 7: " + findMaximumXor(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println("Expected 0: " + findMaximumXor(new int[]{0, 0, 0}));
    }
}


