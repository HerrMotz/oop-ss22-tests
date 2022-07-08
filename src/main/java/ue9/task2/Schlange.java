package ue9.task2;

public class Schlange<T> {
    private class Node {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node front = null;
    private Node rear = null;

    Schlange(T ... a) {
        for(T element : a) {
            enqueue(element);
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(T data) {
        if (front == null) {
            front = new Node(data, null);
            rear = front;
        }
        else {
            rear.next = new Node(data, null);
            rear = rear.next;
        }
    }

    public T dequeue() {
        if (front == null) {
            throw new IllegalStateException("List is empty.");
        }

        T data = front.data;
        front = front.next;

        if (front == null) {  //last element was removed.
            rear = null;
        }

        return data;
    }
}
