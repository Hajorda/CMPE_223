package org.Q1;

//-----------------------------------------------------
// Title: Node Class
// Author: Ali Bolat
// ID: 35485311594
// Section: 3
// Assignment: 1
// Description: This class Node for LinkedList class
//-----------------------------------------------------

public class Node {

//We decleared the varibles.
    private Student element;
    private Node next;
    private Node previous;

    //Constructor for creating object from Node class.
    public Node(Student element) {
        this.element = element;
        next=null;
        previous=null;
    }


    // Getters and Setters methods
    public Student getElement() {
        return element;
    }

    public void setElement(Student element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }





}