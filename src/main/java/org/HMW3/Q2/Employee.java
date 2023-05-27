package org.HMW3.Q2;

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

class binarySearchTreeEmployee {
    private static Employee root;

    public binarySearchTreeEmployee() {
        root = null;
    }

    public static void insertEmployee(int id, String name, boolean gender) {
        root = insertEmployeeR(root, new Employee(id, name, gender));
    }

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
        boolean e = false; // track's if employees were found

        e = listEmployeesInRange(root, minID, maxID, e);

        if (!e) {
            System.out.println("No record found.");
        }

    }

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


