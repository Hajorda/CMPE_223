package org.UndirectedGraph;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code Bag} class represents a bag (or multiset) of generic items.
 * It supports insertion and iterating over the items in arbitrary order.
 * <p>
 * This implementation uses a singly linked list with a static nested class Node.
 * See {@link LinkedBag} for the version from the
 * textbook that uses a non-static nested class.
 * See {@link ResizingArrayBag} for a version that uses a resizing array.
 * The <em>add</em>, <em>isEmpty</em>, and <em>size</em> operations
 * take constant time. Iteration takes time proportional to the number of items.
 * <p>
 * For additional documentation, see <a href="https://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * @param <Item> the generic type of each item in this bag
 */
public class Bag2<Item extends Comparable<Item>> implements Iterable<Item> {
    private Node<Item> first; // beginning of bag
    private int n; // number of elements in bag

    public void add(Item item) {
        Node<Item> newNode = new Node<>();
        newNode.item = item;

        // Special case: if the bag is empty or the new item has a greater cost than the first item
        if (isEmpty() || Main2.getCost(newNode.item, first.item) > 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<Item> current = first;
            Node<Item> previous = null;

            // Traverse the linked list to find the appropriate position based on cost
            while (current != null && Main2.getCost(newNode.item, current.item) <= 0) {
                previous = current;
                current = current.next;
            }

            // Insert the new node at the appropriate position
            previous.next = newNode;
            newNode.next = current;
        }

        n++;
    }


    // Remove method for the bag
    public void remove(Item item) {
        Node<Item> current = first;
        Node<Item> previous = null;
        while (current != null) {
            if (current.item.equals(item)) {
                if (previous == null) {
                    first = first.next;
                } else {
                    previous.next = current.next;
                }
                n--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty bag.
     */
    public Bag2() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this bag is empty.
     *
     * @return {@code true} if this bag is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this bag in a sorted order (smallest to largest).
     *
     * @param item the item to add to this bag
     */
    /**
     * Adds the item to this bag and sorts it based on cost.
     *
     * @param  item the item to add to this bag
     */



    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Unit tests the {@code Bag} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        bag.add(3);
        bag.add(1);
        bag.add(4);
        bag.add(1);
        bag.add(5);

        System.out.println("Elements in the bag after sorting: ");
        for (int item : bag) {
            System.out.print(item + " ");
        }
    }
}
