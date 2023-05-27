package org.HMW3.Q2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //1-> Insert, 2-> Delete, 3-> search, 4-> List, 5->List with Range, 6-> Quit

        while (true) {
            System.out.println("Enter operation code:");

            int input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.print("Enter information:");
                    int id = sc.nextInt();
                    String name = sc.next();
                    boolean gender = sc.nextInt() == 1;
                    EmployeeDatabase.insertEmployee(id, name, gender);
                    break;
                case 2:
                    System.out.print("Enter ID to be deleted:");
                    int idToDelete = sc.nextInt();
                    EmployeeDatabase.deleteEmployee(idToDelete);
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    int idToSearch = sc.nextInt();
                    EmployeeDatabase.searchEmployee(idToSearch);
                    break;
                case 4:
                    EmployeeDatabase.listAllEmployees();
                    break;
                case 5:
                    System.out.print("Enter bounds of range: ");
                    int minID = sc.nextInt();
                    int maxID = sc.nextInt();
                    EmployeeDatabase.listEmployeesInRange(minID, maxID);
                    break;
                case 6:
                    System.out.println("Stopped!");
                    return;
            }

        }
    }
}