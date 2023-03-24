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
