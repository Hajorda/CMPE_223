//-----------------------------------------------------
// Title: BinaryTree Main Class
// Author: Ali Bolat
// ID: 35485311597
// Section: 3
// Assignment: 3
// Description: This class takes input from the user and accordingly calls methods.
//-----------------------------------------------------
package org.HMW3.Q2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1-> Insert, 2-> Delete, 3-> Search, 4-> List, 5-> List with Range, 6-> Quit

        while (true) {
            System.out.println("Enter operation code:");

            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter information:");
                    int id = sc.nextInt(); // Read the employee ID from the user
                    String name = sc.next(); // Read the employee name from the user
                    String gender = sc.next(); // Read the employee gender from the user
                    binarySearchTreeEmployee.insertEmployee(id, name, gender.equalsIgnoreCase("Male")); // Insert the employee into the binary search tree
                    break;
                case 2:
                    System.out.println("Enter ID to be deleted:");
                    int idToDelete = sc.nextInt(); // Read the employee ID to be deleted from the user
                    binarySearchTreeEmployee.deleteEmployee(idToDelete); // Delete the employee from the binary search tree
                    break;
                case 3:
                    System.out.println("Enter ID to be searched:");
                    int idToSearch = sc.nextInt(); // Read the employee ID to be searched from the user
                    binarySearchTreeEmployee.searchEmployee(idToSearch); // Search for the employee in the binary search tree
                    break;
                case 4:
                    binarySearchTreeEmployee.listAllEmployees(); // List all employees in the binary search tree
                    break;
                case 5:
                    System.out.println("Enter bounds of range: ");
                    int minID = sc.nextInt(); // Read the minimum ID of the range from the user
                    int maxID = sc.nextInt(); // Read the maximum ID of the range from the user
                    binarySearchTreeEmployee.listEmployeesInRange(minID, maxID); // List employees within the specified range in the binary search tree
                    break;
                case 6:
                    System.out.println("Stopped!");
                    return; // Exit the program
            }
        }
    }
}
