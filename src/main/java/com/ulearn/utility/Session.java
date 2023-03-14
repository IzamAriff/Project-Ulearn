package com.ulearn.utility;
import com.ulearn.main.*;

public class Session {

    private String scheduleID;
    private String location;
    private Student[] Students;
    private Lecturer lecturer;
    private Course course;


    public
    public void setDate(Date) {
        this.date = date;
    }

    public void getSchedule() {
        System.out.println("Class: " + scheduleID);
        System.out.println("Date: " + date.printDate());
        System.out.println("Location: " + location);
        System.out.println("Lecturer: " + lecturer);
    }
}