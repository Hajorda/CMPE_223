package org.Q3;

public class LinkedList {
    protected Node head;
    protected int size = 0;

    public LinkedList() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void push(Node n){
        n.setNext(head);
        head = n;
        size++;
    }
    public Node get(int i) {
        if (i >= size) //print error message and return null
            System.out.println("LinkedList'in boyutu o kadar değil kardeş");

        Node ptr = head;

        for (int k = 0; k < i; k++)
            ptr = ptr.getNext();
        return ptr;
    }
}
