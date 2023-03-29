package com.ulearn.Subjects;
import com.ulearn.Main.Course;
import com.ulearn.Main.Module;

public class DataStructuresAndAlgorithms extends Course {
    private Module[] modules;
    private int currentModuleIndex;

    public DataStructuresAndAlgorithms() {
        super("Data Structures and Algorithms", "CS120" , false, 100.0);
        modules = new Module[5];
        modules[0] = new Module("Introduction to Data Structures");
        modules[1] = new Module("Arrays and Linked Lists");
        modules[2] = new Module("Stacks and Queues");
        modules[3] = new Module("Trees and Graphs");
        modules[4] = new Module("Sorting and Searching Algorithms");
        currentModuleIndex = -1;
    }

    @Override
    public void makePayment(String paymentDetails) {
        System.out.println("Payment of " + courseFee + " has been made using the following details: " + paymentDetails);
    }

    @Override
    public boolean hasNextModule() {
        return false;
    }

    @Override
    public Module getNextModule() {
        return null;
    }


}
