import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDataAccess {

    private Connection connection;

    public StudentDataAccess(Connection connection) {
        this.connection = connection;
    }

    public void addStudent(Student student) throws SQLException {

        String query = "INSERT INTO student (name, id, age, ic, department, email, programme) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, student.getName());
        statement.setString(2, student.getId());
        statement.setInt(3, student.getAge());
        statement.setString(4, student.getIc());
        statement.setString(5, student.getDepartment());
        statement.setString(6, student.getEmail());
        statement.setString(7, student.getProgramme());
        statement.executeUpdate();
    }

    public void updateStudent(Student student) throws SQLException {

        String query = "UPDATE student SET name=?, age=?, ic=?, department=?, email=?, programme=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, student.getName());
        statement.setInt(2, student.getAge());
        statement.setString(3, student.getIc());
        statement.setString(4, student.getDepartment());
        statement.setString(5, student.getEmail());
        statement.setString(6, student.getProgramme());
        statement.setString(7, student.getId());
        statement.executeUpdate();
    }

    public void deleteStudent(String id) throws SQLException {

        String query = "DELETE FROM student WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, id);
        statement.executeUpdate();
    }

    public Student getStudentById(String id) throws SQLException {

        String query = "SELECT * FROM student WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Student student = new Student();
            student.setName(resultSet.getString("name"));
            student.setId(resultSet.getString("id"));
            student.setAge(resultSet.getInt("age"));
            student.setIc(resultSet.getString("ic"));
            student.setDepartment(resultSet.getString("department"));
            student.setEmail(resultSet.getString("email"));
            student.setProgramme(resultSet.getString("programme"));
            return student;
        } 
            return null;
    }

    public ArrayList<Student> getAllStudents() throws SQLException {

        String query = "SELECT * FROM student";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Student> students = new ArrayList<>();

        while (resultSet.next()) {
            Student student = new Student();
            student.setName(resultSet.getString("name"));
            student.setId(resultSet.getString("id"));
            student.setAge(resultSet.getInt("age"));
            student.setIc(resultSet.getString("ic"));
            student.setDepartment(resultSet.getString("department"));
            student.setEmail(resultSet.getString("email"));
            student.setProgramme(resultSet.getString("programme"));
            students.add(student);
        }
        return students;
    }

}

