package com.ulearn.Utility;

import com.ulearn.Main.Course;
import com.ulearn.Main.Lecturer;
import com.ulearn.Main.Student;
import java.util.Date;

public class Schedule {

  // attributes
  private Session[] sessions;

  // constructor
  public Schedule(Session[] sessions) {
    this.sessions = sessions;
  }

  // getter and setter
  public Session[] getSessions() {
    return sessions;
  }

  public void setSessions(Session[] sessions) {
    this.sessions = sessions;
  }

  // method
  public void viewSchedule() {
    System.out.println("Schedule:");
    for (int i = 0; i < sessions.length; i++) {
      sessions[i].getSchedule();
      System.out.println("Course:");
      sessions[i].displayCourseInfo();
      System.out.println();
    }
  }
  public static class Main {

    public static void main(String[] args) {
      Student[] students = { new Student("John", "Doe", "jd123"), new Student("Jane", "Doe", "jd456") };
      Lecturer lecturer = new Lecturer("Dr. Smith", "123456");
      Course course = new Course("Introduction to Java Programming", "CS101", 3, "An introduction to programming in Java.");
      Session[] sessions = { new Session("CS101-001", "Room 101", students, lecturer, course, new Date(2023, 3, 5)),
              new Session("CS101-002", "Room 102", students, lecturer, course, new Date(2023, 3, 6)) };
      Schedule schedule = new Schedule(sessions);
      schedule.viewSchedule();


    }

  }

}
