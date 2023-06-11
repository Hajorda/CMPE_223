package org.HMW4;

import org.HMW3.FamilyTree;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static class Book {
        private String name;
        private String author;
        private int count;
        private MaxPQ<Customer> tree;

        public Book(String name, String author, int count) {
            this.name = name;
            this.author = author;
            this.count = count;
            tree = new MaxPQ<>();
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Book(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class Customer implements Comparable<Customer> {
        int rYear;
        String name;
        int rDate;
        int rDay;
        int temp = -1;
        String book;

        public Customer(int rYear, String name, int rDate, int rDay) {
            this.rYear = rYear;
            this.name = name;
            this.rDate = rDate;
            this.rDay = rDay;
        }

        @Override
        public int compareTo(@NotNull Main.Customer o) {
            if (rDate == o.rDate) {
                //1200 IQ
                return Integer.compare(o.rYear, rYear);
            }
            return Integer.compare(rDate, o.rDate);
        }
    }

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Integer> days = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Customer> bGiven = new ArrayList<>();

    public static Book bookSearch(String name) {
        for (Book book : books) {
            if (book.name.equalsIgnoreCase(name)) {
                return book;
            }
        }
        System.out.println("ZORT");
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter filename:");
        Scanner is = new Scanner(System.in);
        String fileName = is.nextLine();

        File file = new File("log1.txt");
        Scanner sc = new Scanner(file);

        MaxPQ tc = new MaxPQ<>();

        int current = 0;
        while (sc.hasNextLine()) {

            String s = sc.nextLine();

            if (s.equalsIgnoreCase("***BOOK INFO**")) {
                current = 1;
                s = sc.nextLine();
            }

            if (s.equalsIgnoreCase("**DAY INFO**")) {
                current = 2;
                s = sc.nextLine();
            }

            if (s.equalsIgnoreCase("***CUSTOMER INFO***")) {
                current = 3;
                s = sc.nextLine();
            }


            if (current == 1) {
                String[] l = s.split(",");
                Book n = new Book(l[1], l[0], Integer.parseInt(l[2]));
                System.out.println(l[1]);
                books.add(n);
            } else if (current == 2) {
                days.add(Integer.parseInt(s));
            } else if (current == 3) {
                String[] l = s.split(",");
                Customer c = new Customer(Integer.parseInt(l[0]), l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]));
                c.book = l[4];
                System.out.println("Ara" + l[4]);
                bookSearch(l[4]).tree.insert(c);
                System.out.println(l[1]);
            }


        }


        for (int day = 1; day < 31; day++) {

            for (int i = 0; i < bGiven.size(); i++) {
                System.out.println(bGiven.get(i).book+bGiven.get(i).name+" bakılıyor ee"+bGiven.size()+",,,"+i);
                if (bGiven.get(i).temp <= day) {
                    System.out.println(bGiven.get(i).book+bGiven.get(i).name+"verrrr");
                    bookSearch(bGiven.get(i).book).count++;
                    bGiven.remove(i);
                    i = i-1;
                }
            }

            ArrayList<Customer> waiting = new ArrayList<>();

            for (int i = 0; i < books.size(); i++) {


                MaxPQ tt = new MaxPQ();

                while (!books.get(i).tree.isEmpty()){
                    Customer t = books.get(i).tree.max();
                    System.out.println(books.get(i).tree.max().name+" ,,"+i);
                    if (t.rDate == day && books.get(i).count > 0) {
                        System.out.println(t.name + "verdim"+t.rDate);
                        books.get(i).count--;
                        t.temp = t.rDate + t.rDay +1;
                        bGiven.add(t);
                    } else if (t.rDate <= day && books.get(i).count > 0) {
                        System.out.println("BOK");
                        books.get(i).count--;
                        t.temp = day + t.rDay;
                        bGiven.add(t);
                        waiting.remove(t);
                    } else if (t.rDate <= day && books.get(i).count <= 0) {
                        tt.insert(t);
                        waiting.add(t);
                    }
                    else {
                        tt.insert(books.get(i).tree.max());
                    }

                    books.get(i).tree.delMax();
                }
                books.get(i).tree = tt;
//                for (int a = 0; a < books.get(i).tree.size(); a++) {
//                    Customer tempCustomer = books.get(i).tree.max();
//                    System.out.println("Loopdayım" + a);
//                    if (tempCustomer.rDate == day && books.get(i).count > 0) {
//                        books.get(i).count--;
//                        tempCustomer.temp = tempCustomer.rDate + tempCustomer.rDay;
//                        bGiven.add(tempCustomer);
//                        books.get(i).tree.delMax();
//                    } else if (tempCustomer.rDate <= day && books.get(i).count > 0) {
//                        books.get(i).count--;
//                        tempCustomer.temp = day + tempCustomer.rDay;
//                        bGiven.add(tempCustomer);
//                        waiting.remove(tempCustomer);
//                        books.get(i).tree.delMax();
//                    } else if (tempCustomer.rDate <= day && books.get(i).count <= 0) {
//                        tt.insert(tempCustomer);
//                        waiting.add(tempCustomer);
//
//                    } else {
//                        tt.insert(tempCustomer);
//                    }
//                    try {
//                        books.get(i).tree.delMax();
//                    } catch (Exception e) {
//                        System.out.println(e);
//                    }
//                }
//                books.get(i).tree = tt;

//                while (true) {
//                    Customer temp = books.get(i).tree.max();
//                    if (temp.rDate == day && books.get(i).count > 0) {
//                        books.get(i).count--;
//                        temp.temp = temp.rDate + temp.rDay;
//                        bGiven.add(temp);
//                        books.get(i).tree.delMax();
//                    } else if (temp.rDate <= day && books.get(i).count > 0) {
//                        books.get(i).count--;
//                        temp.temp = day + temp.rDay;
//                        bGiven.add(temp);
//                        books.get(i).tree.delMax();
//                    } else break;
//                }
         }

            if (days.contains(day)) {
                System.out.println("Day " + day + ":");
                System.out.println("Customer info:");
                for (Customer cus : waiting) {
                    System.out.println(cus.name + " waits " + cus.book + " since day " + cus.rDate);
                }
                System.out.println("Book info:");
                for (Book book : books) {
                    System.out.println(book.author + "," + book.name + "," + book.count);
                }
            } else
                System.out.println(day + " Boş gündü\n--------------------------------");
        }
    }
}