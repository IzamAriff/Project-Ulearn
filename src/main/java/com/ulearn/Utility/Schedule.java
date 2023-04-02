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
 

}
