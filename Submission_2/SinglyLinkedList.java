public class SinglyLinkedList {

    private static class Node {
        int data;
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
            head = node;
        }
        size++;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
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
        }
        size--;
        return value;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (head == tail) {
            int single = head.data;
            head = tail = null;
            size--;
            return single;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        int value = tail.data;
        current.next = null;
        tail = current;
        size--;
        return value;
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String display() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(20);
        list.addLast(30);
        list.addFirst(10);
        System.out.println(list.display());

        System.out.println("Contains 20: " + list.contains(20));
        System.out.println("removeFirst: " + list.removeFirst());
        System.out.println("removeLast: " + list.removeLast());
        System.out.println(list.display());
        System.out.println("Size: " + list.size());
    }
}
