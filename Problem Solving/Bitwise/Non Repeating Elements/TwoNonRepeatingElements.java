import java.util.Arrays;

/**
 * The TwoNonRepeatingElements class provides a method to find two unique elements in an array
 * where every other element appears exactly twice. Uses bitwise XOR for O(n) time and O(1) space.
 */
public class TwoNonRepeatingElements {

    /**
     * Finds the two unique elements in the array where every other element appears exactly twice.
     * Uses bitwise XOR to efficiently separate the two unique numbers.
     *
     * @param nums an array of integers with exactly two unique elements and all others appearing twice
     * @return an integer array of length 2 containing the two non-repeating elements
     */
    public static int[] findTwoUnique(int[] nums) {
        // Step 1: XOR all elements. The result is xor = a ^ b (where a and b are unique)
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find any set bit (rightmost set bit) in xor (differs between a and b)
        int diffBit = xor & -xor;

        // Step 3: Divide numbers into two groups and XOR separately
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    /**
     * Main method for testing the TwoNonRepeatingElements class with sample cases.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int[] result1 = findTwoUnique(new int[]{1, 2, 3, 2, 1, 4});
        System.out.println("Expected [3, 4]: " + Arrays.toString(result1));
        int[] result2 = findTwoUnique(new int[]{2, 2, 3, 5});
        System.out.println("Expected [3, 5]: " + Arrays.toString(result2));
        int[] result3 = findTwoUnique(new int[]{0, 0, -1, -1, 9, 7});
        System.out.println("Expected [7, 9]: " + Arrays.toString(result3));
    }
}
