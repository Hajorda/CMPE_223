package org.Q3;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Enter the file name:");
        Scanner sc = new Scanner(System.in);
        //String input = sc.nextLine();
        String input = "matrix1.txt";

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

            System.out.println("Line " + line);
            System.out.println(st);
            System.out.println("Boy: " + st.length());

            String ct = st.charAt(0) + "";
            if (ct.equals("-")) {
                column.push(new Node(Integer.parseInt("-" + st.charAt(1) + ""), null));
            } else {
                column.push(new Node(Integer.parseInt(st.charAt(0) + ""), null));
            }


            for (int i = 0; i < st.length(); i++) {

                String t = st.charAt(i) + "";
                System.out.println(t);
                if (!((t.equals(" ")) || (st.charAt(i) == '-'))) {
                    Node n = new Node(Integer.parseInt(st.charAt(i) + ""), null);
                    linkedLists[line].push(n);
                    System.out.println("Ali " + st.charAt(i) + " " + i);
                } else if (st.charAt(i) == '-') {
                    System.out.println("Girdi - ye");
                    System.out.println("-o" + st.charAt(i + 1));
                    Node n = new Node(Integer.parseInt("-" + st.charAt(i + 1)), null);
                    linkedLists[line].push(n);
                    i++;

                }
            }


            line++;
        }


        boolean type1 = false;
        boolean type2 = false;


        for (int i = column.size - 1; i >= 1; i--) {
            if ((column.get(i).getElement() > 0 && column.get(i - 1).getElement() > 0 && column.get(i - 2).getElement() > 0)
                    && column.get(i).getElement() < column.get(i-1).getElement() && column.get(i - 1).getElement() < column.get(i-2).getElement()) {
                type1 = true;
                System.out.println("column type 1 doğru");
            }
            if (column.get(i).getElement() < 0 && column.get(i - 1).getElement() < 0) {
                type2 = true;
                System.out.println("column type 2 doğru");
            }
        }

        for (int i = 0; i < 4; i++) {

            System.out.println("kaçınca bu" + i);

            for (int a = linkedLists[i].size - 1; a >= 1; a--) {
                System.out.println("aa " + linkedLists[i].get(a).getElement());
                //temp = linkedLists[i].get(a).getElement();

                if ((linkedLists[i].get(a).getElement() > 0 && linkedLists[i].get(a - 1).getElement() > 0 && linkedLists[i].get(a - 2).getElement() > 0) &&
                        (linkedLists[i].get(a).getElement() < linkedLists[i].get(a-1).getElement() && linkedLists[i].get(a - 1).getElement() < linkedLists[i].get(a-2).getElement())) {
                    type1 = true;
                    System.out.println("type 1 doğru");
                }
                if (linkedLists[i].get(a).getElement() < 0 && linkedLists[i].get(a - 1).getElement() < 0) {
                    type2 = true;
                    System.out.println("type 2 doğru");
                }
            }

        }

        System.out.println("TYPE1: " + type1);
        System.out.println("TYPE2: " + type2);

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
