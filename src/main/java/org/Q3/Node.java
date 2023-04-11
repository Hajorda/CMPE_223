package org.Q3;

/**
 * Node of a singly linked list of integers
 */
public class Node {
    private int element;
    private Node next;

    /**
     * Creates a node with the given element and next node.
     */
    public Node(int s, Node n) {
        element = s;
        next = n;
    }

    /**
     * Returns the element of this node.
     */
    public int getElement() {
        return element;
    }

    /**
     * Returns the next node of this node.
     */
    public Node getNext() {
        return next;
    }
// Modifier methods:

    /**
     * Sets the element of this node.
     */
    public void setElement(int newElem) {
        element = newElem;
    }

    /**
     * Sets the next node of this node.
     */
    public void setNext(Node newNext) {
        next = newNext;
    }
}