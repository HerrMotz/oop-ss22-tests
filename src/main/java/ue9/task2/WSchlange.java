package ue9.task2;

public class WSchlange {
    private class Node {
        Object data;
        Node next;

        Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node front = null;
    private Node rear = null;

    WSchlange(Object ... a) {
        for (Object element : a) {
            add(element);
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void add(Object data) {
        if (front == null) {
            front = new Node(data, null);
            rear = front;
        }
        else {
            rear.next = new Node(data, null);
            rear = rear.next;
        }
    }

    public Object poll() {
        if (front == null) {
            throw new IllegalStateException("List is empty.");
        }
        Object data = front.data;
        front = front.next;

        if (front == null) {  //last element was removed.
            rear = null;
        }

        return data;
    }
}
