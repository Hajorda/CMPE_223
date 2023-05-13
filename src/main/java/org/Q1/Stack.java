package org.Q1;

//-----------------------------------------------------
// Title: Stack Class
// Author: Ali Bolat
// ID: 35485311594
// Section: 3
// Assignment: 1
// Description: This class for the Stack database. It contains the Stacks's methods and Stacks's structure.
//-----------------------------------------------------

public class Stack {

    private Student[] students; //For the easy usage i created an array.
    private int N = 0; //For the follow the which array is.

    public Stack() {
        //Constructor creates new array.
        students = new Student[1];

    }


    // This methods resize the array when there is no empty slot.
    private void resize(int capacity) {

        Student[] temp = new Student[capacity];
        for(int i = 0;i < N;i++) {
            temp[i] = students[i];
        }
        students = temp;
    }
    // Push method using for adding item to Stack. When you add an item it will declare next as a current item and first variable will be item that pushed. Lastly it will take an String and it will put Node's item name as a that String.
    public void push(Student student) {

        if(N == students.length) {
            resize(2* students.length);

        }
        students[N++]= student;

    }

    //Pop method delete's current first item and return that item. The delation prosses done by equating the first to the next of the first.
    public Student pop() {
        /*This method removes student from stack and returns student object.
         * If stacks underflows, method calls resize method.*/
        Student a = students[--N];
        students[N]=null;
        if(N >0 && N== students.length/4) {
            resize(students.length/2);
        }
        return a;
    }

    //Prints the student using array.
    public void printAll() {/*
	This method prints all student objects.
	*/
        for(int i =0 ; i <N;i++) {
            System.out.println(students[N-1-i]);
        }
    }

}