package org.HMW3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void printBig(String p) {
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

        while (sc.hasNextLine()) {
            String[] l = sc.nextLine().split(",");
            String[] p1 = l[0].split(" ");
            String[] p2 = l[1].split(" ");
            // System.out.println(p1[0] + " --> " + p2[0]);
            FamilyTree.insert(p1[0], Integer.parseInt(p1[1]), p2[0], Integer.parseInt(p2[1]));
        }

        while (true) {

            System.out.println("Enter operation code: ");
            int input = is.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter ID:");
                    int id = is.nextInt();
                    FamilyTree.printAllDescendants(id);
                    break;
                case 2:
                    System.out.println("Enter IDs:");
                    int id1 = is.nextInt();
                    int id2 = is.nextInt();
                    printBig("" + FamilyTree.checkAncestor(id1, id2));
                    break;
                case 3:
                    System.out.println("Enter IDs:");
                    int id3 = is.nextInt();
                    int id4 = is.nextInt();
                    printBig(FamilyTree.checkDescentdant(id3, id4) + "");
                    break;
                case 4:
                    System.out.println("Enter IDs:");
                    int id5 = is.nextInt();
                    int id6 = is.nextInt();
                    printBig(FamilyTree.checkSibling(id5, id6) + "");
                    break;
                case 5:
                    System.out.println("Enter IDs:");
                    int id7 = is.nextInt();
                    int id8 = is.nextInt();
                    FamilyTree.findFirstOldestCommonRelative(id7, id8);
                    break;
                case 6:
                    System.out.println("Stopped!");
                    return;
            }

        }

    }
}
