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
    // Selection Sort
    static void selection(Comparable[] array) {
        for(int i = 0 ; i < array.length;i++) {
            int min =i;
            for(int j = i+1 ; j <array.length;j++) {
                if(less(array[j],array[min]))
                    min = j;
            }
            exch(array, i, min);
        }
    }

    // Selection Sort in Descending Order
    static void selectionDescending(Comparable[] array) {
        for(int i = 0 ; i < array.length;i++) {
            int max =i;
            for(int j = i+1 ; j <array.length;j++) {
                if(more(array[j],array[max]))
                    max = j;
            }
            exch(array, i, max);
        }
    }

    // Insertion Sort
    static void insertion(Comparable[] array) {
        for(int i = 0;i <array.length;i++) {
            for(int j=i ; j >0;j--) {
                if(less(array[j],array[j-1]))
                    exch(array, j, j-1);
                else break;
            }
        }
    }

    // Insertion Sort in Descending Order
    static void insertationDes(Comparable[] array) {
        for(int i = 0;i <array.length;i++) {
            for(int j=i ; j >0;j--) {
                if(more(array[j],array[j-1]))
                    exch(array, j, j-1);
                else break;
            }
        }
    }

    // Merge Sort
    static void merge(Comparable[] array) {
        Comparable[] aux = new Integer[array.length];
        sort(array,aux,0,array.length-1);
    }

    // Merge Sort in Descending Order
    static void mergeDes(Comparable[] array) {
        Comparable[] aux = new Integer[array.length];
        sortDes(array,aux,0,array.length-1);
    }

    // Helper method for Merge Sort
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        mergeHelper(a, aux, lo, mid, hi);
    }

    // Helper method for Merge Sort in Descending Order
    private static void sortDes(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sortDes(a, aux, lo, mid);
        sortDes(a, aux, mid+1, hi);
        mergeHelperDes(a, aux, lo, mid, hi);
    }


    private static void mergeHelper(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
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
    private static void mergeHelperDes(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (more(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
    static void quick(Comparable[] array) {
        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);


    }
    static void quickDescending(Comparable[] array) {
        StdRandom.shuffle(array);
        sortDes(array, 0, array.length - 1);


    }
    private static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        while (true)
        {
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

    private static int partitionDescending(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        while (true)
        {
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

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static void sortDes(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partitionDescending(a, lo, hi);
        sortDes(a, lo, j-1);
        sortDes(a, j+1, hi);
    }

    static void noSort(Comparable[] array) {
        int ABS = Math.abs((int)array[1]-(int)array[0]);
        int min,max;
        if(less(array[0], array[1])) {
            min = (int) array[0];
            max = (int) array[1];
        }
        else {
            max = (int) array[0];
            min = (int) array[1];

        }

        for(int i = 0;i <array.length-1;i++) {
            for(int j = i+1; j < array.length;j++) {
                int temp =Math.abs((int)array[i]-(int)array[j]);
                if(ABS >temp) {
                    ABS = temp;
                    if(less(array[i], array[j])) {
                        min = (int) array[i];
                        max = (int) array[j];
                    }
                    else {
                        max = (int) array[i];
                        min = (int) array[j];

                    }


                }
                else if(ABS ==temp) {
                    if((int)min+(int)max >((int)array[i]+(int)array[j])){
                        if(less(array[i], array[j])) {
                            min = (int) array[i];
                            max = (int) array[j];
                        }
                        else {
                            max = (int) array[i];
                            min = (int) array[j];

                        }

                    }
                }

            }
        }
        System.out.println("ABS:"+ABS+", Min="+min+", Max="+max);
    }
    static void nosort2(Comparable[] array) {
        long ABS = Math.abs((long)((int)array[1]-(int)array[0]));
        int min,max;
        if(less(array[0], array[1])) {
            min = (int) array[0];
            max = (int) array[1];
        }
        else {
            max = (int) array[0];
            min = (int) array[1];

        }

        for(int i = 0;i <array.length-1;i++) {
            for(int j = i+1; j < array.length;j++) {
                long temp =Math.abs((long)((int)array[i]-(int)array[j]));
                if(ABS >temp) {
                    ABS = temp;
                    if(less(array[i], array[j])) {
                        min = (int) array[i];
                        max = (int) array[j];
                    }
                    else {
                        max = (int) array[i];
                        min = (int) array[j];

                    }


                }
                else if(ABS ==temp) {
                    if((int)min+(int)max >((int)array[i]+(int)array[j])){
                        if(less(array[i], array[j])) {
                            min = (int) array[i];
                            max = (int) array[j];
                        }
                        else {
                            max = (int) array[i];
                            min = (int) array[j];

                        }

                    }
                }

            }
        }
        System.out.println(ABS+" ["+min+" "+max+"]");
    }

    static void random(Comparable[] array) {
        long ABS = Math.abs((long)((int)array[1]-(int)array[0]));

        int min,max;
        if(less(array[0], array[1])) {
            min = (int) array[0];
            max = (int) array[1];
        }
        else {
            max = (int) array[0];
            min = (int) array[1];

        }

        for(int i = 0;i <array.length-1;i++) {
            for(int j = i+1; j < array.length;j++) {
                long temp =Math.abs((long)((int)array[i]-(int)array[j]));
                if(ABS >temp) {
                    ABS = temp;
                    if(less(array[i], array[j])) {
                        min = (int) array[i];
                        max = (int) array[j];
                    }
                    else {
                        max = (int) array[i];
                        min = (int) array[j];

                    }


                }
                else if(ABS ==temp) {
                    if((int)min+(int)max >((int)array[i]+(int)array[j])){
                        if(less(array[i], array[j])) {
                            min = (int) array[i];
                            max = (int) array[j];
                        }
                        else {
                            max = (int) array[i];
                            min = (int) array[j];

                        }

                    }
                }

            }
        }
        System.out.println(ABS+" ["+min+" "+max+"]");
    }

    static void findpairwise(Comparable[] array) {
        int ABS = (int)array[1]-(int)array[0];
        int min= (int)array[0];
        int max =(int)array[1];
        for(int j =0;j <array.length-1;j++) {
            int temp =(int)array[j+1]-(int)array[j];
            if(ABS >temp) {
                ABS = temp;
                min = (int) array[j];
                max = (int) array[j+1];


            }
        }
        System.out.println("ABS:"+ABS+", Min="+min+", Max="+max);

    }
    private static boolean less(Comparable v ,Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static boolean more(Comparable v ,Comparable w) {
        return v.compareTo(w) > 0;
    }
    private static void exch(Comparable[] array,int i, int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the sort you want to use:");
        String sorting = scn.nextLine().toLowerCase();
        Comparable a[] = new Integer[10];
        System.out.println();
        System.out.println("Enter array:");
        for(int i = 0 ; i <10;i++) {
            a[i]=scn.nextInt();
        }
        switch(sorting) {
            case "selection":
                selection(a);
                findpairwise(a);
                break;
            case "merge":
                merge(a);
                findpairwise(a);
                break;
            case "quick":
                quick(a);
                findpairwise(a);
                break;
            case "insertion":
                insertion(a);
                findpairwise(a);
                break;
            case "nosort":
                noSort(a);
                break;
            default:

        }


    }



}
