package com.ulearn.main;
import com.ulearn.utility.S;

import java.util.Scanner;

public class Lecturer extends Person {
    
    private Office office;
    private Session[] session;
    private String phoneNum;
    
    //constructor: assigning values to attributes
    public Lecturer(String name, String id, int age, String ic, String department,
                    Office office, ArrayList<Session> session) {
        
        // call the constructor of the Person class using 'super'
        super(name, id, age, ic, department); 
        this.office = office;
        this.session = session;
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
        this.session = session;
    }
    
    public ArrayList<Session> getSession() {
        return session;
    }
    
    public void createLecturer() {
        System.out.println("----------Lecturer's Details----------");
        Lecturer lec = new Lecturer();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name of lecturer: ");
        Name name = lec.getName();
        setName(name);

        System.out.print("Office room: ");
        String officeAddr = scanner.next();
        setOfficeAddr(officeAddr);

        System.out.print("Office number: ");
        String officeNum = scanner.next();
        setOfficeNum(officeNum);

        System.out.print("Lecturer's phone number: ");
        String phoneNum = scanner.next();
        setPhoneNum(phoneNum);

        System.out.print("Lecturer's email: ");
        String email = scanner.next();
        setEmail(email);

        scanner.close();

        System.out.println("Lecturer's details created successfully.");

    }

    public void displayLecturer() {
        System.out.println("Name: " + this.name);
        System.out.println("Office room: " + this.officeAddr);
        System.out.println("office number: " + this.officeNum);
        System.out.println("Phone number: " + this.phoneNum);
        System.out.println("Email: " + this.email);
    }

    public static void main(String[] args) {
        Lecturer lecturer = new Lecturer();
        lecturer.createLecturer();
        lecturer.displayLecturer();
    }
}
