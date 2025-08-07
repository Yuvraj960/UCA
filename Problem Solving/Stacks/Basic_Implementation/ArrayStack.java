public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top;
    private int size;

    // Constructor
    public ArrayStack(int size) {
        this.maxSize = size;
        this.stack = new int[size];
        this.top = -1;
    	this.size = 0;
    }

    // Push operation
    public void push(int data) {
        if (top == maxSize - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        stack[++top] = data;
	    size++;
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
	    size--;
        return stack[top--];
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
	    return size;
    }
}
