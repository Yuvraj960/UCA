// Node class for Linked List
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class LinkedListStack {
    private Node top;
    private int size;

    // Constructor
    public LinkedListStack() {
        this.top = null;
    	this.size = 0;
    }

    // Push operation
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
	    size++;
    }

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

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
	    return size;
    }
}
