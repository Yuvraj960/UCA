import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
 * <p>LRU Cache Cache just implements an advanced version of the Doubly Linked List.
*/
public class LruCache {

  /**
   * Node Class for Linked List.
  */

  class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  Node head;
  Node tail;

  Map<Integer, Node> cacheNodes;
  int size;
  int currSize;

  /**
   * Public Contructor.
   *
   * @param capacity the size of the cache in number.
  */

  public LruCache(int capacity) {
    this.size = capacity;
    this.head = new Node(-1, -1);
    this.tail = new Node(-1, -1);

    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.currSize = 0;
    this.cacheNodes = new HashMap<>();
  }

  /**
   * Getter Function for the Linked List Node.
   *
   * @param key the unique id of the Node.
  */

  public int get(int key) {
    if (!cacheNodes.containsKey(key)) {
      return -1; // Cache Miss
    }

    Node cacheNode = cacheNodes.get(key); // get the Value
    markTheNodeAsLatest(cacheNode); // this node would become most recently used
    return cacheNode.value;
  }

  /**
   * Put function for Updating new node in the linkedlist.
   *
   * @param key the id for the new node.
   * @param value the value for the new node.
  */

  public void put(int key, int value) {
    if (cacheNodes.containsKey(key)) {
      Node cacheNode = cacheNodes.get(key);
      cacheNode.value = value; // updating the exisitng key
      markTheNodeAsLatest(cacheNode); // this node would become most recently used
    } else {
      // this is new key 
      Node newNode = new Node(key, value);

      if (this.currSize < this.size) {
        // Cache has space
        putItInFront(newNode);
        this.currSize++;
      } else {
        putItInFront(newNode);
        deleteTheLeastRecentlyUsedNode();
      }

      cacheNodes.put(key, newNode);
    }

  }

  /**
   * Method to set the node as the latest node and move it in front.
   *
   * @param cacheNode the node which is being visited latest.
  */

  private void markTheNodeAsLatest(Node cacheNode) {
    deleteTheNode(cacheNode);
    putItInFront(cacheNode);
  }

  /**
   * Method to delete the node.
   *
   * @param cacheNode the node which has to be deleted.
  */

  private void deleteTheNode(Node cacheNode) {
    Node prev = cacheNode.prev;
    Node next = cacheNode.next;
    prev.next = next;
    next.prev = prev;
  }

  /**
   * Method to move the node to the front.
   *
   * @param cacheNode the node which has to be moved.
  */

  private void putItInFront(Node cacheNode) {
    Node next = this.head.next;
    cacheNode.next = next;
    cacheNode.prev = this.head;
    this.head.next = cacheNode;
    next.prev = cacheNode;
  }

  /**
   * Method to delete the least recently used node.
  */

  private void deleteTheLeastRecentlyUsedNode() {
    Node tailPrev = this.tail.prev;
    deleteTheNode(tailPrev);
    this.cacheNodes.remove(tailPrev.key); // remove it from the map.
  }

  /**
   * The main method with assert statements for testing the code.
  */

  public static void main(String[] args) {
    // Test Case 1: Basic operations
    LruCache cache1 = new LruCache(2);
    cache1.put(1, 1);
    cache1.put(2, 2);
    assert cache1.get(1) == 1 : "Test 1.1 failed";  // returns 1
    cache1.put(3, 3);                              // evicts key 2
    assert cache1.get(2) == -1 : "Test 1.2 failed"; // returns -1 (not found)
    cache1.put(4, 4);                              // evicts key 1
    assert cache1.get(1) == -1 : "Test 1.3 failed"; // returns -1 (not found)
    assert cache1.get(3) == 3 : "Test 1.4 failed"; // returns 3
    assert cache1.get(4) == 4 : "Test 1.5 failed"; // returns 4

    // Test Case 2: Edge case: single element cache
    LruCache cache2 = new LruCache(1);
    cache2.put(1, 100);
    assert cache2.get(1) == 100 : "Test 2.1 failed";
    cache2.put(2, 200);                           // evicts key 1
    assert cache2.get(1) == -1 : "Test 2.2 failed";
    assert cache2.get(2) == 200 : "Test 2.3 failed";

    // Test Case 3: Repeated puts on same key
    LruCache cache3 = new LruCache(2);
    cache3.put(1, 1);
    cache3.put(1, 10);
    cache3.put(2, 2);
    assert cache3.get(1) == 10 : "Test 3.1 failed"; // Value updated to 10
    cache3.put(3, 3);                               // evicts key 2
    assert cache3.get(2) == -1 : "Test 3.2 failed"; // evicted

    // Test Case 4: Get from empty cache
    LruCache cache4 = new LruCache(2);
    assert cache4.get(5) == -1 : "Test 4 failed";   // returns -1

    // Test Case 5: Negative and zero keys/values
    LruCache cache5 = new LruCache(2);
    cache5.put(-1, 0);
    cache5.put(0, -5);
    assert cache5.get(-1) == 0 : "Test 5.1 failed";
    assert cache5.get(0) == -5 : "Test 5.2 failed";
    cache5.put(1, 1);                              // evicts key -1
    assert cache5.get(-1) == -1 : "Test 5.3 failed";

    System.out.println("All test cases passed!");
  }

}
