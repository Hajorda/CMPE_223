package org.HMW3.Q2;

import java.util.*;

class Employee {
    int id;
    String name;
    boolean gender;
    Employee left, right;

    public Employee(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        left = right = null;
    }
}

class EmployeeDatabase {
    private Employee root;

    public EmployeeDatabase() {
        root = null;
    }

    public void insertEmployee(int id, String name, boolean gender) {
        root = insertEmployeeRecursive(root, id, name, gender);
    }

    private Employee insertEmployeeRecursive(Employee root, int id, String name, boolean gender) {
        if (root == null) {
            root = new Employee(id, name, gender);
            return root;
        }

        if (id < root.id)
            root.left = insertEmployeeRecursive(root.left, id, name, gender);
        else if (id > root.id)
            root.right = insertEmployeeRecursive(root.right, id, name, gender);

        return root;
    }

    public void deleteEmployee(int id) {
        root = deleteEmployeeRecursive(root, id);
    }

    private Employee deleteEmployeeRecursive(Employee root, int id) {
        if (root == null)
            return root;

        if (id < root.id)
            root.left = deleteEmployeeRecursive(root.left, id);
        else if (id > root.id)
            root.right = deleteEmployeeRecursive(root.right, id);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.id = getMinimumID(root.right);
            root.right = deleteEmployeeRecursive(root.right, root.id);
        }

        return root;
    }

    private int getMinimumID(Employee root) {
        int minID = root.id;
        while (root.left != null) {
            minID = root.left.id;
            root = root.left;
        }
        return minID;
    }

    public void searchEmployee(int id) {
        searchEmployeeRecursive(root, id);
    }

    private void searchEmployeeRecursive(Employee root, int id) {
        if (root == null) {
            System.out.println("Record not found");
            return;
        }

        if (id == root.id) {
            System.out.println("ID: " + root.id + ", Name: " + root.name + ", Gender: " + (root.gender ? "Female" : "Male"));
        } else if (id < root.id) {
            searchEmployeeRecursive(root.left, id);
        } else {
            searchEmployeeRecursive(root.right, id);
        }
    }

    public void listAllEmployees() {
        listAllEmployeesRecursive(root);
    }

    private void listAllEmployeesRecursive(Employee root) {
        if (root != null) {
            listAllEmployeesRecursive(root.left);
            System.out.println("ID: " + root.id + ", Name: " + root.name + ", Gender: " + (root.gender ? "Female" : "Male"));
            listAllEmployeesRecursive(root.right);
        }
    }

    public void listEmployeesInRange(int minID, int maxID) {
        listEmployeesInRangeRecursive(root, minID, maxID);
    }

    private void listEmployeesInRangeRecursive(Employee root, int minID, int maxID) {
        if (root != null) {
            if (root.id >= minID)
                listEmployeesInRangeRecursive(root.left, minID, maxID);

            if (root.id >= minID && root.id <= maxID)
                System.out.println("ID: " + root.id + ", Name: " + root.name + ", Gender: " + (root.gender ? "Female" : "Male"));

            if (root.id <= maxID)
                listEmployeesInRangeRecursive(root.right, minID, maxID);
        }
    }
}


