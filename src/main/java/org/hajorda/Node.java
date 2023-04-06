package org.hajorda;

/**
 * Node of a singly linked list of integers
 */
public class Node {
    private Student element;
    private Node next;


    // Creates a node with the given element and next node.
    public Node(Student s) {
        element = s;
        next = null;
    }


    //Returns the element of this node.
    public Student getElement() {
        return element;
    }


    // Returns the next node of this node.
    public Node getNext() {
        return next;
    }


    // Modifier methods:


    // Sets the element of this node.
    public void setElement(Student newElem) {
        element = newElem;
    }

    //Sets the next node of this node.
    public void setNext(Node newNext) {
        next = newNext;
    }
}
