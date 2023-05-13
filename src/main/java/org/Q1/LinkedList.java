package org.Q1;

//-----------------------------------------------------
// Title: Stack Class
// Author: Ali Bolat
// ID: 35485311594
// Section: 3
// Assignment: 1
// Description: Student class. It contains students features methods and informations.
//-----------------------------------------------------

public class LinkedList {

    // Size of the linked list
    private int size;
    private Node head;


    //Constructor it creates a new list.
    public LinkedList() {
        size = 0;
        head = null;

    }


    // Getters and Setters methods
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }


    public void push(Node n) {

        //Adds new item to linkedlist
        if (head == null) {

            //If head is null it aoutomaticly adds head.
            head = n;
            head.setPrevious(null);
            head.setNext(null);
            size++;
            setRanks();

        } else {
            //It will check for the true place acording to the students rank and it will add it there.
            Node current = head;
            do {
                if (current.getElement().getAverage_grade() < n.getElement().getAverage_grade()) {
                    if (head == current) {
                        n.setNext(head);
                        n.setPrevious(null);
                        head.setPrevious(n);
                        head = n;
                    } else {
                        n.setNext(current);
                        n.setPrevious(current.getPrevious());
                        current.setPrevious(n);
                    }
                    size++;
                    setRanks();
                    return;


                } else if (current.getNext() == null) {
                    current.setNext(n);
                    n.setPrevious(current);
                    size++;
                    setRanks();
                    return;
                }

                current = current.getNext();


            } while (true);


        }
    }

    //This methods set the ranks of the students
    private void setRanks() {
        int rank = 1;
        Node current = head;
        while (current != null) {
            current.getElement().setRank(rank);
            rank++;

            current = current.getNext();

        }
    }


    public void remove(Student n) {
        //This method removes node from linkedlist

        Node current = head;

        while (true) {

            if (head == null) {
                return;
            }

            if (current.getElement() == n) {

                if (n == head.getElement()) {
                    if (current.getNext() != null) {
                        head = current.getNext();
                        current.getNext().setPrevious(null);
                        current.setPrevious(null);

                    } else {
                        head = null;
                    }

                } else if (current.getNext() == null) {

                    current.getPrevious().setNext(current.getNext());
                    current.setPrevious(null);
                } else {

                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    current.setPrevious(null);
                }

                System.out.println(current.getElement().getName() + "'s ID was " + current.getElement().getID() + ".His grades were " + current.getElement().getGrade1() + ", " + current.getElement().getGrade2() + " and " + current.getElement().getGrade3() + ". He was ranked " + current.getElement().getRank() + " in the class.");
                setRanks();
                size--;
                return;
            }

            current = current.getNext();
        }

    }


}