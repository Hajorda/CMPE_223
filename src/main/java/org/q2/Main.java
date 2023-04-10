package org.q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            Stack.push(input.charAt(i) + "");
            Queue.enqueue(input.charAt(i) + "");
        }

        while (true) {
            if (Queue.isEmpty() && Stack.isEmpty()) {
                System.out.println("It is a palindrome string");
                break;
            }

            String a1 = Stack.pop();
            String a2 = Queue.dequeue();


            if (!(a1.equalsIgnoreCase(a2))) {
                System.out.println("It is not a palindrome string");
                break;
            }
        }

    }
}
