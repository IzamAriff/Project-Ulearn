public class Course {

    private String name;
    private String courseID;
    private lecturer Lecturer;
    private int creditHour;
    private String description;


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

    public getLectureCourse(String name, String courseID, String description) {

    }

    public getStudentCourse(String name, String CourseID, Lecturer lecturer, String creditHour, String description) {

    }
}
