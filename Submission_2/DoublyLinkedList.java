public class DoublyLinkedList {

    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        int value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return value;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        int value = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String displayForward() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public String displayBackward() {
        StringBuilder sb = new StringBuilder("[");
        Node current = tail;
        while (current != null) {
            sb.append(current.data);
            if (current.prev != null) {
                sb.append(" <-> ");
            }
            current = current.prev;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(20);
        list.addLast(30);
        list.addFirst(10);
        System.out.println("Forward:  " + list.displayForward());
        System.out.println("Backward: " + list.displayBackward());

        System.out.println("removeFirst: " + list.removeFirst());
        System.out.println("removeLast: " + list.removeLast());
        System.out.println("Forward:  " + list.displayForward());
        System.out.println("Size: " + list.size());
    }
}
