package org.hajorda;

import java.util.Scanner;

public class Student {
    private int ID;
    private String Name;
    private double grade1, grade2, grade3;
    private double average_grade = grade1 * 0.3 + grade2 * 0.2 + grade3 * 0.5;
    private int rank;

    public Student(){
        average_grade = grade1 * 0.3 + grade2 * 0.2 + grade3 * 0.5;
    }
    public int getID() {
        return ID;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getAverage_grade() {
        return average_grade;
    }

    public void setAverage_grade(double average_grade) {
        this.average_grade = average_grade;
    }

    public void setID(int ID) {
        this.ID = ID;
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

}
