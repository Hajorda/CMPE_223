package org.Q1;
//-----------------------------------------------------
// Title: Stack Class
// Author: Ali Bolat
// ID: 35485311594
// Section: 3
// Assignment: 1
// Description: Student class. It contains students features methods and informations.
//-----------------------------------------------------
public class Student {

    //Student's features

    private int ID,rank;
    private String Name;
    private double grade1,grade2,grade3;
    private double average_grade; // I added this variable as an additionally



    //Constructor class for Student class. It used for creating students. It takes several varibles and it equilze to the class's varibles.
    public Student(int iD, String name, double grade1, double grade2, double grade3) {

        ID = iD;
        Name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.average_grade = grade1*0.3+grade2*0.2+grade3*0.5;
    }


    // Getters and Setters methods
    public int getID() {
        return ID;
    }



    public void setID(int iD) {
        ID = iD;
    }


    public String getName() {
        return Name;
    }



    public void setName(String name) {
        Name = name;
    }



    public double getGrade1() {
        return grade1;
    }



    public void setGrade1(double grade1) {
        this.grade1 = grade1;
    }



    public double getGrade2() {
        return grade2;
    }



    public void setGrade2(double grade2) {
        this.grade2 = grade2;
    }



    public double getGrade3() {
        return grade3;
    }



    public void setGrade3(double grade3) {
        this.grade3 = grade3;
    }



    public double getAverage_grade() {
        return average_grade;
    }



    public void setAverage_grade(double average_grade) {
        this.average_grade = average_grade;
    }


    public int getRank() {
        return rank;
    }


    public void setRank(int rank) {
        this.rank = rank;
    }


    @Override
    public String toString() {

        return Name+"'s ID is "+ID+". His grades are "+grade1+", "+grade2+" and "+grade3+". He is ranked "+rank+" in the class.";
    }










}
