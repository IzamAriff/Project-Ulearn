package com.ulearn.Main;

import java.util.ArrayList;

public abstract class Course extends ArrayList<Course> {

    //attribute
    protected String courseName;
    protected String courseID;
    protected String lecturer;
    protected boolean freeTrialAvailable;
    protected double courseFee;
    protected String feedback;
    protected int creditHour;
    protected String description;

    //constructor
    public Course(String courseName, String courseID, int creditHour, String description) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.creditHour = creditHour;
        this.description = description;
    }

    public Course(String courseName, String courseID, boolean freeTrialAvailable, double courseFee,
                  int creditHour, String lecturer, String description) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.freeTrialAvailable = freeTrialAvailable;
        this.courseFee = courseFee;
        this.creditHour = creditHour;
        this.lecturer = lecturer;
        this.description = description;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseLecturer() {
        return lecturer;
    }

    @Override
    public String toString() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFreeTrialAvailable() {
        return freeTrialAvailable;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void useFreeTrial() {
        if (freeTrialAvailable) {
            System.out.println("Congratulations! You have successfully used the free trial period.");
            freeTrialAvailable = false;
        } else {
            System.out.println("Sorry! The free trial period is not available for this course.");
        }
    }

    public abstract void makePayment(String paymentDetails);

    public abstract boolean hasNextModule();

    public abstract Module getNextModule();


}
