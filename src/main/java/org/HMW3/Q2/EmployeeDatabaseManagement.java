package org.HMW3.Q2;

import java.util.Scanner;

public class EmployeeDatabaseManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDatabase database = new EmployeeDatabase();

        while (true) {
            System.out.println("1. Insert an employee");
            System.out.println("2. Delete an employee");
            System.out.println("3. Search for an employee by ID");
            System.out.println("4. List all employees in order by ID");
            System.out.println("5. List all employees in order by ID within a range");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Gender (0 for male, 1 for female): ");
                    boolean gender = scanner.nextInt() == 1;
                    database.insertEmployee(id, name, gender);
                    System.out.println("Employee inserted successfully.");
                    break;
                case 2:
                    System.out.print("Enter ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    database.deleteEmployee(idToDelete);
                    System.out.println("Employee deleted successfully.");
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    int idToSearch = scanner.nextInt();
                    database.searchEmployee(idToSearch);
                    break;
                case 4:
                    System.out.println("List of all employees:");
                    database.listAllEmployees();
                    break;
                case 5:
                    System.out.print("Enter minimum ID: ");
                    int minID = scanner.nextInt();
                    System.out.print("Enter maximum ID: ");
                    int maxID = scanner.nextInt();
                    System.out.println("List of employees within the given range:");
                    database.listEmployeesInRange(minID, maxID);
                    break;
                case 6:
                    System.out.println("Program terminated.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}