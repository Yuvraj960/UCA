public class Main {
    public static void main(String[] args) {
        // Linked List Stack
        LinkedListStack llStack = new LinkedListStack();
        llStack.push(10);
        llStack.push(20);
    	System.out.println("-----Linked List Stack-----");
        System.out.println(llStack.pop());  // 20
	    System.out.println(llStack.pop());  // 10

	    llStack.push(3);
    	llStack.push(5);
	    llStack.push(7);

    	assert(llStack.size() == 3);
	    assert(llStack.isEmpty() == false);

	    assert(llStack.pop() == 7);
    	assert(llStack.size() == 2);
	    assert(llStack.isEmpty() == false);

    	assert(llStack.pop() == 5);
	    assert(llStack.size() == 1);
    	assert(llStack.isEmpty() == false);

	    assert(llStack.pop() == 3);
    	assert(llStack.size() == 0);
	    assert(llStack.isEmpty() == true);

    	System.out.println("=== All Asserts Passed ===");
	    System.out.println();
    	System.out.println();

        // Array Stack
        ArrayStack arrStack = new ArrayStack(5);
        arrStack.push(30);
        arrStack.push(40);
	    System.out.println("----Array Stack-----");
        System.out.println(arrStack.peek()); // 40
	    arrStack.pop();  // 40
	    System.out.println(arrStack.pop());  // 30

    	arrStack.push(3);
    	arrStack.push(9);
	    arrStack.push(100);
	    arrStack.push(8000);

	    assert(arrStack.size() == 4);
	    assert(arrStack.isEmpty() == false);

	    assert(arrStack.pop() == 8000);
	    assert(arrStack.size() == 3);
	    assert(arrStack.isEmpty() == false);

    	assert(arrStack.pop() == 100);
	    assert(arrStack.size() == 2);
	    assert(arrStack.isEmpty() == false);

    	arrStack.pop();

	    assert(arrStack.pop() == 3);
	    assert(arrStack.size() == 0);
    	assert(arrStack.isEmpty() == true);

	    System.out.println("=== All Asserts Passed ===");
    }
}
