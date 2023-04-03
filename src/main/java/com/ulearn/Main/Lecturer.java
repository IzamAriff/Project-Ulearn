package com.ulearn.Main;

import com.ulearn.Utility.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Lecturer extends User {
    
    private Office office;
    private ArrayList<Session> sessions = new ArrayList<>();
    private String phoneNum;
    private ArrayList<Course> course;
    
    //constructor: assigning values to attributes


    public Lecturer(String name, String email, String password) {
        super(name, email, password);
    }

    public Lecturer(String name) {
        super(name);
    }

    public Lecturer(String id, int age, String ic, String department, String phoneNum) {
        super(id, age, ic, department);
        this.phoneNum = phoneNum;
    }

    public Lecturer(String name, String email, String password, int age, String id,  String ic, String department, String phoneNum) {
        super(name, id, age, ic, department, email, password);
        this.phoneNum = phoneNum;
    }

    public Lecturer(Office office) {
        this.office = office;
    }

    public Lecturer() {
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }
    
    public void setOffice(Office office) {
        this.office = office;
    }
    
    public Office getOffice() {
        return office;
    }
    
    public void setSession(ArrayList<Session> session) {
        this.sessions = session;
    }
    
    public void createLecturer() {
        System.out.println("Lecturer's Details:");
        Lecturer lec = new Lecturer();
        Scanner input = new Scanner(System.in);

        System.out.print("Name of lecturer: ");
        String name = input.nextLine();
        lec.setName(name);

        System.out.print("Office Block: ");
        String block = input.nextLine();
        System.out.print("Office Level: ");
        String level = input.nextLine();
        System.out.print("Office Room: ");
        String room = input.nextLine();
        Office office = new Office(block, level, room);

        System.out.print("Office number: ");
        phoneNum = input.nextLine();
        lec.setPhoneNum(phoneNum);

        System.out.print("Lecturer's email: ");
        String email = input.next();
        lec.setEmail(email);

        input.close();

        System.out.println("Lecturer's details created successfully.");

    }

    public void displayLecturer() {
        System.out.println("Name: " + this.name);
        System.out.println("Office room: " + this.office);
        System.out.println("office number: " + this.phoneNum);
        System.out.println("Email: " + this.email);
    }

    public static void main(String[] args) {
        Lecturer lecturer = new Lecturer();
        lecturer.createLecturer();
        lecturer.displayLecturer();
    }

    public ArrayList<Course> getCourses() {
        return course;
    }

    public void addSession(String l, Course c, Date d, int i) {
        sessions.add(i, new Session(l, c, d));
    }

    public ArrayList<Session> getSession(int i) {
        return sessions;
    }

    public void deleteSession(Session session) {
        sessions.remove(session);
    }

}
