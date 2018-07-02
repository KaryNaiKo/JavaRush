package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        if (students != null) {
            for (int i = 0; i < students.size(); i++) {
                if(students.get(i).getAverageGrade() == averageGrade) return students.get(i);
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        if(students != null){
            Student student = students.get(0);

            for (int i = 1; i < students.size(); i++) {
                if(students.get(i).getAverageGrade() > student.getAverageGrade()) student = students.get(i);
            }
            return student;
        }

        return null;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        if(students != null){
            Student student = students.get(0);

            for (int i = 1; i < students.size(); i++) {
                if(students.get(i).getAverageGrade() < student.getAverageGrade()) student = students.get(i);
            }
            return student;
        }
        return null;
    }

    public void expel(Student student) {
        if(students != null){
            students.remove(student);
        }

    }
}