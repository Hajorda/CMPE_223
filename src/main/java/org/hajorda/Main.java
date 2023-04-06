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
    public static void order66(Student st){

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
                    =================================
                    Chose an option

                    1) Create a student
                    2) Remove a student
                    3) Summarize all the sudents
                    4) Exit
                    =================================""");

            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if (input == 1) { //Creates Student
                Student student = new Student();


                System.out.println("Enter the ID of the student.");
                student.setID(sc.nextInt());
                String asdf = sc.nextLine();
                System.out.println("Enter the name of the student.");
                student.setName(sc.nextLine());
                System.out.println("Enter the grade1 of the student.");
                student.setGrade1(sc.nextDouble());
                System.out.println("Enter the grade2 of the student.");
                student.setGrade2(sc.nextDouble());
                System.out.println("Enter the grade3 of the student.");
                student.setGrade3(sc.nextDouble());

                Stack.push(student);
                System.out.println(student.toString() + " stacka pushlandı");

                System.out.println("Hey");
                SLinkedList.push(student);
                SLinkedList.printList();


                System.out.println(student.getName()+"’s ID was "+student.getID()+". His grades were "+student.getGrade1()+", "+student.getGrade2()+" and "+student.getGrade3()+". He was ranked "+1+" in the class.");

                System.out.println(student.getName());
            } else if (input == 2) { //Delete's Student

                System.out.println(Stack.pop().getName() + " anasının nikahanıa gitti");
                System.out.println(SLinkedList.removeFirst().getElement().getName() + "Silindi ");

            } else if (input == 3) { //Print's all students info
                SLinkedList.printList();
            } else if (input == 4) { //Exit
                Stack.printStack();
                //System.exit(0);
            }
            else{
                System.out.println("Ben türkce bilmiyor");
            }
        }


    }
}