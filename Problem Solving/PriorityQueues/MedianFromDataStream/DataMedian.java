import java.util.Collections;
import java.util.PriorityQueue;

/**
 * This class finds the median from a stream of integers using two priority queues (heaps).
 *
 * <p>Maintains a max heap for the lower half and a min heap for the upper half of the numbers.
 * By balancing these heaps, the median can be retrieved in O(1) time after each insertion.
 *
 * <p>Constraints:
 * <ul>
 *   <li>Numbers can be negative or positive.</li>
 *   <li>Duplicates are allowed.</li>
 *   <li>Does not require sorting the entire stream.</li>
 * </ul>
 */
public class DataMedian {
  /**
   * Max heap for the lower half of the numbers.
   */
  private PriorityQueue<Integer> maxHeap;
  /**
   * Min heap for the upper half of the numbers.
   */
  private PriorityQueue<Integer> minHeap;

  /**
   * Constructs a new DataMedian object with empty heaps.
   */
  public DataMedian() {
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    minHeap = new PriorityQueue<>();
  }

  /**
   * Adds a number to the data stream and balances the heaps.
   *
   * @param num the integer to add to the stream
   */
  public void addNum(int num) {
    if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
      maxHeap.offer(num);
    } else {
      minHeap.offer(num);
    }

    // Balance the heaps so that their sizes differ by at most 1
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.offer(maxHeap.poll());
    } else if (minHeap.size() > maxHeap.size()) {
      maxHeap.offer(minHeap.poll());
    }
  }

  /**
   * Finds the median of all numbers added so far.
   *
   * @return the median value as a double
   */
  public double findMedian() {
    if (maxHeap.size() == minHeap.size()) {
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    } else {
      return maxHeap.peek();
    }
  }

  /**
   * Main method to test the DataMedian functionality with various test cases.
   *
   * @param args - not used
   */
  public static void main(String[] args) {
    // Test case 1: Odd number of elements
    DataMedian dm1 = new DataMedian();
    dm1.addNum(1);
    dm1.addNum(2);
    dm1.addNum(3);
    System.out.println("Test 1 Median (should be 2.0): " + dm1.findMedian());

    // Test case 2: Even number of elements
    DataMedian dm2 = new DataMedian();
    dm2.addNum(1);
    dm2.addNum(2);
    dm2.addNum(3);
    dm2.addNum(4);
    System.out.println("Test 2 Median (should be 2.5): " + dm2.findMedian());

    // Test case 3: Negative numbers
    DataMedian dm3 = new DataMedian();
    dm3.addNum(-5);
    dm3.addNum(-1);
    dm3.addNum(-3);
    System.out.println("Test 3 Median (should be -3.0): " + dm3.findMedian());

    // Test case 4: Duplicates
    DataMedian dm4 = new DataMedian();
    dm4.addNum(2);
    dm4.addNum(2);
    dm4.addNum(2);
    dm4.addNum(2);
    System.out.println("Test 4 Median (should be 2.0): " + dm4.findMedian());

    // Test case 5: Mixed numbers
    DataMedian dm5 = new DataMedian();
    int[] nums = {5, 15, 1, 3};
    for (int n : nums) {
      dm5.addNum(n);
    }
    System.out.println("Test 5 Median (should be 4.0): " + dm5.findMedian());
  }
}
