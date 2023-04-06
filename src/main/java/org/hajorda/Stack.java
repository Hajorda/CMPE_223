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

    public static void printStack() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp);
            System.out.println("Name: " + temp.item.getName() + ", ID: " + temp.item.getID() +
                    ", Average Grade: " + temp.item.getAverage_grade() + ", Rank: " + temp.item.getRank() +
                    ", Grades: " + temp.item.getGrade1() + ", " + temp.item.getGrade2() + ", " + temp.item.getGrade3());
            temp = temp.next;
        }
    }
}
