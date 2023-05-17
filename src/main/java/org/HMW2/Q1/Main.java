package org.HMW2.Q1;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.DoubleBuffer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        step1();
        System.out.println("");
        step2();
        System.out.println("");
        step3();
        System.out.println("");
        step4();
        System.out.println("");
        step6();
        System.out.println("");
        step7();

    }


    public static void step1() throws FileNotFoundException {
        System.out.println("Integers are reading from the integers.txt file, the array is:");
        File intFile = new File("integers.txt");

        Scanner sc = new Scanner(intFile);

        int arraySize = sc.nextInt();
        Comparable[] temp = new Comparable[arraySize];

        for (int i = 0; i < arraySize; i++) {
            int data = sc.nextInt();
            temp[i] = data;
            System.out.print(data+" ");
        }
        Insertion.sort(temp);
        System.out.println("");
        System.out.println("The array has been sorted in increasing order by using the insertion sort algorithm:");
        for (int i = 0 ; i < temp.length ; i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println("");
        System.out.println("Step 1 has been completed.");
    }
    public static void step2() throws FileNotFoundException {
        System.out.println("The array of integers that has been sorted in decreasing order by using the insertion sort algorithm:");
        File intFile = new File("integers.txt");

        Scanner sc = new Scanner(intFile);

        int arraySize = sc.nextInt();
        Comparable[] temp = new Comparable[arraySize];

        for (int i = 0; i < arraySize; i++) {
            int data = sc.nextInt();
            temp[i] = data;

        }

        Insertion.sort2(temp);
        System.out.println("");
        for (int i = 0 ; i < temp.length ; i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println("");
        System.out.println("Step 2 has been completed.");
    }
    public static void step3() throws FileNotFoundException {
        File intFile = new File("doubles.txt");
        System.out.println("Doubles are reading from the doubles.txt file, the array is:");
        Scanner sc = new Scanner(intFile);

        int arraySize = sc.nextInt();
        sc.nextLine();
        Comparable[] temp = new Comparable[arraySize];

        for (int i = 0; i < arraySize; i++) {

            double data = Double.parseDouble(sc.nextLine());
            temp[i] = data;
            System.out.print(data+" ");
        }
        System.out.println("");
        Insertion.sort(temp);
        System.out.println("The array of double values has been sorted in increasing order by using the insertion sort algorithm:");
        for (int i = 0 ; i < temp.length ; i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println("");
        System.out.println("Step 3 has been completed.");
    }

    public static void step4() throws FileNotFoundException {
        File intFile = new File("integers.txt");
        System.out.println("The original array is:");
        Scanner sc = new Scanner(intFile);

        int arraySize = sc.nextInt();
        Comparable[] temp = new Comparable[arraySize];

        for (int i = 0; i < arraySize; i++) {
            int data = sc.nextInt();
            temp[i] = data;
            System.out.print(data+" ");
        }
        Merge.sort(temp);
        System.out.println("");
        System.out.println("The array of integer values has been sorted in descending order by using the merge sort algorithm is:");
        for (int i = 0 ; i < temp.length ; i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println("");
        System.out.println("Step 4 has been completed.");
    }

    public static void step6() throws FileNotFoundException {

        Comparable[] students = new Comparable[10];

        Scanner studentSc = new Scanner(new File("student.txt"));

        for (int i = 0; studentSc.hasNext(); i++) {

            String[] std = studentSc.nextLine().split(",");

            Student t = new Student(std[0], Long.parseLong(std[1]), Integer.parseInt(std[2]));
            students[i] = t;
        }

        Quick.sort(students);

        for (int i = 0 ; i < students.length ; i++){
            System.out.println(students[i]);
        }
        System.out.println("");
        System.out.println("Step 6 has been completed.");
    }
    public static void step7() throws FileNotFoundException {

        Comparable[] students = new Comparable[10];

        Scanner studentSc = new Scanner(new File("student.txt"));

        for (int i = 0; studentSc.hasNext(); i++) {

            String[] std = studentSc.nextLine().split(",");

            Student t = new Student(std[0], Long.parseLong(std[1]), Integer.parseInt(std[2]));
            students[i] = t;
        }

        Quick.sort2(students);

        for (int i = 0 ; i < students.length ; i++){
            System.out.println(students[i]);
        }
        System.out.println("");
        System.out.println("Step 7 has been completed.");
    }
}
