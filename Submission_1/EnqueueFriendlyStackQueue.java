import java.util.Stack;

/**
 * EnqueueFriendlyStackQueue
 *
 * A QUEUE (FIFO) implemented using two STACKS.
 *
 * "Enqueue friendly" means the enqueue operation is kept cheap:
 *   - enqueue() : O(1)  -> simply push onto the "in" stack.
 *   - dequeue() : O(n) worst case / O(1) amortised -> when the "out"
 *                 stack is empty, all elements are poured across from
 *                 the "in" stack (which reverses their order), then the
 *                 top of the "out" stack is the oldest element.
 */
public class EnqueueFriendlyStackQueue {

    private final Stack<Integer> inStack = new Stack<>();
    private final Stack<Integer> outStack = new Stack<>();

    /** Add an element to the back of the queue. O(1) */
    public void enqueue(int value) {
        inStack.push(value);
    }

    /** Remove and return the front (oldest) element. */
    public int dequeue() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (outStack.isEmpty()) {
            // Reverse the order by moving everything across once.
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /** Return (without removing) the front element. */
    public int peek() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public int size() {
        return inStack.size() + outStack.size();
    }

    // Simple demonstration
    public static void main(String[] args) {
        EnqueueFriendlyStackQueue queue = new EnqueueFriendlyStackQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front: " + queue.peek());   // 10
        System.out.println("Dequeue: " + queue.dequeue()); // 10
        System.out.println("Dequeue: " + queue.dequeue()); // 20
        queue.enqueue(40);
        System.out.println("Dequeue: " + queue.dequeue()); // 30
        System.out.println("Dequeue: " + queue.dequeue()); // 40
        System.out.println("Empty: " + queue.isEmpty());   // true
    }
}
