package com.ulearn.Utility;

import java.util.Date;
import com.ulearn.Main.*;

public class Session {

    private String scheduleID;
    private String location;
    private Student[] Students;
    private Lecturer lecturer;
    private Course course;
    private Date date;

    public Session(String scheduleID, String location, Student[] students, Lecturer lecturer, Course course, Date date) {
        this.scheduleID = scheduleID;
        this.location = location;
        Students = students;
        this.lecturer = lecturer;
        this.course = course;
        this.date = date;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void displayCourseInfo() {
        System.out.println("Course Info:- ");
        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Course ID: " + course.getCourseID());
        System.out.println("Lecturer: " + lecturer.getName());
        System.out.println("Credit Hours: " + course.getCreditHour());
        System.out.println("Description: " + course.getDescription());
    }
    public void getSchedule() {
        System.out.println("Class: " + scheduleID);
        System.out.println("Date: " + date);
        System.out.println("Location: " + location);
        System.out.println("Lecturer: " + lecturer.getName());
    }
    public static void main(String[] args) {
        // Create a sample course
        Lecturer lecturer = new Lecturer("John Doe", "johndoe@ulearn.com", "123456789");
        Course course = new Course("Introduction to Java", "COMP101", lecturer, 3, "A beginner's guide to Java");

        // Create a sample student
        Person studentInfo = new Person("Jane Doe", "janedoe@ulearn.com", "987654321");
        Student student = new Student(studentInfo, "S1001");

        // Create a sample session
        Date sessionDate = new Date();
        Session session = new Session("S1001-101", "Room 101", new Student[] { student }, lecturer, course, sessionDate);

        // Display the session details
        session.getSchedule();
        session.displayCourseInfo();

    }
}
