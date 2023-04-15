//-----------------------------------------------------
// Title: Main Class
// Author: Ali Bolat
// ID: 35485311594
// Section: 3
// Assignment: 1
// Description: This class starts the program and takes the String variable from the user. Also it pushes the String to Stack and Queue after that it checks the string is it palindrome or not.
//-----------------------------------------------------
package org.q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //We are taking an input as a string from user using Scanner class.
        System.out.println("Enter a string:");
        String input = sc.nextLine();

        //For loops counts as long as the input and every loop in push the letters of the input one by one from starting to zero.
        for (int i = 0; i < input.length(); i++) {
            Stack.push(input.charAt(i) + "");
            Queue.enqueue(input.charAt(i) + "");
        }

        while (true) {
            //It checks the is queue and Stack empty. Since it is empty, all letters have been checked and no inequalities have been found while checking. We call string is palindrome and we will end the program.
            if (Queue.isEmpty() && Stack.isEmpty()) {
                System.out.println("It is a palindrome string");
                break;
            }

            //Every loop we will take last letter of the input from stack with pop method and we will foremost letter from dequeue method and we equalize these to a1 and a2
            String a1 = Stack.pop();
            String a2 = Queue.dequeue();


            //We check the a1 and a2 are equal or not. If they aren't we print a message the string isn't a palindrome.
            if (!(a1.equalsIgnoreCase(a2))) {
                System.out.println("It is not a palindrome string");
                break;
            }
        }

    }
}
