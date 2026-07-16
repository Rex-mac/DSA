public class ArrayCircularQueue {

    private final int[] arr;
    private final int capacity;
    private int front;
    private int rear;
    private int count;

    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int value = arr[front];
        front = (front + 1) % capacity;
        count--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        ArrayCircularQueue queue = new ArrayCircularQueue(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Full: " + queue.isFull());

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());

        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Front: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Empty: " + queue.isEmpty());
    }
}
