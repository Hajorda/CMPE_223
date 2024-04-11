package org.UndirectedGraph.GraphHMW2;
//This class contains Nodes features. Item the date that is stored and Next that is the pointer for the next item. Also there is a first
// and last varibles when you add something you add from the last and the last is points nothing and also when you delete something you start deleting from first
public class Queue {
    private static Node first, last;

    private static class Node {
        int item;
        Node next;
    }

    // Method that checks the is Queue empty or not. It will look first because when you add something to Queue you will start by adding to first.
    public  boolean isEmpty() {
        return first == null;
    }

    //Enqueue method using for an adding item to Queue. Method will take an String after that it will create a node and it equating this node the current last after that it will equating last to our input
    //After that it will check the list empty if is no it will adjust the old last item's next item as a new last aka our input.
    //Generall idea is the when you add an item in queue it will add opposite side.
    public  void enqueue(int item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
    }

    //Dequeue method using for deleting items from Queue when you delete something it replace first item as a second item. And there is also protection for when there is no item to wipe it will automaticly replace first item to null
    //Also every time it wipe an item it also return that item.
    public  int dequeue() {
        int item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

}
