import java.util.Stack;

public class DequeueFriendlyStackQueue {

    private final Stack<Integer> mainStack = new Stack<>();
    private final Stack<Integer> helperStack = new Stack<>();

    public void enqueue(int value) {

        while (!mainStack.isEmpty()) {
            helperStack.push(mainStack.pop());
        }

        mainStack.push(value);

        while (!helperStack.isEmpty()) {
            mainStack.push(helperStack.pop());
        }
    }

    public int dequeue() {
        if (mainStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return mainStack.pop();
    }

    public int peek() {
        if (mainStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return mainStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public int size() {
        return mainStack.size();
    }

    public static void main(String[] args) {
        DequeueFriendlyStackQueue queue = new DequeueFriendlyStackQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        queue.enqueue(40);
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Empty: " + queue.isEmpty());
    }
}
