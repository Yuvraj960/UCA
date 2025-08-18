/**
 * Represents a simple Node object.
*/
// Node class for Linked List
class Node {
  int data;
  Node next;
  Node(int data) {
    this.data = data;
    next = null;
  }
}
/**
 * Represents a LinkedList.
*/
public class LinkedListStack {
  private Node top;
  private int size;
  /**
   * Represents a simple Person object.
  */
  // Constructor
  public LinkedListStack() {
    this.top = null;
    this.size = 0;
  }
  /**
   * Represents a simple Person object.
  */
  // Push operation
  public void push(int data) {
    Node newNode = new Node(data);
    newNode.next = top;
    top = newNode;
	  size++;
  }
  /**
   * Represents a simple Person object.
  */
  // Pop operation
  public int pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack Underflow");
    }
    int value = top.data;
    top = top.next;
	  size--;
    return value;
  }
  /**
   * Represents a simple Person object.
  */
  // Peek operation
  public int peek() {
    if (isEmpty()) {
       throw new RuntimeException("Stack is empty");
    }
    return top.data;
  }

  /**
   * Represents a simple Person object.
  */
  // Check if stack is empty
  public boolean isEmpty() {
    return top == null;
  }

  /**
   * Represents a simple Person object.
  */
  public int size() {
    return size;
  }
}
