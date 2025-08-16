import java.util.*;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // Push to minStack if it's empty or new value <= min
        if (minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }
    
    public void pop() {
        if (stack.isEmpty())
            return;
        int popped = stack.pop();
        if (!minStack.isEmpty() && popped == minStack.peek())
            minStack.pop();
    }
    
    public int top() {
        if (stack.isEmpty())
            return -1;
        return stack.peek();
    }
    
    public int getMin() {
        if (minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        // Test case 1: Basic push and getMin
        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        System.out.println("Current Min (should be 3): " + minStack.getMin());

        // Test case 2: Pop and getMin
        minStack.pop(); // Pops 7
        System.out.println("Current Min after pop (should be 3): " + minStack.getMin());
        minStack.pop(); // Pops 3
        System.out.println("Current Min after popping min (should be 5): " + minStack.getMin());

        // Test case 3: Top and getMin on single element
        System.out.println("Top element (should be 5): " + minStack.top());
        minStack.pop(); // Pops 5
        System.out.println("Stack empty, getMin (should be -1): " + minStack.getMin());
    }
}
