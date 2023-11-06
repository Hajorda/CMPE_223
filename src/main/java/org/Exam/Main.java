package org.Exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
 class Node{
    int data;
    Node prev;
    Node next;
     public static Node insertionSort( Node head){
         Node temp = head;
        return head;

     }
     public static void selectionSort(Comparable[] a)
     {
         int N = a.length;
         for (int i = 0; i < N; i++)
         {
             int min = i;
             for (int j = i+1; j < N; j++)
                 if (less(a[j], a[min]))
                     min = j;
             exch(a, i, min);
         }
     }
     public static void insertationSort(Comparable[] a){
        for (int i = 0 ; i < a.length ; i ++){
            for(int z = i ; z > 0 ; z--){
                if(less(a[z],a[z-1]))
                    exch(a ,z,z-1);
                else
                    break;
            }
        }
     }

     public class Merge
     {
         private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
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
         private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
         {
             if (hi <= lo) return;
             int mid = lo + (hi - lo) / 2;
                 sort(a, aux, lo, mid);
             sort(a, aux, mid+1, hi);
             merge(a, aux, lo, mid, hi);
         }
         public static void sort(Comparable[] a)
         {
             Comparable[] aux = new Comparable[a.length];
             sort(a, aux, 0, a.length - 1);
         }
     }


     private static boolean less(Comparable v, Comparable w)
     { return v.compareTo(w) < 0; }
     private static void exch(Comparable[] a, int i, int j)
     {
         Comparable swap = a[i];
         a[i] = a[j];
         a[j] = swap;
     }
}


public class Main {
    public static void main(String[] args) {

        // Make a collection
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        // Get the iterator
        Iterator<String> it = cars.iterator();

        // Print the first item
        System.out.println(it.next()+it.next());
    }
}
