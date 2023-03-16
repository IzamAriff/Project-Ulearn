package com.ulearn.subjects;
import com.ulearn.main.*;
import com.ulearn.main.Module;

public class IntroductionToJava extends Course {
    private Module[] modules;
    private int currentModuleIndex;

    public IntroductionToJava() {
        super("Introduction to Programming", true, 50.0);
        modules = new Module[3];
        modules[0] = new Module("Variables and Data Types");
        modules[1] = new Module("Control Structures");
        modules[2] = new Module("Functions and Arrays");
        currentModuleIndex = -1;
    }

    @Override
    public void makePayment(String paymentDetails) {
        System.out.println("Payment of " + courseFee + " has been made using the following details: " + paymentDetails);
    }

    @Override
    public boolean hasNextModule() {
        return currentModuleIndex < 2;
    }

    @Override
    public Module getNextModule() {
        currentModuleIndex++;
        return modules[currentModuleIndex];
    }
}

