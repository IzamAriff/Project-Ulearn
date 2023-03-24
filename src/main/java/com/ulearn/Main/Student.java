package com.ulearn.Main;
import com.ulearn.Utility.Semester;

public class Student extends Person {
    
    //attributes
    private String programme;
    private Course[] course;
    private Semester semester;
    
    //constructor: assigning values to attributes
    public Student(String name, String id, int age, String ic, String department, String email,
                                Course[] course, String programme, Semester semester) {
        
        // call the constructor of the Person class using 'super'
        super(name, id, age, ic, department, email);
        this.course = course;
        this.programme = programme;
        this.semester = semester; 
    }
    //constructor: simple data types attributes
    public Student(String name, String id, int age, String ic, String department, String email,
                                                                                String programme) {
        
        // call the constructor of the Person class using 'super'
        super(name, id, age, ic, department, email); 
        this.programme = programme;
    }

    public Student() {
        super();
    }

    public static void main(String args[]) {
    }
    public void setCourse(Course[] course) {
        this.course = course;
    }

    public Course[] getCourse() {
        return course;
    }

    public void setProgramme(String programe) {
        this.programme = programme;
    }
    
    public String getProgramme() {
        return programme;
    }
}
