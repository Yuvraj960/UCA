/**
 * Finds the missing number in an array containing all distinct numbers from 0 to n inclusive with one missing.
 * Key constraints: The array size is n, containing numbers from 0 to n with exactly one missing.
 * Uses XOR to achieve O(n) time and O(1) space.
 */
public class MissingNumberXor {
    /**
     * Finds the missing number using XOR.
     *
     * @param nums an array containing distinct integers from 0 to n with exactly one missing
     * @return the missing integer in the range [0, n]
     */
    public static int findMissingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;
        // XOR all indices and all numbers in nums
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
     /**
     * Main method for testing the MissingNumberXor class with sample cases.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Expected 2: " + findMissingNumber(new int[]{3, 0, 1}));
        System.out.println("Expected 3: " + findMissingNumber(new int[]{0, 1, 2, 4}));
        System.out.println("Expected 7: " + findMissingNumber(new int[]{1, 0, 4, 3, 2, 6, 5}));
    }
}


