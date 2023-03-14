public class Course {


// azam nk attack izam
    //attribute
    private String name;
    private String courseID;
    private Lecturer lecturer; //name, office, phoneNum
    private int creditHour;
    private String description;

    //constructor
    public Course(String name, String CourseID, lecturer Lecturer, int creditHour, String description) {
        this.courseID = courseID;
        this.creditHour = creditHour;
        this.name = name;
        this.description = description;
        this.Lecturer = Lecturer;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void getLectureCourse(String name, String courseID, String description) { //courseID is just using the index of the array 

    }

    public void getStudentCourse(String name, String courseID, Lecturer lecturer, String creditHour, String description) {

    }
}
