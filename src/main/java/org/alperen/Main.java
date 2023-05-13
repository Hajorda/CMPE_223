package org.alperen;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Dog ali = new Dog();
        System.out.println("Programa hoşgeldiniz");
        System.out.println("Lütfen köpek bilgileri girin:");
        String input_name = in.nextLine();
        System.out.println("köpek yaşı gir:");
        int input_age = in.nextInt();
        in.nextLine();
        System.out.println("ırk gir oc:");
        String input_breed = in.nextLine();
         ali.setAge(input_age);
         ali.setName(input_name);
         ali.setBreed(input_breed);
        System.out.println("Senin köpeğin adı: " + ali.getName());
        System.out.println("Senin köpeğin yaşı: " + ali.getAge());
        System.out.println("Senin köpeğin cinsi: " + ali.getBreed());
    }}












