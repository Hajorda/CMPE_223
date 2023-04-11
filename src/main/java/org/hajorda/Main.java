//-----------------------------------------------------
// Title: Main Class
// Author: Ali Bolat
// ID: 35485311594
// Section: 1
// Assignment: 1
// Description: This class starts the program and ask the person to chose an option.
//-----------------------------------------------------
package org.hajorda;

import java.util.Scanner;

public class Main {
    public static void order66(Student st) {

        Node newNode = new Node(st);

        // If the new node has a higher average grade than the head, insert at the beginning
        if (newNode.getElement().getAverage_grade() > SLinkedList.head.getElement().getAverage_grade()) {
            newNode.setNext(SLinkedList.head);
            SLinkedList.head = newNode;
            return;
        }

        // Otherwise, find the correct position to insert the new node
        Node current = SLinkedList.head;
        while (current.getNext() != null && current.getNext().getElement().getAverage_grade() >= newNode.getElement().getAverage_grade()) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    public static void main(String[] args) {
        while (true) {

            System.out.println("""
                    Choose an option:
                    1) Create a student:
                    2) Remove a student:
                    3) Summarize all students:
                    4) Exit:""");

            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if (input == 1) { //Creates Student



                System.out.println("Enter the ID of the student.");
                int id = sc.nextInt();
                String asdf = sc.nextLine();
                System.out.println("Enter the name of the student.");
                String name = sc.nextLine();
                System.out.println("Enter the grade1 of the student.");
                Double g1 = sc.nextDouble();
                System.out.println("Enter the grade2 of the student.");
                Double g2 = sc.nextDouble();
                System.out.println("Enter the grade3 of the student.");
                Double g3 = sc.nextDouble();

                Student student = new Student(id,name,g1,g2,g3);
                // The generated object is pushed both Stack and LinkledList
                Stack.push(student);
                SLinkedList.push(new Node(student));


                System.out.println(student.getName() + "’s ID is " + student.getID() + ". His grades were " + student.getGrade1() + ", " + student.getGrade2()
                        + " and " + student.getGrade3() + ". He was ranked " + student.getRank() + " in the class.");

            } else if (input == 2) { //Delete's Student
                Student t = Stack.pop();
                SLinkedList.remove(new Node(t));

                System.out.println(t.getName() + "’s ID was " + t.getID() + ". His grades were " + t.getGrade1() + ", " + t.getGrade2()
                        + " and " + t.getGrade3() + ". He was ranked " + t.getRank() + " in the class.");


            } else if (input == 3) { //Print's all students info
                Stack.printStack();
            } else if (input == 4) { //Exit
                SLinkedList.printList();
                //System.exit(0);
            } else {
                System.out.println("Ben türkce bilmiyor");
            }
        }


    }
}