class MyCircularDeque {
    private static class Node {
        int data;
        Node prev = null;
        Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

    private final int maxsize;
    private int size = 0;
    private Node first = null, last = null;

    public MyCircularDeque(int k) {
        this.maxsize = k;
    }

    public boolean insertFront(int value) {
        if (size == maxsize)
            return false;
        Node curr = new Node(value);
        if (first == null) {
            last = curr;
        } else {
            first.prev = curr;
            curr.next = first;
        }
        first = curr;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == maxsize)
            return false;
        Node curr = new Node(value);
        if (last == null) {
            first = curr;
        } else {
            last.next = curr;
            curr.prev = last;
        }
        last = curr;

        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0)
            return false;
        if (size == 1) {
            first = null;
            last = null;
        } else if (size == 2) {
            first = last;
        } else {
            first = first.next;
            first.next.prev = first;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0)
            return false;
        if (size == 1) {
            first = null;
            last = null;
        } else if (size == 2) {
            last = first;
        } else {
            last = last.prev;
            last.prev.next = last;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return first.data;
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return last.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxsize;
    }
}

