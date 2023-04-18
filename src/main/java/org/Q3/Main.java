//-----------------------------------------------------
// Title: Main Class
// Author: Ali Bolat
// ID: 35485311594
// Section: 3
// Assignment: 1
// Description: This class starts the program and takes the String variable from the user. Acording to the string varible it opens a txt file and using BufferClass libary it reads the inside of the file and do calculations.
//-----------------------------------------------------
package org.Q3;

import java.io.*;
import java.util.Scanner;


public class Main {
        //This is the maim method program starts here
    public static void main(String[] args) throws IOException {

        System.out.println("Enter the file name:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); // Using scanner class we take an String from user


        // File path is passed as parameter
        File file = new File("C:\\Users\\hajor\\Desktop\\CMPE 223\\CMPE_223_Practise\\src\\main\\java\\org\\Q3\\" + input);

        BufferedReader br = new BufferedReader(new FileReader(file));


        String st;
        // We create arrays who's data types are linkedlist's
        LinkedList[] linkedLists = new LinkedList[4];
        //We initilaze our arrays those arrays for the rows
        for (int i = 0; i < linkedLists.length; i++) {
            linkedLists[i] = new LinkedList();
        }
        //We create 1 linkedlist for the first column
        LinkedList column = new LinkedList();

        //We will decleare an int for the following which line we are while reading the txt file.
        int line = 0;

        while ((st = br.readLine()) != null) {

            //We push the one line of the txt file to scanner class
            Scanner scanner = new Scanner(st);
            //It reads the first int of line
            int num = scanner.nextInt();

            //We are creating a node an we will push it to linkedlist list, while pushing we push acording to line number.
            Node t = new Node(num, null);
            linkedLists[line].push(t);
            column.push(t);

            while (scanner.hasNextInt()) {
                //Using scanner class we read the ints
                num = scanner.nextInt();
                Node n = new Node(num, null);
                linkedLists[line].push(n);
                //And again like above we push the other int to linkedlist
            }
            line++;
            //when the all line finished we add +1 to line varible
        }

        //We declare type1 and type2 booleans
        boolean type1 = false;
        boolean type2 = false;




        for (int i = 0; i < 4; i++) {

        //We create a for loop and it equal to linkedlist's size we count from the end for to checking left to right
            for (int a = linkedLists[i].size - 1; a >= 1; a--) {

                //temp = linkedLists[i].get(a).getElement();

                //This if statment check the current line is contain 3 possitive amd ardasık numbers or not. If is it it declare type1 as a true.
                if (((linkedLists[i].get(a).getElement() > 0) && (linkedLists[i].get(a - 1).getElement() > 0) && (linkedLists[i].get(a - 2).getElement() > 0)) &&
                        ((linkedLists[i].get(a).getElement() < linkedLists[i].get(a - 1).getElement()) && (linkedLists[i].get(a - 1).getElement() < linkedLists[i].get(a - 2).getElement()))) {
                    System.out.println(linkedLists[i].get(a).getElement() + "," + linkedLists[i].get(a - 1).getElement() + "," + linkedLists[i].get(a - 2).getElement());
                    type1 = true;

                }
                //  This if statment checks the is current line contain 2 negative numbers side by side.
                if ((linkedLists[i].get(a).getElement() < 0) && (linkedLists[i].get(a - 1).getElement() < 0)) {
                    type2 = true;

                }
            }

        }

        //We control the type1 and type2 and printing the conclusion
        if (type1 && type2) {
            System.out.println("It is a type 3 matrix");
        } else {
            if (type1) {
                System.out.println("It is a type 1 matrix");
            } else if (type2) {
                System.out.println("It is a type 2 matrix");
            } else {
                System.out.println("It is not one of these types");
            }

        }
    }
}
