public class Student extends Person {
    
    //attributes
    private String programme;
    private course[] = Course;
    private fee Fee;
    private semester Semester;
    
    //constructor: assigning values to attributes
    public Student(String name, String id, int age, String ic, String department,
                   Course[] courses, String programme, Fee fee, Semester semester) {
        
        // call the constructor of the Person class using 'super'
        super(name, id, age, ic, department); 
        this.courses = courses;
        this.programme = programme;
        this.fee = fee;
        this.semester = semester;
    }
    
    public addCourse(couse Course) {
        return course;
    }
    public dropCourse(course Course){
        return course;
    }

    void getCourse() {
        return 0;
    }

    void getProgramme() {
        return 0;
    }

    public void setProgramme(String programe) {
        this.programme = programme;
    }
       
    void getCourse() {
        return 0;
    }
    
    public void setFee(fee Fee) {
        this.fee = fee;
    }
    
    
    
    
    
    
    
    
    
}
