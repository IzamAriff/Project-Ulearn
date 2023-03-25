package com.ulearn.Utility;

public class Semester {

    //attribute
    private static final String[] name = {
            "1st Year 1st Sem",
            "1st Year 2nd Sem",
            "1nd Year 3rd Sem",
            "2nd Year 1st Sem",
            "2nd Year 2nd Sem",
            "2nd Year 3rd Sem",
            "3rd Year 1st Sem",
            "3rd Year 2nd Sem",
            "3rd Year 3rd Sem"
    };

    private char[][] grades;
    
    //constructor
    public Semester(String name, char[][] grades) {
        this.grades = grades;
    }

    public Semester() {
    }

    //getter and setter
    public String getName(int index) {
        return name[index];
    }
    
    public char[][] getGrades() {
        return grades;
    }
    
    public void setGrades(char[][] grades) {
        this.grades = grades;
    }
    
    //recheck this??? what the heck it does
    public static void main(String[] args) {
        
        Semester semester = new Semester();
        String semesterName = semester.getName(0); //0 index at 1st Year 1st Sem

        char[][] grades = {{'A', 'B', 'C'}, {'A', 'A', 'B'}};
        semester.setGrades(grades);

        System.out.println("Semester Name: " + semesterName);
        System.out.println("Grades: ");
        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
            System.out.print(grades[i][j] + " ");
            }
        System.out.println();
        }
    }

}

