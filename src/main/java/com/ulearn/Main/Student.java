package com.ulearn.Main;

import com.ulearn.Subjects.DataStructuresAndAlgorithms;
import com.ulearn.Subjects.IntroductionToJava;
import com.ulearn.Utility.Semester;

import java.util.ArrayList;

public class Student extends User {
    
    //attributes
    private String programme;
    private ArrayList<Course> course = new ArrayList<>();
    private Semester semester;
    
    //constructor: assigning values to attributes


    public Student(String name, String email, String password) {
        super(name, email, password);
    }

    public Student( String id, int age, String ic, String department,
                    String studentProgramme) {
        super(id, age, ic, department);
        this.programme = studentProgramme;
    }

    public Student(String name, String email, String password, int age, String id,  String ic, String department, String programme) {
        super(name, id, age, ic, department, email, password);
        this.programme = programme;
    }

    public Student(ArrayList<Course> course) {
        this.course = course;
    }

    public Student() {
        super();
    }

    public void setCourse(ArrayList<Course> course) {
        this.course = course;
    }
    public ArrayList<Course> getCourse(int index) {
        return course.get(index);
    }
    public ArrayList<Course> getEnrolledCourses() {
        return course;
    }

    public String getCourseName() {
        if (course instanceof IntroductionToJava) {
            IntroductionToJava i = (IntroductionToJava) course;
            return i.getCourseName();
        } else if (course instanceof DataStructuresAndAlgorithms) {
            DataStructuresAndAlgorithms d = (DataStructuresAndAlgorithms) course;
            return d.getCourseName();
        } else {
            return "";
        }
    }

    public void setProgramme(String programe) {
        this.programme = programme;
    }
    
    public String getProgramme() {
        return programme;
    }

}
