/**
 * UnboundedArrayStack
 *
 * A STACK (LIFO) backed by a plain array that resizes itself so the
 * stack never runs out of room and never wastes much space.
 *
 *   - push() : if the array is full, capacity is DOUBLED before adding.
 *   - pop()  : when the array becomes only a quarter full, capacity is
 *              HALVED to release unused memory.
 *
 * The 1/4 shrink threshold (instead of 1/2) prevents "thrashing", where
 * repeated push/pop at the boundary would resize on every operation.
 * Both operations therefore run in O(1) amortised time.
 */
public class UnboundedArrayStack {

    private int[] arr;
    private int size;

    public UnboundedArrayStack() {
        arr = new int[2];   // small starting capacity
        size = 0;
    }

    /** Add an element to the top of the stack. */
    public void push(int value) {
        if (size == arr.length) {
            resize(arr.length * 2);   // grow
        }
        arr[size++] = value;
    }

    /** Remove and return the top element. */
    public int pop() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty");
        }
        int value = arr[--size];
        arr[size] = 0; // clear the slot (optional tidy-up)

        // Shrink when the array is only a quarter full (keep a minimum).
        if (size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
        return value;
    }

    /** Return (without removing) the top element. */
    public int peek() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[size - 1];
    }

    /** Copy the current elements into a new array of the given capacity. */
    private void resize(int newCapacity) {
        int[] newArr = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /** Current capacity of the backing array (useful to see resizing). */
    public int capacity() {
        return arr.length;
    }

    // Simple demonstration of growing and shrinking
    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();

        System.out.println("Pushing 1..6 (watch the capacity grow)");
        for (int i = 1; i <= 6; i++) {
            stack.push(i);
            System.out.println("  push " + i + " | size=" + stack.size()
                    + " capacity=" + stack.capacity());
        }

        System.out.println("Popping everything (watch the capacity shrink)");
        while (!stack.isEmpty()) {
            int v = stack.pop();
            System.out.println("  pop " + v + " | size=" + stack.size()
                    + " capacity=" + stack.capacity());
        }
    }
}
