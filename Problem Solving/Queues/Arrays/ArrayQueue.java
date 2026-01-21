class ArrayQueue {
    private int maxSize, front, rear, size;
    private int[] queue;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        this.front = 0;
        this.size = 0;
        this.rear = -1;
    }

    // Enqueue operation
    public void enqueue(int item) {
        if (size == maxSize) {
            throw new RuntimeException("Queue Overflow");
        }
        rear = (rear + 1) % maxSize;
        queue[rear] = item;
        size++;
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }
        int item = queue[front];
        front = (front + 1) % maxSize;
        size--;
        return item;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
    	return size;
    }
}
