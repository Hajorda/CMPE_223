//-----------------------------------------------------
// Title: BinaryTree Main Class
// Author: Ali Bolat
// ID: 35485311597
// Section: 3
// Assignment: 3
// Description: This class contains Binary Search tree methods suc has searching tree adding new nodes accordingly the tree structure and deletes. Also Print's employee's in the tree all of them or range.
//-----------------------------------------------------
package org.HMW3.Q2;

//Node for Binary Search tree it contains id and name, also for the bottom Nodes left and right. It's an inner class
class Employee {
    int id;
    String name;
    boolean gender;
    Employee left, right;
//Constructor for the Employee class it help to generate Employee objects.
    public Employee(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        left = right = null;
    }
}

class binarySearchTreeEmployee {
    //Root the first Node
    private static Employee root;

    public binarySearchTreeEmployee() {
        root = null;
    }

    public static void insertEmployee(int id, String name, boolean gender) {
        root = insertEmployeeR(root, new Employee(id, name, gender));
    }

    // Recursive function to insert an employee into the binary search tree
    private static Employee insertEmployeeR(Employee r, Employee t) {
        if (r == null) {
            r = new Employee(t.id, t.name, t.gender);
            return r;
        }

        if (t.id < r.id)
            r.left = insertEmployeeR(r.left, t);
        else if (t.id > r.id)
            r.right = insertEmployeeR(r.right, t);

        return r;
    }

    public static void deleteEmployee(int id) {
        root = deleteEmployeeR(root, id);
    }

    // Recursive function to delete an employee from the binary search tree
    private static Employee deleteEmployeeR(Employee r, int id) {
        if (r == null)
            return r;

        if (id < r.id)
            r.left = deleteEmployeeR(r.left, id);
        else if (id > r.id)
            r.right = deleteEmployeeR(r.right, id);
        else {
            if (r.left == null)
                return r.right;
            else if (r.right == null)
                return r.left;

            r.id = getMinimumID(r.right);
            r.right = deleteEmployeeR(r.right, r.id);
        }

        return r;
    }

    // Helper function to get the minimum ID in the binary search tree
    private static int getMinimumID(Employee r) {
        int minID = r.id;

        while (r.left != null) {
            minID = r.left.id;
            r = r.left;
        }

        return minID;
    }

    public static void searchEmployee(int id) {
        searchEmployeeR(root, id);
    }

    // Recursive function to search for an employee in the binary search tree
    private static void searchEmployeeR(Employee r, int id) {
        if (r == null) {
            System.out.println("No record found.");
            return;
        }

        if (id == r.id) {
            String g;
            if (r.gender)
                g = "Male";
            else
                g = "Female";
            System.out.println("ID: " + r.id + ", Name: " + r.name + ", Gender: " + g);
        } else if (id < r.id) {
            searchEmployeeR(r.left, id);
        } else {
            searchEmployeeR(r.right, id);
        }
    }

    public static void listAllEmployees() {
        listAllEmployeesR(root);
    }

    // Recursive function to list all employees in the binary search tree
    private static void listAllEmployeesR(Employee r) {
        if (r != null) {
            String g;
            if (r.gender)
                g = "Male";
            else
                g = "Female";
            listAllEmployeesR(r.left);
            System.out.println(r.id + " " + r.name + " " + g);
            listAllEmployeesR(r.right);
        }
    }

    public static void listEmployeesInRange(int minID, int maxID) {
        boolean e = false; // Tracks if employees were found

        e = listEmployeesInRange(root, minID, maxID, e);

        if (!e) {
            System.out.println("No record found.");
        }
    }

    // Recursive function to list employees within a specified range in the binary search tree
    private static boolean listEmployeesInRange(Employee r, int minID, int maxID, boolean e) {
        if (r != null) {
            if (r.id >= minID) {
                e = listEmployeesInRange(r.left, minID, maxID, e);
            }

            if (r.id >= minID && r.id <= maxID) {
                String g = r.gender ? "Male" : "Female";
                System.out.println(r.id + " " + r.name + " " + g);
                e = true; // Set the boolean to true if an employee is found
            }

            if (r.id <= maxID) {
                e = listEmployeesInRange(r.right, minID, maxID, e);
            }
        }

        return e;
    }
}
