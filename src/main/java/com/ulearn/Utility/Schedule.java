package com.ulearn.Utility;

public class Schedule {
  
  //attribute
  private Session[] session;
  
  //constructor
  private Schedule(Session[] session) {
    this.session = new Session[1];
  }
  
  //setter and getter
  public void setSession(Session[] session) {
    this.session = session;
  }
  
  public Session[] getSession() {
    return session;
  }
  
  //method
  public void viewSchedule(Session[] session) {
  }

}
