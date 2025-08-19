import java.util.PriorityQueue;

/**
 * This class provides a solution for merging k sorted linked
 * lists into one sorted list using a priority queue (min heap).
 *
 * <p>Each node from the k lists is inserted into the heap, and
 * the smallest node is extracted to build the merged list.
 *
 * <p>Constraints:
 * <ul>
 *   <li>Lists may be empty or null.</li>
 *   <li>Handles duplicate values.</li>
 *   <li>Efficient for large k and large lists.</li>
 * </ul>
 */
public class MergeList {
  /**
   * Definition for singly-linked list.
   */
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  /**
   * Merges k sorted linked lists into one sorted list.
   *
   * @param lists array of ListNode heads representing k sorted lists
   * @return head of the merged sorted list
   */
  public ListNode mergekLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode node : lists) {
      if (node != null) {
        minHeap.offer(node);
      }
    }
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (!minHeap.isEmpty()) {
      ListNode node = minHeap.poll();
      curr.next = node;
      curr = curr.next;
      if (node.next != null) {
        minHeap.offer(node.next);
      }
    }
    return dummy.next;
  }

  /**
   * Utility method to create a linked list from an array.
   *
   * @param arr array of integers
   * @return head of the created linked list
   */
  public static ListNode createList(int[] arr) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    for (int num : arr) {
      curr.next = new ListNode(num);
      curr = curr.next;
    }
    return dummy.next;
  }

  /**
   * Utility method to print a linked list.
   *
   * @param head head of the linked list
   */
  public static void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println();
  }

  /**
   * Main method to test mergeKLists with various edge cases.
   *
   * @param args - not used
   */
  public static void main(String[] args) {
    MergeList solver = new MergeList();

    // Test case 1: All lists empty
    ListNode[] lists1 = {null, null, null};
    System.out.print("Test 1 (All empty): ");
    printList(solver.mergekLists(lists1));

    // Test case 2: Some lists empty, some non-empty
    ListNode[] lists2 = {
      createList(new int[]{}),
      createList(new int[]{1, 3, 5}),
      null
    };
    System.out.print("Test 2 (Some empty): ");
    printList(solver.mergekLists(lists2));

    // Test case 3: Lists with duplicate values
    ListNode[] lists3 = {
      createList(new int[]{1, 4, 4}),
      createList(new int[]{2, 4, 6}),
      createList(new int[]{4, 5})
    };
    System.out.print("Test 3 (Duplicates): ");
    printList(solver.mergekLists(lists3));

    // Test case 4: Lists of varying lengths
    ListNode[] lists4 = {
      createList(new int[]{1}),
      createList(new int[]{2, 3, 4, 5}),
      createList(new int[]{6, 7})
    };
    System.out.print("Test 4 (Varying lengths): ");
    printList(solver.mergekLists(lists4));

    // Test case 5: Single list
    ListNode[] lists5 = {createList(new int[]{10, 20, 30})};
    System.out.print("Test 5 (Single list): ");
    printList(solver.mergekLists(lists5));
  }
}
