package org.UndirectedGraph.GraphHMW2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BagPermutations<Item> {

    private LinkedList<Bag> t = new LinkedList<>();
    public <Item> LinkedList<Bag> generatePermutations(Bag<Item> bag) {
        generatePermutationsHelper(bag, new Bag<Item>(), bag.size());
        return t;
    }

    private  <Item> void generatePermutationsHelper(Bag<Item> originalBag, Bag<Item> currentPermutation, int remaining) {
        if (remaining == 0) {
            t.add(currentPermutation);
            printPermutation(currentPermutation);
        } else {
            for (Item item : originalBag) {
                Bag<Item> newOriginalBag = new Bag<>(); // Create a copy of the bag to remove used elements
                for (Item i : originalBag) {
                    newOriginalBag.add(i);
                }
                newOriginalBag.remove(item);

                Bag<Item> newPermutation = new Bag<>(); // Create a copy of the current permutation
                for (Item i : currentPermutation) {
                    newPermutation.add(i);
                }
                newPermutation.add(item);

                generatePermutationsHelper(newOriginalBag, newPermutation, remaining - 1);
            }
        }
    }

    private static <Item> void printPermutation(Bag<Item> bag) {
        for (Item item : bag) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Bag<Integer> inputBag = new Bag<>();
        inputBag.add(1);
        inputBag.add(2);
        inputBag.add(3);
        BagPermutations a = new BagPermutations();

    }
}
