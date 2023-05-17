package org.hajorda;



public class  SLinkedList {

    private static int size; // size of double linkedlist
    private static Node head;



    public SLinkedList() {
        size=0;
        head = null;

    }


    //Getters and Setters methods
    public int getSize() {
        return size;
    }

    public void  setSize(int size) {
        this.size = size;
    }

    public Node  getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }




    public static void add(Node n) {

        if(head==null) {
            //If head is null, this method adds to head
            head = n;
            head.setPrevious(null);
            head.setNext(null);
            size++;
            setRanks();

        }else {

            Node current = head;
            do {
                if(current.getElement().getAverage_grade() < n.getElement().getAverage_grade()) {
                    if(head == current) {
                        n.setNext(head);
                        n.setPrevious(null);
                        head.setPrevious(n);
                        head=n;
                    }
                    else {
                        n.setNext(current);
                        n.setPrevious(current.getPrevious());
                        current.setPrevious(n);
                    }
                    size++;
                    setRanks();
                    return;


                }
                else if(current.getNext()==null) {
                    current.setNext(n);
                    n.setPrevious(current);
                    size++;
                    setRanks();
                    return;
                }

                current = current.getNext();


            } while (true);




        }
    }


    private static void setRanks() {

        int rank=1;
        Node current = head;
        while(current != null) {
            current.getElement().setRank(rank);
            rank++;

            current = current.getNext();

        }
    }





    public static void remove(Student n) {

        Node current = head;
        while(true) {
            if(head==null) {
                return;
            }

            if(current.getElement() == n) {

                if(n == head.getElement()) {
                    if(current.getNext()!=null) {
                        head = current.getNext();
                        current.getNext().setPrevious(null);
                        current.setPrevious(null);
                        current.setNext(null);// I set these values null because of safety
                    }else {
                        head=null;
                    }

                }else if(current.getNext() ==null) {
                    current.getPrevious().setNext(current.getNext());
                    current.setPrevious(null);
                    current.setNext(null);// I set these values null because of safety

                }
                else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    current.setPrevious(null);
                    current.setNext(null);// I set these values null because of safety

                }
                System.out.println(current.getElement().getName()+"'s ID was "+current.getElement().getID()+".His grades were "+current.getElement().getGrade1()+", "+current.getElement().getGrade2()+" and "+current.getElement().getGrade3()+". He was ranked "+current.getElement().getRank()+" in the class.");
                setRanks();
                size--;
                return;
            }

            current = current.getNext();
        }

    }




















}