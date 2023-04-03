package com.ulearn.Utility;

import com.ulearn.Main.Course;
import com.ulearn.Main.Lecturer;
import com.ulearn.Main.Student;

import java.time.LocalDate;
import java.util.Date;

public class Session {

    private String scheduleID;
    private String location;
    private Student[] Students;
    private Lecturer lecturer;
    private Course course;
    private Date date;
    private LocalDate d;
    private String assignmentName;
    private String assignmentDescription;

    //constructor for creating a session, especially accessible to those of lecturer
    public Session(String scheduleID, String location, Student[] students, Lecturer lecturer, Course course, Date date) {
        this.scheduleID = scheduleID;
        this.location = location;
        Students = students;
        this.lecturer = lecturer;
        this.course = course;
        this.date = date;
    }

    //this is a borrowed constructor, as it is for creating an info for a assignment, and also accessible to those of lecturer
    public Session(String assignmentName, String assignmentDescription, LocalDate dueDate) {
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
    }

    public Session(String location, Course course, Date date) {
        this.location = location;
        this.course = course;
        this.date = date;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Student[] getStudents() {
        return Students;
    }

    public void setStudents(Student[] students) {
        Students = students;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void getSchedule() {
        System.out.println("Class: " + scheduleID);
        System.out.println("Date: " + date);
        System.out.println("Location: " + location);
        System.out.println("Lecturer: " + lecturer.getName());
    }

}
