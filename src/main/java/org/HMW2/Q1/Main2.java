package org.HMW2.Q1;

import java.util.Scanner;

//------------------------------------------
// Title: Main Class for Q2
// Author: Ali Bolat
// ID: 35485311594
// Section: 3
// Assignment: 2
// -----------------------------------------

public class Main2 {


    // Selection Sort in Descending Order
    static void selectDes(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {
            int max = i;

            for (int j = i + 1; j < a.length; j++) {
                if (more(a[j], a[max]))
                    max = j;
            }
            exch(a, i, max);
        }
    }

    // Insertion Sort
    static void insertion(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
                else break;
            }
        }
    }

    // Insertion Sort in Descending Order
    static void insertationDes(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {

            for (int j = i; j > 0; j--) {

                if (more(a[j], a[j - 1]))
                    exch(a, j, j - 1);
                else break;
            }
        }
    }


    // Selection Sort
    static void select(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {

            int m = i;

            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[m]))
                    m = j;
            }
            exch(a, i, m);
        }
    }

    // Merge Sort in Descending Order
    static void mergeDes(Comparable[] a) {

        Comparable[] aux = new Integer[a.length];
        sortDes(a, aux, 0, a.length - 1);

    }


    // Merge Sort
    static void merge(Comparable[] a) {

        Comparable[] aux = new Integer[a.length];

        sort(a, aux, 0, a.length - 1);
    }

    private static void mergeHelper(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {

            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];

        }
    }
// This code implements various sorting algorithms and a pairwise finding algorithm.
// It provides options for selecting the sorting algorithm and processing an array.
// The code is written in Java.

// The mergeHelper() method is a helper function used in the merge sort algorithm.
// It merges two subarrays of a given array.

// The mergeHelperDes() method is a helper function used in the descending merge sort algorithm.
// It merges two subarrays of a given array in descending order.

// The quick() method performs the quicksort algorithm on the given array.

// The quickDescending() method performs the descending quicksort algorithm on the given array.

// The partition() method is a helper function used in the quicksort algorithm.
// It partitions the array into two parts based on a pivot element.

// The partitionDescending() method is a helper function used in the descending quicksort algorithm.
// It partitions the array into two parts based on a pivot element in descending order.

// The sort() method is a recursive function that implements the quicksort algorithm.
// It sorts a subarray of the given array.

// The sortDes() method is a recursive function that implements the descending quicksort algorithm.
// It sorts a subarray of the given array in descending order.

// The noSort() method finds the minimum and maximum pair in the array without performing any sorting.

// The nosort2() method is a modified version of noSort() that works with a different data type and prints the result in a different format.

// The random() method is similar to noSort() but works with a different data type and prints the result in a different format.

// The findpairwise() method finds the minimum and maximum pairwise difference in the array.

// The less() method compares two Comparable objects and returns true if the first one is less than the second one.

// The more() method compares two Comparable objects and returns true if the first one is greater than the second one.

// The exch() method exchanges two elements in the given array.

    // The main() function is the entry point of the program.
// It prompts the user to enter the desired sorting algorithm and an array, and then processes the array based on the chosen algorithm.

    private static void mergeHelperDes(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (more(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    // Helper method for Merge Sort
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        mergeHelper(a, aux, lo, mid, hi);
    }

    // Helper method for Merge Sort in Descending Order
    private static void sortDes(Comparable[] a, Comparable[] aux, int lo, int hi) {

        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sortDes(a, aux, lo, mid);
        sortDes(a, aux, mid + 1, hi);
        mergeHelperDes(a, aux, lo, mid, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {

        int i = lo, j = hi + 1;

        while (true) {

            while (less(a[++i], a[lo]))
                if (i == hi) break;
            while (less(a[lo], a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static int partitionDes(Comparable[] a, int lo, int hi) {

        int i = lo, j = hi + 1;

        while (true) {

            while (more(a[++i], a[lo]))
                if (i == hi) break;
            while (more(a[lo], a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }

    static void quick(Comparable[] a) {

        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);


    }

    static void quickDes(Comparable[] a) {
        StdRandom.shuffle(a);
        sortDes(a, 0, a.length - 1);


    }


    static void random(Comparable[] a) {
        long ABS = Math.abs((long) ((int) a[1] - (int) a[0]));

        int min, max;

        if (less(a[0], a[1])) {
            min = (int) a[0];
            max = (int) a[1];
        } else {
            max = (int) a[0];
            min = (int) a[1];

        }

        for (int i = 0; i < a.length - 1; i++) {

            for (int j = i + 1; j < a.length; j++) {

                long temp = Math.abs((long) ((int) a[i] - (int) a[j]));

                if (ABS > temp) {

                    ABS = temp;
                    if (less(a[i], a[j])) {

                        min = (int) a[i];
                        max = (int) a[j];

                    } else {

                        max = (int) a[i];
                        min = (int) a[j];

                    }


                } else if (ABS == temp) {

                    if ((int) min + (int) max > ((int) a[i] + (int) a[j])) {

                        if (less(a[i], a[j])) {
                            min = (int) a[i];
                            max = (int) a[j];
                        } else {
                            max = (int) a[i];
                            min = (int) a[j];

                        }

                    }
                }

            }
        }
        System.out.println(ABS + " [" + min + " " + max + "]");
    }

    static void noSort(Comparable[] a) {

        int ABS = Math.abs((int) a[1] - (int) a[0]);
        int min, max;

        if (less(a[0], a[1])) {

            min = (int) a[0];
            max = (int) a[1];

        } else {
            max = (int) a[0];
            min = (int) a[1];

        }

        for (int i = 0; i < a.length - 1; i++) {

            for (int j = i + 1; j < a.length; j++) {

                int temp = Math.abs((int) a[i] - (int) a[j]);

                if (ABS > temp) {
                    ABS = temp;

                    if (less(a[i], a[j])) {

                        min = (int) a[i];
                        max = (int) a[j];
                    } else {

                        max = (int) a[i];
                        min = (int) a[j];

                    }


                } else if (ABS == temp) {
                    if ((int) min + (int) max > ((int) a[i] + (int) a[j])) {
                        if (less(a[i], a[j])) {
                            min = (int) a[i];
                            max = (int) a[j];
                        } else {
                            max = (int) a[i];
                            min = (int) a[j];

                        }

                    }
                }

            }
        }
        System.out.println("ABS:" + ABS + ", Min=" + min + ", Max=" + max);
    }

    static void nosort2(Comparable[] a) {

        long ABS = Math.abs((long) ((int) a[1] - (int) a[0]));

        int min, max;
        
        if (less(a[0], a[1])) {
            
            min = (int) a[0];
            max = (int) a[1];
        } else {
            
            max = (int) a[0];
            min = (int) a[1];

        }

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                long temp = Math.abs((long) ((int) a[i] - (int) a[j]));
                if (ABS > temp) {
                    ABS = temp;
                    if (less(a[i], a[j])) {
                        min = (int) a[i];
                        max = (int) a[j];
                    } else {
                        max = (int) a[i];
                        min = (int) a[j];

                    }


                } else if (ABS == temp) {
                    if ((int) min + (int) max > ((int) a[i] + (int) a[j])) {
                        if (less(a[i], a[j])) {
                            min = (int) a[i];
                            max = (int) a[j];
                        } else {
                            max = (int) a[i];
                            min = (int) a[j];

                        }

                    }
                }

            }
        }
        System.out.println(ABS + " [" + min + " " + max + "]");
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static void sortDes(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partitionDes(a, lo, hi);
        sortDes(a, lo, j - 1);
        sortDes(a, j + 1, hi);
    }


    static void findPairWise(Comparable[] a) {

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
        System.out.println("ABS:" + ABS + ", Min=" + min + ", Max=" + max);

    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean more(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    private static void exch(Comparable[] a, int i, int j) {

        Comparable swap = a[i];

        a[i] = a[j];
        a[j] = swap;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the sort you want to use:");

        String sorting = sc.nextLine();

        Comparable a[] = new Integer[10];

        System.out.println();
        System.out.println("Enter array:");

        for (int i = 0; i < 10; i++) {

            a[i] = sc.nextInt();
        }

        switch (sorting) {
            case "selection" -> {
                select(a);
                findPairWise(a);
            }
            case "merge" -> {
                merge(a);
                findPairWise(a);
            }
            case "quick" -> {
                quick(a);
                findPairWise(a);
            }
            case "insertion" -> {
                insertion(a);
                findPairWise(a);
            }
            case "nosort" -> noSort(a);
            default -> {
            }
        }


    }


}
