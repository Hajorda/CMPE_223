//-----------------------------------------------------
// Title: FamilyTree Main class
// Author: Ali Bolat
// ID: 35485311597
// Section: 3
// Assignment: 3
// Description: This class takes input from the user and accordingly calls methods.
//-----------------------------------------------------
package org.HMW3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void printBig(String p) {
        // Method to print "True" if the input is "true", "False" if the input is "false",
        // or the input string itself if it's neither "true" nor "false".
        if (p.equalsIgnoreCase("true"))
            System.out.println("True");
        else if (p.equalsIgnoreCase("false")) {
            System.out.println("False");
        } else
            System.out.println(p);
    }

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Enter filename:");
        Scanner is = new Scanner(System.in);
        String fileName = is.nextLine();

        File file = new File("family1.txt");
        Scanner sc = new Scanner(file);

        // Reading the contents of the file line by line
        while (sc.hasNextLine()) {
            // Splitting each line by comma (",") to separate parent names and ages
            String[] l = sc.nextLine().split(",");
            // Splitting the first parent's information by space (" ") to get the name and age separately
            String[] p1 = l[0].split(" ");
            // Splitting the second parent's information by space (" ") to get the name and age separately
            String[] p2 = l[1].split(" ");
            // Inserting the parent and child information into the FamilyTree data structure
            FamilyTree.insert(p1[0], Integer.parseInt(p1[1]), p2[0], Integer.parseInt(p2[1]));
        }

        while (true) {

            System.out.println("Enter operation code: ");
            int input = is.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter ID:");
                    int id = is.nextInt();
                    // Printing all descendants of a person given their ID
                    FamilyTree.printAllDescendants(id);
                    break;
                case 2:
                    System.out.println("Enter IDs:");
                    int id1 = is.nextInt();
                    int id2 = is.nextInt();
                    // Checking if the first person is an ancestor of the second person and printing the result
                    printBig("" + FamilyTree.checkAncestor(id1, id2));
                    break;
                case 3:
                    System.out.println("Enter IDs:");
                    int id3 = is.nextInt();
                    int id4 = is.nextInt();
                    // Checking if the first person is a descendant of the second person and printing the result
                    printBig(FamilyTree.checkDescentdant(id3, id4) + "");
                    break;
                case 4:
                    System.out.println("Enter IDs:");
                    int id5 = is.nextInt();
                    int id6 = is.nextInt();
                    // Checking if the two people are siblings and printing the result
                    printBig(FamilyTree.checkSibling(id5, id6) + "");
                    break;
                case 5:
                    System.out.println("Enter IDs:");
                    int id7 = is.nextInt();
                    int id8 = is.nextInt();
                    // Finding the first oldest common relative of two people and printing the result
                    FamilyTree.findFirstOldestCommonRelative(id7, id8);
                    break;
                case 6:
                    System.out.println("Stopped!");
                    return;
            }

        }

    }
}

