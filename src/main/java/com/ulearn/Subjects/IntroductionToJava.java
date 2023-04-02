package com.ulearn.Subjects;
import com.ulearn.Main.*;
import com.ulearn.Main.Module;

public class IntroductionToJava extends Course {
    private Module[] modules;
    private int currentModuleIndex;
    private Lecturer lecturer;
    private static final int uniqueId = 2;

    public IntroductionToJava() {
        super("Introduction to Programming", "CS141", true, 50.0,
                3, "Mr. Adam", "About Java Programmin: ");
        modules = new Module[3];
        modules[0] = new Module("Variables and Data Types");
        modules[1] = new Module("Control Structures");
        modules[2] = new Module("Functions and Arrays");
        currentModuleIndex = -1;
        lecturer = new Lecturer("Mrs. Lia");
    }

    public int getCourseId() {
        return uniqueId;
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

