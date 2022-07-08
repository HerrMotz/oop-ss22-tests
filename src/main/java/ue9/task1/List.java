package ue9.task1;

public class List {
    Node head = null;
    Node tail = null;

    public void add(Object object) {
        Node p = new Node(object);
        if (head == null ) {
            head = p;
        } else {
            tail.next = p;
        }
        tail = p;
    }

    public void traverseAndApply(ActionObject p){
        for (Node cursor = head; cursor != null; cursor = cursor.next) {
            p.action(cursor);
        }
    }

}