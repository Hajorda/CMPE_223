package org.HMW2.Q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File intFile = new File("C:\\Users\\hajor\\Desktop\\CMPE 223\\CMPE_223_Practise\\src\\main\\java\\org\\HMW2\\Q1\\integers.txt");

        Scanner sc = new Scanner(intFile);

        int arraySize = sc.nextInt();
        Comparable[] temp = new Comparable[arraySize];

        for (int i = 0; i < arraySize ; i++){
            int data = sc.nextInt();
            temp[i] = data;
            System.out.println(data);
        }
        Insertion a = new Insertion();
        a.sort(temp);
        System.out.println("----------------------------- ");
        for(int i = 0 ; i < arraySize ; i++)
            System.out.println(temp[i]);
    }
}
