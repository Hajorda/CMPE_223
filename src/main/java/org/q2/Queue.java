package org.q2;

public class Queue {
        private static Node first, last;
        private static class Node
        {
            String item;
            Node next;
        }
        public static boolean isEmpty()
        { return first == null; }

        public static void enqueue(String item)
        {
            Node oldlast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()) first = last;
            else oldlast.next = last;
        }
        public static String dequeue()
        {
            String item = first.item;
            first = first.next;
            if (isEmpty()) last = null;
            return item;
        }

}
