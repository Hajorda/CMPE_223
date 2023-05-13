package org.HMW2.Q1;

import org.jetbrains.annotations.NotNull;

public class Student implements Comparable<Student> {
    private String name;
    private long id;
    private int semesterNo;

    public Student(String name, long id, int semesterNo) {
        this.name = name;
        this.id = id;
        this.semesterNo = semesterNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", semesterNo=" + semesterNo +
                '}';
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
