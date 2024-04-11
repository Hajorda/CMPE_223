package org.UndirectedGraph.GraphHMW2;
import java.util.Arrays;


class ArrayPermutations {

    static void generatePermutations(int[] array, int currentIndex) {
        if (currentIndex == array.length - 1) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = currentIndex; i < array.length; i++) {
                swap(array, currentIndex, i);
                generatePermutations(array, currentIndex + 1);
                swap(array, currentIndex, i); // Backtrack
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3};
        ArrayPermutations.generatePermutations(inputArray, 0);
    }
}
