package org.HMW3;

import java.util.ArrayList;

public class FamilyTree {

    //Node for the Tree
    static class Node {
        String name;
        int id;
        Node up;
        ArrayList<Node> down;

        //Constructor for the node
        public Node(String name, int id) {
            this.name = name;
            this.up = null;
            this.down = null;
            this.id = id;
            this.down = new ArrayList<Node>();
        }
    }

    private static Node searchNode(Node currentNode, String name, int id) {
        if (currentNode == null) {
            //   System.out.println("burda");
            return null;
        }
        if (currentNode.name.equals(name) && currentNode.id == id) {
            //  System.out.println("burda2");
            return currentNode;
        }
        // Recursively search in the down subtrees
        if (currentNode.down != null) {
            //  System.out.println("burda3");
            for (int i = 0; i < currentNode.down.size(); i++) {
                //System.out.println(i+" " + currentNode.down.get(i).name + " " + currentNode.down.get(i).id + " " + name + " " + id);
                Node foundNode = searchNode(currentNode.down.get(i), name, id);
                if (foundNode != null) {
                    return foundNode;
                }
            }
        }
        return null; // Node not found

    }

    private static Node searchNode(Node currentNode, int id) {
        if (currentNode == null) {
            // System.out.println("burda");
            return null;
        }
        if (currentNode.id == id) {
            //  System.out.println("burda2");
            return currentNode;
        }
        // Recursively search in the down subtrees
        if (currentNode.down != null) {
            // System.out.println("burda3");
            for (int i = 0; i < currentNode.down.size(); i++) {
                Node foundNode = searchNode(currentNode.down.get(i), id);
                if (foundNode != null) {
                    return foundNode;
                }
            }
        }
        return null; // Node not found

    }


    static Node root;


    public static void insert(String parentName, int parentId, String childName, int childId) {
        // System.out.println(root);
        if (root == null) {
            // System.out.println("Root eşitlendi ilk");
            Node parent = new Node(parentName, parentId);
            Node child = new Node(childName, childId);
            child.up = parent;
            parent.down.add(child);
            root = parent;
            return;
        }
        Node parent = searchNode(root, parentName, parentId);
        if (parent == null) {
            System.out.println("YETİM");
            return;
        }
        Node child = new Node(childName, childId);
        child.up = parent;
        parent.down.add(child);
        //System.out.println("Başarılı!");
    }


    public static boolean checkAncestor(int id1, int id2) {
        Node c = searchNode(root, id2);
        for (int i = 0; i < searchNode(root, id1).down.size(); i++) {
            if (searchNode(root, id1).down.get(i).equals(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDescentdant(int id2, int id1) {
        Node c = searchNode(root, id2);
        for (int i = 0; i < searchNode(root, id1).down.size(); i++) {
            if (searchNode(root, id1).down.get(i).equals(c)) {
                return true;
            }
        }

        return false;
    }

    public static void printAllDescendants(int id) {
        Node node = searchNode(root, id);
        if (node != null) {
            printDescendants(node);
        }
        System.out.println("");
    }

    //        private static void printDescendants(Node node) {
//
//        for (int i = 0 ; i < node.down.size() ; i++) {
//            System.out.print(","+node.down.get(i).name);
//            printDescendants(node.down.get(i));
//        }
//    }

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


//    private static void printDescendants(Node node) {
//        for (Node child : node.down) {
//            System.out.print(","+child.name);
//            printDescendants(child);
//        }
//    }

    public static boolean checkSibling(int id1, int id2) {
        Node node1 = searchNode(root, id1);
        Node node2 = searchNode(root, id2);

        if (node1 != null && node2 != null && node1.up == node2.up) {
            return true;
        }

        return false;
    }

    public static void findFirstOldestCommonRelative(int id1, int id2) {
        Node node1 = searchNode(root, id1);
        Node node2 = searchNode(root, id2);

        if (node1 != null && node2 != null) {
            ArrayList<Node> ancestors1 = getAncestors(node1);
            ArrayList<Node> ancestors2 = getAncestors(node2);

            if (ancestors1.isEmpty() || ancestors2.isEmpty()) {
                System.out.println("ZORT Anecestors boş");
                return;
            }

            for (Node ancestor1 : ancestors1) {
                for (Node ancestor2 : ancestors2) {
                    if (ancestor1.name.equals(ancestor2.name) && !ancestor1.equals(node2) && !ancestor2.equals(node1)) {
                        System.out.println(ancestor1.name);
                        return;
                    }
                }
            }
        }

        System.out.println("No common relative found.");
    }

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
