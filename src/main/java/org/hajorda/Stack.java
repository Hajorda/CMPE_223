package org.hajorda;

public class Stack {
    private static Node first = null;

    private static class Node {
        Student item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void push(Student item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public static Student pop() {
        Student item = first.item;
        first = first.next;
        return item;
    }

    public static void printStack(){
        Node item = first;
        while(item == null){
            System.out.println(item);
            item = item.next;
        }
    }
}
