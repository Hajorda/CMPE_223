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
                    System.out.println("Enter information:");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String gender = sc.next();
                    binarySearchTreeEmployee.insertEmployee(id, name, gender.equalsIgnoreCase("Male"));
                    break;
                case 2:
                    System.out.println("Enter ID to be deleted:");
                    int idToDelete = sc.nextInt();
                    binarySearchTreeEmployee.deleteEmployee(idToDelete);
                    break;
                case 3:
                    System.out.println("Enter ID to be searched:");
                    int idToSearch = sc.nextInt();
                    binarySearchTreeEmployee.searchEmployee(idToSearch);
                    break;
                case 4:
                    binarySearchTreeEmployee.listAllEmployees();
                    break;
                case 5:
                    System.out.println("Enter bounds of range: ");
                    int minID = sc.nextInt();
                    int maxID = sc.nextInt();
                    binarySearchTreeEmployee.listEmployeesInRange(minID, maxID);
                    break;
                case 6:
                    System.out.println("Stopped!");
                    return;
            }

        }
    }
}