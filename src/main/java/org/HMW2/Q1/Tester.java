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

    // Method to find the pairwise difference in the a
    static void findPairWise3(Comparable[] a) {

        int ABS = (int) a[1] - (int) a[0];

        int min = (int) a[0];
        int max = (int) a[1];

        for (int j = 0; j < a.length - 1; j++) {

            int temp = (int) a[j + 1] - (int) a[j];

            if (ABS > temp) {
                ABS = temp;
                min = (int) a[j];
                max = (int) a[j + 1];
            }
        }

        System.out.println(ABS + " [" + min + " " + max + "]");
    }

    // Method to find the pairwise difference in the array (variant 2)
    static void findPairWise2(Comparable[] a) {
        int ABS = (int) a[0] - (int) a[1];
        int min = (int) a[1];
        int max = (int) a[0];

        for (int j = 0; j < a.length - 1; j++) {

            int temp = (int) a[j] - (int) a[j + 1];

            if (ABS > temp) {

                ABS = temp;
                min = (int) a[j + 1];
                max = (int) a[j];
            }
        }

        System.out.println(ABS + " [" + min + " " + max + "]");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a seed to create randomly generated values:");

        long s = sc.nextLong();

        Random random = new Random(s);

        System.out.println("Seed: " + s);

        long t;
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

                t = System.currentTimeMillis();
                random(a);
                System.out.println(System.currentTimeMillis() - t);
            }

            System.out.println("Ascending");

            // Sorting, finding pairwise difference, and shuffling array (ascending)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                select(a);
                findPairWise3(a);
                System.out.println(System.currentTimeMillis() - t);
                StdRandom.shuffle(a);
            }

            System.out.println("Descending");

            // Sorting, finding pairwise difference, and shuffling array (descending)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                selectDes(a);
                findPairWise2(a);
                System.out.println(System.currentTimeMillis() - t);
                StdRandom.shuffle(a);
            }

            System.out.println();
            System.out.println("Sort option: Insertion");
            System.out.println("Random");

            // Sorting and finding pairwise difference (random)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                random(a);
                System.out.println(System.currentTimeMillis() - t);

            }

            System.out.println("Ascending");

            // Sorting, finding pairwise difference, and shuffling array (ascending)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                insertion(a);
                findPairWise3(a);
                System.out.println(System.currentTimeMillis() - t);
                StdRandom.shuffle(a);
            }

            System.out.println("Descending");

            // Sorting, finding pairwise difference, and shuffling array (descending)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                insertationDes(a);
                findPairWise2(a);
                System.out.println(System.currentTimeMillis() - t);
                StdRandom.shuffle(a);

            }

            System.out.println();
            System.out.println("Sort option: Merge");
            System.out.println("Random");

            // Sorting and finding pairwise difference (random)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                random(a);
                System.out.println(System.currentTimeMillis() - t);

            }

            System.out.println("Ascending");

            // Sorting, finding pairwise difference, and shuffling array (ascending)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                merge(a);
                findPairWise3(a);
                System.out.println(System.currentTimeMillis() - t);
                StdRandom.shuffle(a);

            }

            System.out.println("Descending");

            // Sorting, finding pairwise difference, and shuffling array (descending)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                mergeDes(a);
                findPairWise2(a);
                System.out.println(System.currentTimeMillis() - t);
                StdRandom.shuffle(a);

            }

            System.out.println();
            System.out.println("Sort option: Quick");
            System.out.println("Random");

            // Sorting and finding pairwise difference (random)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                random(a);
                System.out.println(System.currentTimeMillis() - t);

            }

            System.out.println("Ascending");

            // Sorting, finding pairwise difference, and shuffling array (ascending)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                quick(a);
                findPairWise3(a);
                System.out.println(System.currentTimeMillis() - t);
                StdRandom.shuffle(a);

            }

            System.out.println("Descending");

            // Sorting, finding pairwise difference, and shuffling array (descending)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                quickDes(a);
                findPairWise2(a);
                System.out.println(System.currentTimeMillis() - t);
                StdRandom.shuffle(a);

            }

            System.out.println();
            System.out.println("Sort option: NoSort");
            System.out.println("Random");

            // Sorting and finding pairwise difference (random)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                random(a);
                System.out.println(System.currentTimeMillis() - t);

            }

            System.out.println("Ascending");

            // Finding pairwise difference (ascending)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                nosort2(a);
                System.out.println(System.currentTimeMillis() - t);
                StdRandom.shuffle(a);

            }

            System.out.println("Descending");

            // Finding pairwise difference (descending)
            for (int i = 1; i <= 3; i++) {

                t = System.currentTimeMillis();
                nosort2(a);
                System.out.println(System.currentTimeMillis() - t);
                StdRandom.shuffle(a);

            }
        }
    }
}
