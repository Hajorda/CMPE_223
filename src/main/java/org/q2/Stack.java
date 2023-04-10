package org.q2;

public class Stack {
    private static Node first = null;

    private static class Node {
        String item;
        Node next;
    }

    public static boolean isEmpty() {
        return first == null;
    }

    public static void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public static String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }


}
