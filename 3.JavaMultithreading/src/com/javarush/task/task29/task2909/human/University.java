package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students;
    private int age;
    private String name;

    public University( String name,int age) {
        this.age = age;
        this.name = name;
        students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student: students) {
            if (student.getAverageGrade()==averageGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student studentMax = students.get(0);
        for (Student student: students) {
            if (student.getAverageGrade()>studentMax.getAverageGrade())
                studentMax = student;
        }
        return studentMax;
    }public Student getStudentWithMinAverageGrade() {
        Student studentMin = students.get(0);
        for (Student student: students) {
            if (student.getAverageGrade()<studentMin.getAverageGrade())
                studentMin = student;
        }
        return studentMin;
    }
    public void expel(Student student){
        students.remove(student);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}