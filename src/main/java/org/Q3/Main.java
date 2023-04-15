package org.Q3;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Enter the file name:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();


        // File path is passed as parameter
        File file = new File("C:\\Users\\hajor\\Desktop\\CMPE 223\\CMPE_223_Practise\\src\\main\\java\\org\\Q3\\" + input);

        BufferedReader br = new BufferedReader(new FileReader(file));


        String st;

        LinkedList[] linkedLists = new LinkedList[4];

        for (int i = 0; i < linkedLists.length; i++) {
            linkedLists[i] = new LinkedList();
        }

        LinkedList column = new LinkedList();


        int line = 0;

        while ((st = br.readLine()) != null) {

            Scanner scanner = new Scanner(st);

            int num = scanner.nextInt();

            Node t = new Node(num, null);
            linkedLists[line].push(t);
            column.push(t);

            while(scanner.hasNextInt()) {
                num = scanner.nextInt();
                Node n = new Node(num, null);
                linkedLists[line].push(n);
            }
            line++;
        }


        boolean type1 = false;
        boolean type2 = false;


        for (int i = column.size - 1; i >= 1; i--) {
            if (((column.get(i).getElement() > 0) && (column.get(i - 1).getElement() > 0) && (column.get(i - 2).getElement() > 0))
                    && ((column.get(i).getElement() < column.get(i - 1).getElement()) && (column.get(i - 1).getElement() < column.get(i - 2).getElement()))) {
                System.out.println("column"+column.get(i).getElement()+" "+column.get(i-1).getElement()+" "+column.get(i-2).getElement());
                type1 = true;

            }
            if ((column.get(i).getElement() < 0) && (column.get(i - 1).getElement() < 0)) {
                type2 = true;

            }
        }

        for (int i = 0; i < 4; i++) {



            for (int a = linkedLists[i].size - 1; a >= 1; a--) {

                //temp = linkedLists[i].get(a).getElement();

                if (((linkedLists[i].get(a).getElement() > 0) && (linkedLists[i].get(a - 1).getElement() > 0) && (linkedLists[i].get(a - 2).getElement() > 0)) &&
                        ((linkedLists[i].get(a).getElement() < linkedLists[i].get(a - 1).getElement()) && (linkedLists[i].get(a - 1).getElement() < linkedLists[i].get(a - 2).getElement()))) {
                    System.out.println(linkedLists[i].get(a).getElement()+","+linkedLists[i].get(a-1).getElement()+","+linkedLists[i].get(a-2).getElement());
                    type1 = true;

                }
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
