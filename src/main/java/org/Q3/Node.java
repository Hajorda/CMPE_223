//-----------------------------------------------------
// Title: Node Class
// Author: Ali Bolat
// ID: 35485311594
// Section: 3
// Assignment: 1
// Description: This class is the node class for LinkedList's Node there are methods for the Modife the nodes and get data from nodes.
//-----------------------------------------------------
package org.Q3;

/**
 * Node of a singly linked list of integers, There are two features element and next. Next is pointing the next Node and element is the storing for data in that situtation int.
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