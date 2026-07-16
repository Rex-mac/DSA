import java.util.LinkedList;
import java.util.Queue;

/**
 * PushFriendlyQueueStack
 *
 * A STACK (LIFO) implemented using a single QUEUE.
 *
 * "Push friendly" means the push operation is kept cheap:
 *   - push() : O(1)  -> simply add to the back of the queue.
 *   - pop()  : O(n)  -> rotate the queue so the most recently
 *                       added element comes to the front, then remove it.
 */
public class PushFriendlyQueueStack {

    private final Queue<Integer> queue = new LinkedList<>();

    /** Add an element to the top of the stack. O(1) */
    public void push(int value) {
        queue.add(value);
    }

    /** Remove and return the top element. O(n) */
    public int pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // Move every element except the last one from front to back.
        int count = queue.size();
        for (int i = 0; i < count - 1; i++) {
            queue.add(queue.remove());
        }
        // The last inserted element is now at the front.
        return queue.remove();
    }

    /** Return (without removing) the top element. O(n) */
    public int peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int top = -1;
        int count = queue.size();
        // One full rotation leaves the queue in its original order.
        for (int i = 0; i < count; i++) {
            top = queue.remove();
            queue.add(top);
        }
        return top;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    // Simple demonstration
    public static void main(String[] args) {
        PushFriendlyQueueStack stack = new PushFriendlyQueueStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.peek()); // 30
        System.out.println("Pop: " + stack.pop());   // 30
        System.out.println("Pop: " + stack.pop());   // 20
        stack.push(40);
        System.out.println("Pop: " + stack.pop());   // 40
        System.out.println("Pop: " + stack.pop());   // 10
        System.out.println("Empty: " + stack.isEmpty()); // true
    }
}
