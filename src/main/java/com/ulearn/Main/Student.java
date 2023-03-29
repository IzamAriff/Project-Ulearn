package com.ulearn.Main;
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

    public Student(ArrayList<Course> course) {
        this.course = course;
    }

    public Student() {
        super();
    }



    public static void main(String args[]) {
    }
    public void setCourse(ArrayList<Course> course) {
        this.course = course;
    }

    public ArrayList<Course> getCourse() {
        return course;
    }

    public void setProgramme(String programe) {
        this.programme = programme;
    }
    
    public String getProgramme() {
        return programme;
    }
}
