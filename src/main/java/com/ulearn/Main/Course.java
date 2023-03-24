package com.ulearn.Main;

public abstract class Course {

//izam hensem memek
    //attribute
    protected String courseName;
    protected String courseID;
    protected Lecturer lecturer; //courseName, office, phoneNum
    protected boolean freeTrialAvailable;
    protected double courseFee;
    protected String feedback;
    protected int creditHour;
    protected String description;

    //constructor
    public Course(String courseName, String courseID, Lecturer lecturer, int creditHour, String description) {
        this.courseID = courseID;
        this.creditHour = creditHour;
        this.courseName = courseName;
        this.description = description;
        this.lecturer = lecturer;
    }

    public Course(String courseName, boolean freeTrialAvailable, double courseFee) {
        this.courseName = courseName;
        this.freeTrialAvailable = freeTrialAvailable;
        this.courseFee = courseFee;
    }
    
    public String getcourseName() {
        return courseName;
    }

    public void setcourseName(String courseName) {
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

    public void getLectureCourse(String courseName, String courseID, String description) { //courseID is just using the index of the array 

    }

    public void getStudentCourse(String courseName, String courseID, Lecturer lecturer, String creditHour, String description) {

    }
}
