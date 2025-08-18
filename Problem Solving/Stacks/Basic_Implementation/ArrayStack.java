/**
 * Represents a simple Person object.
*/
public class ArrayStack {
  private int maxSize;
  private int[] stack;
  private int top;
  private int size;

  /**
   * Public Constructur.
  */
  // Constructor
  public ArrayStack(int size) {
    this.maxSize = size;
    this.stack = new int[size];
    this.top = -1;
    this.size = 0;
  }

  /**
   * Method to Push/Add New Data Node.
  */
  // Push operation
  public void push(int data) {
    if (top == maxSize - 1) {
      throw new RuntimeException("Stack Overflow");
    }
    stack[++top] = data;
    size++;
  }

  /**
   * Mehtod to Pop/Delete the Data Node.
  */
  // Pop operation
  public int pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack Underflow");
    }
    size--;
    return stack[top--];
  }

  /**
   * Method to see the data on the current pointer.
  */
  // Peek operation
  public int peek() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty");
    }
    return stack[top];
  }

  /**
   * Method to see if Stack is Empty or Not.
  */
  // Check if stack is empty
  public boolean isEmpty() {
    return top == -1;
  }

  /**
   * Method to get size of the Stack.
  */
  public int size() {
    return size;
  }
}
