package ue4.dynintarray;

/**
 * Implementation eines dynamischen Arrays in einer einfach verketteten Liste.
 * Erstellt neue Knoten wenn die Liste größer wird.
 * Löschen ist nicht implementiert, weil es nicht gefordert war.
 *
 * @author Daniel Motz
 * @version 1.0
 */

class DIAlist extends DynIntArray {

    static class Node {
        private int data;
        private Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
        int getData() { return this.data; }
        void setData(int data) { this.data = data; }

        Node getNext() { return this.next; }
        void setNext(Node next) { this.next = next; }
    }

    Node head;

    void add(int e) {
        Node node = new Node(e);
        if (head == null) {
            head = node;
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
    }


    void setElementAt(int i, int e) {
        Node current = head;
        int r = 0;
        while (current != null) {
            if (i == r) {
                current.setData(e);
                return;
            }
            r++;
            current = current.getNext();
        }
    }

    int getElementAt(int i) {
        Node current = head;
        int r = 0;
        while (current != null) {
            if (i == r)
                return current.getData();
            r++;
            current = current.getNext();
        }
        return 0;
    }

    int getElementCount() {
        int i = 0;
        Node current = head;
        while (current != null) {
            i++;
            current = current.getNext();
        }
        return i;
    }

    void print() {
        Node current = head;

        System.out.print("[");

        while (current != null) {
            System.out.print(current.getData());
            if (current.getNext() != null) System.out.print(", ");
            current = current.getNext();
        }

        System.out.println("]");
    }
}
