package org.HMW2.Q1;


import java.util.Scanner;

public class Main2 {
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




    static void insertion(Comparable[] array) {
        for(int i = 0;i <array.length;i++) {
            for(int j=i ; j >0;j--) {
                if(less(array[j],array[j-1]))
                    exch(array, j, j-1);
                else break;
            }
        }

    }

    static void insertationDes(Comparable[] array) {
        for(int i = 0;i <array.length;i++) {
            for(int j=i ; j >0;j--) {
                if(more(array[j],array[j-1]))
                    exch(array, j, j-1);
                else break;
            }
        }

    }


    static void merge(Comparable[] array) {
        Comparable[] aux = new Integer[array.length];
        sort(array,aux,0,array.length-1);

    }

    static void mergeDes(Comparable[] array) {
        Comparable[] aux = new Integer[array.length];
        sortDes(array,aux,0,array.length-1);

    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        mergeHelper(a, aux, lo, mid, hi);
    }

    private static void sortDes(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
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
                System.out.println("Ujel , you entered wrong option");
        }


    }



}
