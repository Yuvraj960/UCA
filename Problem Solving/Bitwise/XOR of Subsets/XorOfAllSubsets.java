/**
 * The XorOfAllSubsets class provides a method to compute the XOR of XORs of all possible subsets of an array.
 * For arrays with more than one element, the result is always 0 due to each bit appearing an even number of times.
 */
public class XorOfAllSubsets {
    /**
     * Computes the XOR of XORs of all possible subsets of the array.
     * If the array has only one element, returns that element.
     * If the array has more than one element, returns 0.
     *
     * @param nums an array of integers
     * @return the XOR of the XOR of all subsets
     */
    public static int xorOfAllSubsets(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return 0;
    }

    /**
     * Main method for testing the XorOfAllSubsets class with sample cases.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Expected 5: " + xorOfAllSubsets(new int[]{5}));
        System.out.println("Expected 0: " + xorOfAllSubsets(new int[]{1, 2}));
        System.out.println("Expected 0: " + xorOfAllSubsets(new int[]{1, 2, 3}));
    }
}


