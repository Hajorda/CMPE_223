//-----------------------------------------------------
// Title: LinkedList Class
// Author: Ali Bolat
// ID: 35485311594
// Section: 3
// Assignment: 1
// Description: This class is LinkedList class
//-----------------------------------------------------
package org.Q3;

public class LinkedList {
    protected Node head;
    protected int size = 0;

    public LinkedList() {
        head = null;
    }

    //Getter setter methods's
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
//Push method for the pushing new items to linkedlist. It take's an object from Node class and it equilze it's next as a current head and after that it equilze head is a new node.
    public void push(Node n){
        n.setNext(head);
        head = n;
        size++;
    }
    //Get methods takes an int and find that int's posion in linkedlist and return's it.
    public Node get(int i) {
        if (i >= size) //print error message and return null
            System.out.println("LinkedList'in boyutu o kadar değil kardeş");

        Node ptr = head;

        for (int k = 0; k < i; k++)
            ptr = ptr.getNext();
        return ptr;
    }
}
