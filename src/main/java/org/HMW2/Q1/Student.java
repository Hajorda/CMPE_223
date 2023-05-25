package org.HMW2.Q1;

import org.jetbrains.annotations.NotNull;
//------------------------------------------
// Title: Student class
// Author: Ali Bolat
// ID: 35485311594
// Section: 3
// Assignment: 2
// Description: General fetaures of student
// -----------------------------------------
public class Student implements Comparable<Student> {
    private String name;
    private long id;
    private int semesterNo;

    //Constructer for easy student set up
    public Student(String name, long id, int semesterNo) {
        this.name = name;
        this.id = id;
        this.semesterNo = semesterNo;
    }
//For writeing student objects
    @Override
    public String toString() {
        return id+": "+name+" "+semesterNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSemesterNo() {
        return semesterNo;
    }

    public void setSemesterNo(int semesterNo) {
        this.semesterNo = semesterNo;
    }

    //Compering the student's acording to the pdf
    @Override
    public int compareTo(@NotNull Student o) {

        int idComparison = Long.compare(this.id, o.id);
        if (idComparison != 0) {
            return idComparison;
        }

        int semesterComparison = Integer.compare(this.semesterNo, o.semesterNo);
        if (semesterComparison != 0) {
            return semesterComparison;
        }

        return this.name.compareTo(o.name);
    }
}
