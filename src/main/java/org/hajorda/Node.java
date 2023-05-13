package org.hajorda;



public class Node {


    private Student element;
    private Node next;
    private Node previous;

    public Node(Student element) {

        this.element = element;
        next=null;
        previous=null;
    }


    //Getters and Setters methods
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