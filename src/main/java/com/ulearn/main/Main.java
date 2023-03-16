package com.ulearn.main;

import com.ulearn.subjects.*;

import java.sql.SQLException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name, email, password, subject, feedback;
        int age, choice;

        // User Registration
        System.out.println("Welcome to ULEARN!");
        System.out.println("Please provide the following details to register.");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Email: ");
        email = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();
        System.out.print("Age: ");
        age = scanner.nextInt();
        scanner.nextLine(); // To consume the leftover newline character

        User user = new User(name, email, password, age);

        // User Profile Creation
        System.out.println("Please create your profile.");
        System.out.print("Subject of Interest: ");
        subject = scanner.nextLine();

        user.setSubject(subject);

        // Course Selection and Enrollment
        System.out.println("Please select a course from the list below.");
        System.out.println("1. Introduction to Programming");
        System.out.println("2. Data Structures and Algorithms");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        Course course;
        switch (choice) {
            case 1:
                course = new IntroductionToJava();
                break;
            case 2:
                course = new DataStructuresAndAlgorithms();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("You have selected the " + course.getcourseName() + " course.");
        System.out.println("Please enroll in the course.");
        System.out.print("Do you want to use the free trial period? (Y/N): ");
        String freeTrialChoice = scanner.next();
        if (freeTrialChoice.equalsIgnoreCase("Y")) {
            course.useFreeTrial();
        } else {
            System.out.print("Please enter your payment details: ");
            String paymentDetails = scanner.next();
            course.makePayment(paymentDetails);
        }

        // Course Progress
        System.out.println("You have successfully enrolled in the " + course.getcourseName() + " course.");
        System.out.println("Please access the course materials from the course dashboard.");
        while (course.hasNextModule()) {
            Module currentModule = course.getNextModule();
            System.out.println("Please complete the " + currentModule.getmoduleName() + " module.");
            System.out.print("Did you understand the concepts in the module? (Y/N): ");
            String understoodChoice = scanner.next();
            if (understoodChoice.equalsIgnoreCase("N")) {
                System.out.print("Please provide your feedback for the module: ");
                feedback = scanner.next();
                currentModule.setFeedback(feedback);
            }
            currentModule.markAsComplete();
        }

        // Completion Certificate
        System.out.println("Congratulations! You have completed the " + course.getcourseName() + " course.");
        System.out.println("Please download your completion certificate from the course dashboard.");

        // Review and Feedback
        System.out.print("Would you like to provide a review and feedback for the course? (Y/N): ");
        String reviewChoice = scanner.next();
        if (reviewChoice.equalsIgnoreCase("Y")) {
            System.out.print("Please provide your review for the course: ");
            feedback = scanner.next();
            course.setFeedback(feedback);
        }

        scanner.close();
    }
}
