package org.hajorda;

/**
 * Singly linked list .
 */
public class SLinkedList {
    protected static Node head; // head node of the list
    protected static int size = 0; // number of nodes in the list

    public static Node getHead() {
        return head;
    }

    public static int getSize() {
        return size;
    }

    /**
     * Default constructor that creates an empty list
     */
    public SLinkedList() {
        head = null;

    }

    public static void ranks() {
        int rank = 1;
        Node current = head;
        while (current != null) {
            current.getElement().setRank(rank);
            rank++;
            current = current.getNext();
        }

    }

    public static void push(Student student) {
        Node newNode = new Node(student);
        newNode.setNext(head);
        head = newNode;
        size++;
        ranks();
    }

    public static void push(Node n) {
        n.setNext(head);
        head = n;
        size++;
        ranks();
    }

    public static void printList() {
        Node current = head;
        while (current != null) {
            Student student = current.getElement();
            System.out.println("Name: " + student.getName() + ", ID: " + student.getID() +
                    ", Average Grade: " + student.getAverage_grade() + ", Rank: " + student.getRank()
                    + ", Grades: " + student.getGrade1() + ", " + student.getGrade2() + ", " + student.getGrade3());
            current = current.getNext();
        }
    }


    public static void insertAfter(Node v, Node n) {
        n.setNext(v.getNext());
        v.setNext(n);
        size++;
    }

    public static void insertAfter(Node v, Student a) {
        Node n = new Node(a);
        n.setNext(v.getNext());
        v.setNext(n);
        size++;
    }

    //return the i-th node
    public static Node get(int i) {
        if (i >= size) //print error message and return null
            System.out.println("LinkedListt'in boyutu o kadar değil kardeş");

        Node ptr = head;

        for (int k = 0; k < i; k++)
            ptr = ptr.getNext();
        return ptr;
    }

    public static void remove(Node a) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (a == temp) {
                a.setNext(get(i + 1));
                System.out.println(a.getElement().getName() + "Silindi!");
                break;
            }

            temp = temp.getNext();
        }
    }
    public static Node removeFirst() {
        Node n = head;
        head = head.getNext();
        n.setNext(null);
        return n;
    }

    //public void addLast(Node n) {
    //     insertAfter (get(size), n);
    // }

}
/* we’ll discuss the following methods
        • addFirst(Node n)
        • addAfter(Node n)
        • Node get(int i)
        • Node removeFirst()
        • addLast(Node n)
        • removeLast(Node n)*/
