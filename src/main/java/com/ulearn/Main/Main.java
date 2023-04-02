package com.ulearn.Main;
import com.ulearn.Subjects.DataStructuresAndAlgorithms;
import com.ulearn.Subjects.IntroductionToJava;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

        Course course = null;
        String cName;
        String lName;

        //FRAME 1
        // User Registration
        System.out.println("Welcome to ULEARN!");
        System.out.println("Please provide the following details to log in.");
        System.out.print("Name: ");
        String userName = input.nextLine();
        System.out.print("Email: ");
        String userEmail = input.nextLine();
        System.out.print("Password: ");
        String userPassword = input.nextLine();

        users.add(new User(userName, userEmail, userPassword));
        //handles checking database
        //if wrong outputs error and head to register

        System.out.println("Please select a type of user from the list below.");
        System.out.println("1. Student");
        System.out.println("2. Lecturer");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();

        switch (choice) {

            case 1:

                //FRAME 2
                //User Profile Creation
                //Option 1: Student

                students.add(new Student(userName, userEmail, userPassword)); //passes the failed information to this
                System.out.println("Please continue create your profile.");
                System.out.print("Age: ");
                int userAge = input.nextInt();
                input.nextLine();
                String userID = Integer.toString(users.size());
                System.out.println("ID: " + userID); //created through index of user
                System.out.print("IC: ");
                String userIC = input.nextLine();
                System.out.print("Department: ");
                String userDept = input.nextLine();
                System.out.print("Programme: ");
                String studentProgramme = input.nextLine();

                students.add(new Student(userID, userAge, userIC, userDept, studentProgramme));

                // Course Selection and Enrollment
                System.out.println("Please select a course from the list below.");
                System.out.println("1. Introduction to Programming");
                System.out.println("2. Data Structures and Algorithms");
                System.out.print("Enter your choice: ");
                choice = input.nextInt();


                for (int i = 0; i < 2; i++) {

                    switch (choice) {
                        case 1:
                            courses.add(new IntroductionToJava());
                            break;
                        case 2:
                            courses.add(new DataStructuresAndAlgorithms());
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            return;
                    }

                }

                students.add(new Student(courses));

                System.out.println("You have selected the " + courses.get(0).getCourseName() + " Course!");
                System.out.println("Please enroll in the course.");
                System.out.print("Do you want to use the free trial period? (Y/N): ");
                String freeTrialChoice = input.next();
                if (freeTrialChoice.equalsIgnoreCase("Y")) {
                    courses.get(0).useFreeTrial();
                } else {
                    System.out.print("Please enter your payment details: ");
                    String paymentDetails = input.next();
                    courses.get(0).makePayment(paymentDetails);
                }

                System.out.println("Student Registration Completed: ");
                break;

            case 2:

                //Option 2: Lecturer

                int lindex=1; //lecturer index

                lecturers.add(new Lecturer(userName, userEmail, userPassword)); //passes the failed information to this
                System.out.println("Please continue create your profile.");
                System.out.print("Age: ");
                userAge = input.nextInt();
                input.nextLine();
                userID = Integer.toString(users.size());
                System.out.println("ID: " + userID); //created through index of user
                System.out.print("IC: ");
                userIC = input.nextLine();
                System.out.print("Department: ");
                userDept = input.nextLine();
                System.out.print("Phone Number: ");
                String lecturerPhoneNum = input.nextLine();

                lecturers.add(new Lecturer(userID, userAge, userIC, userDept, lecturerPhoneNum));

                System.out.println("Office Location:_ ");
                System.out.print("Block: ");
                String b = input.nextLine();
                System.out.print("Level: ");
                String l = input.nextLine();
                System.out.print("Room: ");
                String r = input.nextLine();

                Office office = new Office(b, l, r);
                lecturers.add(new Lecturer(office));
                lecturers.add(new Lecturer(courses));

                System.out.println("Lecturer Registration Completed!");

                System.out.println("Choose subject you will be teaching");

                System.out.println("1. Introduction to Programming");
                System.out.println("2. Data Structures and Algorithms");
                System.out.print("Enter your choice: ");
                int opt = input.nextInt();

                    switch (opt) {
                        case 1:
                            courses.add(new IntroductionToJava());
                            break;
                        case 2:
                            courses.add(new DataStructuresAndAlgorithms());
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            return;
                    }

                System.out.println(courses.get(0).getCourseName());
                lindex++;

                if (choice == 2) {
                    return;
                }

                // Course Progress
                System.out.println("You have successfully enrolled in the " + courses.get(0).getCourseName() + " Course!");
                System.out.println("Please access the course materials from the course dashboard.");
                for (int j = 0; j < 1; j++) {
                    while (courses.get(j).hasNextModule()) {

                        Module currentModule = courses.get(j).getNextModule();
                        System.out.println("Please complete all activities in " + currentModule.getmoduleName() + " Module.");
                        System.out.print("Did you understand the concepts in the module? (Y/N): ");
                        String understoodChoice = input.next();
                        if (understoodChoice.equalsIgnoreCase("N")) {
                            System.out.print("Please provide your feedback for the module: ");
                            String feedback = input.next();
                            currentModule.setFeedback(feedback);
                        }
                        currentModule.markAsComplete();
                    }

                    // Completion Certificate
                    System.out.println("Congratulations! You have completed the " + courses.get(j).getCourseName() + " Course.");
                    System.out.println("Please download your completion certificate from the course dashboard.");

                    // Review and Feedback
                    System.out.print("Would you like to provide a review and feedback for the course? (Y/N): ");
                    String reviewChoice = input.next();
                    if (reviewChoice.equalsIgnoreCase("Y")) {
                        System.out.print("Please provide your review for the course: ");
                        String feedback = input.next();
                        courses.get(j).setFeedback(feedback);
                    }

                }

                input.close();
        }
    }
}