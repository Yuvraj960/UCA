public class Main {
    public static void main(String[] args) {
        // Linked List Queue
        LinkedListQueue llQueue = new LinkedListQueue();
        llQueue.enqueue(1);
        llQueue.enqueue(2);
    	System.out.println("----Linked List Queue----");
        System.out.println(llQueue.dequeue()); // 1
	    llQueue.dequeue();

        llQueue.enqueue(3);
        llQueue.enqueue(5);
        llQueue.enqueue(7);

	    System.out.println(llQueue.size());

        assert(llQueue.size() == 3);
        assert(llQueue.isEmpty() == false);

        assert(llQueue.dequeue() == 3);
        assert(llQueue.size() == 2);
        assert(llQueue.isEmpty() == false);

        assert(llQueue.dequeue() == 5);
        assert(llQueue.size() == 1);
        assert(llQueue.isEmpty() == false);

        assert(llQueue.dequeue() == 7);
        assert(llQueue.size() == 0);
        assert(llQueue.isEmpty() == true);
	    System.out.println("=== All Asserts Passed ===");
	    System.out.println();
	    System.out.println();

        // Array Queue
        ArrayQueue arrQueue = new ArrayQueue(5);
        arrQueue.enqueue(10);
        arrQueue.enqueue(20);
	    System.out.println("----Array Queue----");
        System.out.println(arrQueue.peek());   // 10
    	arrQueue.dequeue();

	    arrQueue.enqueue(3);
        arrQueue.enqueue(5);
        arrQueue.enqueue(7);

        assert(arrQueue.size() == 3);
        assert(arrQueue.isEmpty() == false);

        assert(arrQueue.dequeue() == 3);
        assert(arrQueue.size() == 2);
        assert(arrQueue.isEmpty() == false);

        assert(arrQueue.dequeue() == 5);
        assert(arrQueue.size() == 1);
        assert(arrQueue.isEmpty() == false);

        assert(arrQueue.dequeue() == 7);
        assert(arrQueue.size() == 0);
        assert(arrQueue.isEmpty() == true);

        System.out.println("=== All Asserts Passed ===");
    }
}
