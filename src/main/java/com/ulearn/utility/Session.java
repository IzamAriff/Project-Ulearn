package com.ulearn.utility;
import java.util.Date;
import com.ulearn.main.*;

public class Session {

    private String scheduleID;
    private String location;
    private Student[] Students;
    private Lecturer lecturer;
    private Course course;
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public void getSchedule() {
        System.out.println("Class: " + scheduleID);
        System.out.println("Date: " + date);
        System.out.println("Location: " + location);
        System.out.println("Lecturer: " + lecturer.getName());
    }
}
