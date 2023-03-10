
public class Semester {

    //attribute
    private String name;
    private char[][] grades;
    
    //constructor
    public Semester (String
    
    //getter and setter
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
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
        semester.setName("Final 2022");

        char[][] grades = {{'A', 'B', 'C'}, {'A', 'A', 'B'}};
        semester.setGrades(grades);

        System.out.println("Semester Name: " + semester.getName());
        System.out.println("Grades: ");
        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
            System.out.print(grades[i][j] + " ");
            }
        System.out.println();
        }
    }

}

