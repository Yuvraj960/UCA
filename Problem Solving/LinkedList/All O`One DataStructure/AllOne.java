import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Node class for the linkedlist solution.
*/

class Node {
  int freq;
  Node next;
  Node prev;
  Set<String> pdts;

  Node(int freq) {
    this.freq = freq;
    this.pdts = new HashSet<>();
  }
}

/**
 * Main AllOne Class for the logic.
*/

public class AllOne {
  Node head;
  Node tail;
  Map<String, Node> pdtsMap;

  /**
   * Public Constructor.
  */
  public AllOne() {
    head = new Node(-1);
    tail = new Node(-1);
    head.next = tail;
    tail.prev = head;
    pdtsMap = new HashMap<>();
  }

  /**
   * The Increment Function.
  */
  public void inc(String key) {
    if (pdtsMap.containsKey(key)) {
      Node currNode = pdtsMap.get(key);

      if ((currNode.freq + 1) == (currNode.next.freq)) {
        Node nextNode = currNode.next;
        nextNode.pdts.add(key);
        pdtsMap.put(key, nextNode);
      } else {
        Node newNode = new Node(currNode.freq + 1);
        newNode.pdts.add(key);
        insertAfter(currNode, newNode);
        pdtsMap.put(key, newNode);
      }

      currNode.pdts.remove(key);
      if (currNode.pdts.isEmpty()) {
        removeNode(currNode);
      }
    } else {
      if (head.next.freq == 1) {
        Node nextNode = head.next;
        nextNode.pdts.add(key);
        pdtsMap.put(key, nextNode);
      } else {
        Node newNode = new Node(1); // node with 1 freq if it was not present
        newNode.pdts.add(key);
        insertAfter(head, newNode);
        pdtsMap.put(key, newNode);
      }
    }
  }

  /**
   * The Decrement Function.
   *
   * @param key for the linkedlist indexing.
  */
  public void dec(String key) {
    if (!pdtsMap.containsKey(key)) {
      return;
    }
    Node currNode = pdtsMap.get(key);

    if (currNode.freq == 1) { // Condition when the freq is exhausted
      currNode.pdts.remove(key);
      pdtsMap.remove(key);
    } else if ((currNode.freq - 1) == (currNode.prev.freq)) {
      // Condition when the prev freq i prsnt int the dll
      Node prevNode = currNode.prev;
      prevNode.pdts.add(key);
      pdtsMap.put(key, prevNode);
    } else {
      // Condition when the prev node is not present
      Node newNode = new Node(currNode.freq - 1);
      newNode.pdts.add(key);
      insertAfter(currNode.prev, newNode);
      pdtsMap.put(key, newNode);
    }

    currNode.pdts.remove(key);

    if (currNode.pdts.isEmpty()) {
      removeNode(currNode);
    }
  }

  /**
   * Getter function for the maximum key fetch.
  */
  public String getMaxKey() {
    // If there is no maxKey or basically no nodes
    if (tail.prev == head) {
      return "";
    }
    return tail.prev.pdts.iterator().next();
  }

  /**
   * Getter function for the minimum key Fetch.
  */
  public String getMinKey() {
    // Again checking if there are no nodes
    if (head.next == tail) {
      return "";
    }
    return head.next.pdts.iterator().next();
  }

  /**
   * Method to add a new node after a particular node.
   */
  private void insertAfter(Node curr, Node nextNode) {
    nextNode.next = curr.next;
    nextNode.prev = curr;
    curr.next.prev = nextNode;
    curr.next = nextNode;
  }

  /**
   * Method to delete a node if the set becomes empty.
   */
  private void removeNode(Node curr) {
    Node next = curr.next;
    Node prev = curr.prev;
    prev.next = next;
    next.prev = prev;
  }

  /**
   * The Main Function.
  */
  public static void main(String[] args) {
    AllOne allOne = new AllOne();
    // Test case 1: Simple increments and getMaxKey/getMinKey
    allOne.inc("apple");
    allOne.inc("apple");
    allOne.inc("banana");
    System.out.println("Test case 1:");
    System.out.println("Max key: " + allOne.getMaxKey()); // Expect "apple" (freq 2)
    System.out.println("Min key: " + allOne.getMinKey()); // Expect "banana" (freq 1)
    System.out.println();

    // Test case 2: Decrement and check keys again
    allOne.dec("apple");
    System.out.println("Test case 2:");
    System.out.println("Max key: " + allOne.getMaxKey()); // Could be "apple"/"banana" (both freq 1)
    System.out.println("Min key: " + allOne.getMinKey()); // Could be "apple"/"banana" (both freq 1)
    System.out.println();

    // Test case 3: Decrement to remove key and add new keys
    allOne.dec("apple"); // apple freq becomes 0, removed
    allOne.inc("orange");
    allOne.inc("orange");
    allOne.inc("orange");
    System.out.println("Test case 3:");
    System.out.println("Max key: " + allOne.getMaxKey()); // Expect "orange" (freq 3)
    System.out.println("Min key: " + allOne.getMinKey()); // Expect "banana" (freq 1)
    System.out.println();

    // Extra: Edge case - decrement a non-existent key
    allOne.dec("grape"); // no effect
    System.out.println("After decrementing non-existent 'grape':");
    System.out.println("Max key: " + allOne.getMaxKey()); // "orange"
    System.out.println("Min key: " + allOne.getMinKey()); // "banana"
  }
}
