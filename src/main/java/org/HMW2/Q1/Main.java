package org.HMW2.Q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.DoubleBuffer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("----------------------------- ");
      // step1();
      // step2();
        step3();
       // step4();
       // step6();
       // step7();

    }


    public static void step1() throws FileNotFoundException {
        File intFile = new File("C:\\Users\\hajor\\Desktop\\CMPE 223\\CMPE_223_Practise\\src\\main\\java\\org\\HMW2\\Q1\\integers.txt");

        Scanner sc = new Scanner(intFile);

        int arraySize = sc.nextInt();
        Comparable[] temp = new Comparable[arraySize];

        for (int i = 0; i < arraySize; i++) {
            int data = sc.nextInt();
            temp[i] = data;
            System.out.println(data);
        }
        Insertion.sort(temp);
        System.out.println("--------------------");
        for (int i = 0 ; i < temp.length ; i++){
            System.out.println(temp[i]);
        }
    }
    public static void step2() throws FileNotFoundException {
        File intFile = new File("C:\\Users\\hajor\\Desktop\\CMPE 223\\CMPE_223_Practise\\src\\main\\java\\org\\HMW2\\Q1\\integers.txt");

        Scanner sc = new Scanner(intFile);

        int arraySize = sc.nextInt();
        Comparable[] temp = new Comparable[arraySize];

        for (int i = 0; i < arraySize; i++) {
            int data = sc.nextInt();
            temp[i] = data;
            System.out.println(data);
        }
        Insertion.sort2(temp);
        System.out.println("--------------------");
        for (int i = 0 ; i < temp.length ; i++){
            System.out.println(temp[i]);
        }
    }
    public static void step3() throws FileNotFoundException {
        File intFile = new File("C:\\Users\\hajor\\Desktop\\CMPE 223\\CMPE_223_Practise\\src\\main\\java\\org\\HMW2\\Q1\\doubles.txt");

        Scanner sc = new Scanner(intFile);

        int arraySize = sc.nextInt();
        Comparable[] temp = new Comparable[arraySize];

        for (int i = 0; i < arraySize; i++) {

            double data = Double.parseDouble(sc.nextLine());
            temp[i] = data;
            System.out.println(data);
        }
        Insertion.sort(temp);
        System.out.println("--------------------");
        for (int i = 0 ; i < temp.length ; i++){
            System.out.println(temp[i]);
        }
    }

    public static void step4() throws FileNotFoundException {
        File intFile = new File("C:\\Users\\hajor\\Desktop\\CMPE 223\\CMPE_223_Practise\\src\\main\\java\\org\\HMW2\\Q1\\integers.txt");

        Scanner sc = new Scanner(intFile);

        int arraySize = sc.nextInt();
        Comparable[] temp = new Comparable[arraySize];

        for (int i = 0; i < arraySize; i++) {
            int data = sc.nextInt();
            temp[i] = data;
            System.out.println(data);
        }
        Merge.sort(temp);
        System.out.println("--------------------");
        for (int i = 0 ; i < temp.length ; i++){
            System.out.println(temp[i]);
        }
    };

    public static void step6() throws FileNotFoundException {

        Comparable[] students = new Comparable[10];

        Scanner studentSc = new Scanner(new File("C:\\Users\\hajor\\Desktop\\CMPE 223\\CMPE_223_Practise\\src\\main\\java\\org\\HMW2\\Q1\\student.txt"));

        for (int i = 0; studentSc.hasNext(); i++) {

            String[] std = studentSc.nextLine().split(",");

            Student t = new Student(std[0], Long.parseLong(std[1]), Integer.parseInt(std[2]));
            students[i] = t;
        }

            Quick.sort(students);

        for (int i = 0 ; i < students.length ; i++){
            System.out.println(students[i]);
        }
    }
    public static void step7() throws FileNotFoundException {

        Comparable[] students = new Comparable[10];

        Scanner studentSc = new Scanner(new File("C:\\Users\\hajor\\Desktop\\CMPE 223\\CMPE_223_Practise\\src\\main\\java\\org\\HMW2\\Q1\\student.txt"));

        for (int i = 0; studentSc.hasNext(); i++) {

            String[] std = studentSc.nextLine().split(",");

            Student t = new Student(std[0], Long.parseLong(std[1]), Integer.parseInt(std[2]));
            students[i] = t;
        }

        Quick.sort2(students);

        for (int i = 0 ; i < students.length ; i++){
            System.out.println(students[i]);
        }
    }
}
