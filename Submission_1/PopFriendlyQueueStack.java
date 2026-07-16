import java.util.LinkedList;
import java.util.Queue;

/**
 * PopFriendlyQueueStack
 *
 * A STACK (LIFO) implemented using two QUEUES.
 *
 * "Pop friendly" means the pop operation is kept cheap:
 *   - pop()  : O(1)  -> the queue is always kept in stack order,
 *                       with the top element at the front.
 *   - push() : O(n)  -> the new element is placed at the front by
 *                       moving all existing elements behind it.
 */
public class PopFriendlyQueueStack {

    // q1 always holds the elements with the stack's TOP at the front.
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    /** Add an element to the top of the stack. O(n) */
    public void push(int value) {
        q2.add(value);                 // new element goes in first
        while (!q1.isEmpty()) {
            q2.add(q1.remove());       // older elements line up behind it
        }
        // Swap the queues so q1 again holds the ordered stack.
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /** Remove and return the top element. O(1) */
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.remove();
    }

    /** Return (without removing) the top element. O(1) */
    public int peek() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }

    // Simple demonstration
    public static void main(String[] args) {
        PopFriendlyQueueStack stack = new PopFriendlyQueueStack();
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
