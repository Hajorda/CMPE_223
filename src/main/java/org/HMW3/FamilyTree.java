//-----------------------------------------------------
// Title: FamilyTree Class
// Author: Ali Bolat
// ID: 35485311597
// Section: 3
// Assignment: 3
// Description: This class root For tree Structure inside if there is a Node class it's every cell for the tree structure. This class basically create's new nodes,searches and inserts it. Also print's some information.
//-----------------------------------------------------
package org.HMW3;

import java.util.ArrayList;

public class FamilyTree {

    // Node for the Tree
    static class Node {
        String name;
        int id;
        Node up;
        ArrayList<Node> down;

        // Constructor for the node
        public Node(String name, int id) {
            this.name = name;
            this.up = null;
            this.down = null;
            this.id = id;
            this.down = new ArrayList<Node>();
        }
    }
    static Node root;

    // Method to search for a node with given name and id
    private static Node searchNode(Node currentNode, String name, int id) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.name.equals(name) && currentNode.id == id) {
            return currentNode;
        }
        // Recursively search in the down subtrees
        if (currentNode.down != null) {
            for (int i = 0; i < currentNode.down.size(); i++) {
                Node foundNode = searchNode(currentNode.down.get(i), name, id);
                if (foundNode != null) {
                    return foundNode;
                }
            }
        }
        return null; // Node not found
    }

    // Method to search for a node with given id
    private static Node searchNode(Node currentNode, int id) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.id == id) {
            return currentNode;
        }
        // Recursively search in the down subtrees
        if (currentNode.down != null) {
            for (int i = 0; i < currentNode.down.size(); i++) {
                Node foundNode = searchNode(currentNode.down.get(i), id);
                if (foundNode != null) {
                    return foundNode;
                }
            }
        }
        return null; // Node not found
    }

    // Method to insert a parent-child relationship into the FamilyTree
    public static void insert(String parentName, int parentId, String childName, int childId) {
        if (root == null) {
            Node parent = new Node(parentName, parentId);
            Node child = new Node(childName, childId);
            child.up = parent;
            parent.down.add(child);
            root = parent;
            return;
        }
        Node parent = searchNode(root, parentName, parentId);
        if (parent == null) {
            System.out.println("YETİM"); // Orphan node, parent not found
            return;
        }
        Node child = new Node(childName, childId);
        child.up = parent;
        parent.down.add(child);
    }

    // Method to check if id1 is an ancestor of id2
    public static boolean checkAncestor(int id1, int id2) {
        Node c = searchNode(root, id2);
        for (int i = 0; i < searchNode(root, id1).down.size(); i++) {
            if (searchNode(root, id1).down.get(i).equals(c)) {
                return true;
            }
        }
        return false;
    }

    // Method to check if id2 is a descendant of id1
    public static boolean checkDescentdant(int id2, int id1) {
        Node c = searchNode(root, id2);
        for (int i = 0; i < searchNode(root, id1).down.size(); i++) {
            if (searchNode(root, id1).down.get(i).equals(c)) {
                return true;
            }
        }
        return false;
    }

    // Method to print all descendants of a node with the given id
    public static void printAllDescendants(int id) {
        Node node = searchNode(root, id);
        if (node != null) {
            printDescendants(node);
        }
        System.out.println("");
    }

    // Recursive method to print descendants of a node
    private static void printDescendants(Node node) {
        for (int i = 0; i < node.down.size(); i++) {
            if (i == 0) {
                System.out.print(node.down.get(i).name);
            } else {
                System.out.print("," + node.down.get(i).name);
                printDescendants(node.down.get(i));
            }
        }
    }

    // Method to check if id1 and id2 are siblings
    public static boolean checkSibling(int id1, int id2) {
        Node node1 = searchNode(root, id1);
        Node node2 = searchNode(root, id2);

        if (node1 != null && node2 != null && node1.up == node2.up) {
            return true;
        }

        return false;
    }

    // Method to find the first oldest common relative of id1 and id2
    public static void findFirstOldestCommonRelative(int id1, int id2) {
        Node node1 = searchNode(root, id1);
        Node node2 = searchNode(root, id2);

        if (node1 != null && node2 != null) {
            ArrayList<Node> ancestors1 = getAncestors(node1);
            ArrayList<Node> ancestors2 = getAncestors(node2);

            if (ancestors1.isEmpty() || ancestors2.isEmpty()) {
                System.out.println("ZORT Anecestors boş"); // Ancestor lists are empty
                return;
            }

            for (Node ancestor1 : ancestors1) {
                for (Node ancestor2 : ancestors2) {
                    if (ancestor1.name.equals(ancestor2.name) && !ancestor1.equals(node2) && !ancestor2.equals(node1)) {
                        System.out.println(ancestor1.name); // Found common relative
                        return;
                    }
                }
            }
        }

        System.out.println("No common relative found."); // No common relative found
    }

    // Method to retrieve the ancestors of a node
    private static ArrayList<Node> getAncestors(Node node) {
        ArrayList<Node> ancestors = new ArrayList<>();
        Node current = node.up;

        while (current != null) {
            ancestors.add(current);
            current = current.up;
        }

        return ancestors;
    }
}
