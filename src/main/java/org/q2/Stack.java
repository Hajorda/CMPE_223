//-----------------------------------------------------
// Title: Queue Class
// Author: Ali Bolat
// ID: 35485311594
// Section: 3
// Assignment: 1
// Description: This class for the Stack database. It contains the Stacks's methods and Stacks's structure.
//-----------------------------------------------------
package org.q2;

public class Stack {
    private static Node first = null;

    //In node class there are 2 features item and next. Item is the letters of the input for this question. Generally they are storing data. Next is the arrow for the next item it will indicate the next item's position
    private static class Node {
        String item;
        Node next;
    }

    //isEmpety method simply checks the is Stack is empty or not by looking the first varible.
    public static boolean isEmpty() {
        return first == null;
    }

    // Push method using for adding item to Stack. When you add an item it will declare next as a current item and first variable will be item that pushed. Lastly it will take an String and it will put Node's item name as a that String.
    public static void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    //Pop method delete's current first item and return that item. The delation prosses done by equating the first to the next of the first.
    public static String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }


}
