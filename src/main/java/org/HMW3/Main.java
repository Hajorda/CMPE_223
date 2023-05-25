package org.HMW3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\hajor\\Desktop\\CMPE 223\\CMPE_223_Practise\\src\\main\\java\\org\\HMW3\\family1.txt");
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()){
            String[] l = sc.nextLine().split(",");
            String[] p1 = l[0].split(" ");
            String[] p2 = l[1].split(" ");
            System.out.println(p1[0]+" --> "+p2[0]);
            FamilyTree.insert(p1[0],Integer.parseInt(p1[1]),p2[0],Integer.parseInt(p2[1]));
        }

    }
}
