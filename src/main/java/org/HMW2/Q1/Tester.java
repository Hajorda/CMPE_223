package org.HMW2.Q1;

import java.util.Random;
import java.util.Scanner;

//------------------------------------------
// Title: Tester Class for Q2
// Author: Ali Bolat
// ID: 35485311594
// Section: 3
// Assignment: 2
// -----------------------------------------

public class Tester extends Main2 {

    // Method to find the pairwise difference in the array
    static void findpairwise(Comparable[] array) {
        int ABS = (int) array[1] - (int) array[0];
        int min = (int) array[0];
        int max = (int) array[1];

        for (int j = 0; j < array.length - 1; j++) {
            int temp = (int) array[j + 1] - (int) array[j];
            if (ABS > temp) {
                ABS = temp;
                min = (int) array[j];
                max = (int) array[j + 1];
            }
        }

        System.out.println(ABS + " [" + min + " " + max + "]");
    }

    // Method to find the pairwise difference in the array (variant 2)
    static void findpairwise2(Comparable[] array) {
        int ABS = (int) array[0] - (int) array[1];
        int min = (int) array[1];
        int max = (int) array[0];

        for (int j = 0; j < array.length - 1; j++) {
            int temp = (int) array[j] - (int) array[j + 1];
            if (ABS > temp) {
                ABS = temp;
                min = (int) array[j + 1];
                max = (int) array[j];
            }
        }

        System.out.println(ABS + " [" + min + " " + max + "]");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a seed to create randomly generated values:");
        long seed = scn.nextLong();
        Random random = new Random(seed);
        System.out.println("Seed: " + seed);

        long time;
        Integer[] a;

        for (int x = 250; x <= 64000; x *= 4) {
            System.out.println();
            System.out.println("Input size: " + x);
            System.out.println();

            a = new Integer[x];

            // Generating random values
            for (int i = 0; i < x; i++) {
                a[i] = random.nextInt();
            }

            System.out.println("Sort option: Selection");
            System.out.println("Random");

            // Sorting and finding pairwise difference (random)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                random(a);
                System.out.println(System.currentTimeMillis() - time);
            }

            System.out.println("Ascending");

            // Sorting, finding pairwise difference, and shuffling array (ascending)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                selection(a);
                findpairwise(a);
                System.out.println(System.currentTimeMillis() - time);
                StdRandom.shuffle(a);
            }

            System.out.println("Descending");

            // Sorting, finding pairwise difference, and shuffling array (descending)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                selectionDescending(a);
                findpairwise2(a);
                System.out.println(System.currentTimeMillis() - time);
                StdRandom.shuffle(a);
            }

            System.out.println();
            System.out.println("Sort option: Insertion");
            System.out.println("Random");

            // Sorting and finding pairwise difference (random)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                random(a);
                System.out.println(System.currentTimeMillis() - time);
            }

            System.out.println("Ascending");

            // Sorting, finding pairwise difference, and shuffling array (ascending)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                insertion(a);
                findpairwise(a);
                System.out.println(System.currentTimeMillis() - time);
                StdRandom.shuffle(a);
            }

            System.out.println("Descending");

            // Sorting, finding pairwise difference, and shuffling array (descending)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                insertationDes(a);
                findpairwise2(a);
                System.out.println(System.currentTimeMillis() - time);
                StdRandom.shuffle(a);
            }

            System.out.println();
            System.out.println("Sort option: Merge");
            System.out.println("Random");

            // Sorting and finding pairwise difference (random)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                random(a);
                System.out.println(System.currentTimeMillis() - time);
            }

            System.out.println("Ascending");

            // Sorting, finding pairwise difference, and shuffling array (ascending)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                merge(a);
                findpairwise(a);
                System.out.println(System.currentTimeMillis() - time);
                StdRandom.shuffle(a);
            }

            System.out.println("Descending");

            // Sorting, finding pairwise difference, and shuffling array (descending)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                mergeDes(a);
                findpairwise2(a);
                System.out.println(System.currentTimeMillis() - time);
                StdRandom.shuffle(a);
            }

            System.out.println();
            System.out.println("Sort option: Quick");
            System.out.println("Random");

            // Sorting and finding pairwise difference (random)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                random(a);
                System.out.println(System.currentTimeMillis() - time);
            }

            System.out.println("Ascending");

            // Sorting, finding pairwise difference, and shuffling array (ascending)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                quick(a);
                findpairwise(a);
                System.out.println(System.currentTimeMillis() - time);
                StdRandom.shuffle(a);
            }

            System.out.println("Descending");

            // Sorting, finding pairwise difference, and shuffling array (descending)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                quickDescending(a);
                findpairwise2(a);
                System.out.println(System.currentTimeMillis() - time);
                StdRandom.shuffle(a);
            }

            System.out.println();
            System.out.println("Sort option: NoSort");
            System.out.println("Random");

            // Sorting and finding pairwise difference (random)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                random(a);
                System.out.println(System.currentTimeMillis() - time);
            }

            System.out.println("Ascending");

            // Finding pairwise difference (ascending)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                nosort2(a);
                System.out.println(System.currentTimeMillis() - time);
                StdRandom.shuffle(a);
            }

            System.out.println("Descending");

            // Finding pairwise difference (descending)
            for (int i = 1; i <= 3; i++) {
                time = System.currentTimeMillis();
                nosort2(a);
                System.out.println(System.currentTimeMillis() - time);
                StdRandom.shuffle(a);
            }
        }
    }
}
