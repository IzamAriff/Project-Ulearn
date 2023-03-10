public class Student extends Person {
    
    //attributes
    private String programme;
    private Course[] course;
    private Fee fee;
    private Semester semester;
    
    //constructor: assigning values to attributes
    public Student(String name, String id, int age, String ic, String department, String email,
                                Course[] courses, String programme, Fee fee, Semester semester) {
        
        // call the constructor of the Person class using 'super'
        super(name, id, age, ic, department, email); 
        this.courses = courses;
        this.programme = programme;
        this.fee = fee;
        this.semester = semester;
    }

    public void setCourse(Course[] course) {
        this.course = course;
    }

    public Course[] getCourse() {
        return course;
    }

    public void setProgramme(String programe) {
        this.programme = programme;
    }
    
    public String getProgramme() {
        return programme;
    }
}
