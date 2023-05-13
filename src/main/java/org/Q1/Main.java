package org.Q1;
//-----------------------------------------------------
// Title: Main Class
// Author: Ali Bolat
// ID: 35485311594
// Section: 1
// Assignment: 1
// Description: This class starts the program and ask the person to chose an option.
//-----------------------------------------------------

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //We create objects from our LinkedList class Stack class and scanner class
        LinkedList List = new LinkedList();
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);


        while (true) {

            System.out.println("Choose an option:\n"
                    + "1) Create a student:\n"
                    + "2) Remove a student:\n"
                    + "3) Summarize all students:\n"
                    + "4) Exit:");

            //We take the int using scanner class
            int option = sc.nextInt();

            if (option == 1) {
                System.out.println("Enter the ID of the student.");
                int ID = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the name of the student.");
                String name = sc.nextLine();
                System.out.println("Enter the grade1 of the student.");
                double grade1 = sc.nextDouble();
                System.out.println("Enter the grade2 of the student.");
                double grade2 = sc.nextDouble();
                System.out.println("Enter the grade3 of the student.");
                double grade3 = sc.nextDouble();

                //We take the inputs using scanner class and we creating student object acourding to these inputs after that we pushed it to both linkedlist and stack
                Student student = new Student(ID, name, grade1, grade2, grade3);
                List.push(new Node(student));
                stack.push(student);
            } else if (option == 2) {
                List.remove(stack.pop());
            } else if (option == 3) {
                stack.printAll();

            } else if (option == 4) {
                stack.printAll();
                break;
            }


        }

    }

}