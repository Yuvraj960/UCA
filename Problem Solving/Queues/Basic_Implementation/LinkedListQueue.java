// Node class for Linked List Queue
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListQueue {
    private Node front, rear;
    private int size;
    public LinkedListQueue() {
        this.front = this.rear = null;
    	this.size = 0;
    }

    // Enqueue operation
    public void enqueue(int item) {
        Node temp = new Node(item);
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
	    size++;
    }

    // Dequeue operation
    public int dequeue() {
        if (this.front == null) {
            throw new RuntimeException("Queue Underflow");
        }
        int value = this.front.data;
        this.front = this.front.next;
        if (this.front == null) this.rear = null;
            size--;
    	return value;
    }

    // Peek operation
    public int peek() {
        if (this.front == null) throw new RuntimeException("Queue is Empty");
        return this.front.data;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public int size() {
	    return size;
    }
}
