package com.ulearn.JavaFX;

import com.ulearn.Main.Course;
import com.ulearn.Main.Lecturer;
import com.ulearn.Main.Student;
import com.ulearn.Main.User;
import com.ulearn.Subjects.DataStructuresAndAlgorithms;
import com.ulearn.Subjects.IntroductionToJava;
import com.ulearn.Utility.Session;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

public class HelloApplication extends Application {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Lecturer> lecturers = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private Scanner input;
    private String cName;
    private String lName;
    private int uniqueId = -1;
    private int sessionId = 0;

    @Override
    public void start(Stage stage) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome to ULEARN!");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-size: 16px;");
        TextField nameTextField = new TextField();

        Label emailLabel = new Label("Email:");
        emailLabel.setStyle("-fx-font-size: 16px;");
        TextField emailTextField = new TextField();

        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font-size: 16px;");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Log in");
        loginButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String password = passwordField.getText();
                users.add(new User(name, email, password));
                loginSelection(stage);
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.addRow(0, nameLabel, nameTextField);
        gridPane.addRow(1, emailLabel, emailTextField);
        gridPane.addRow(2, passwordLabel, passwordField);
        gridPane.add(loginButton, 1, 3);

        vBox.getChildren().addAll(
                welcomeLabel,
                loginButton,
                gridPane
        );

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void loginSelection(Stage stage) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label selectUserLabel = new Label("Please select a type of user from the list below.");
        selectUserLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton studentRadioButton = new RadioButton("Student");
        studentRadioButton.setStyle("-fx-font-size: 16px;");
        studentRadioButton.setToggleGroup(toggleGroup);
        studentRadioButton.setSelected(true);

        RadioButton lecturerRadioButton = new RadioButton("Lecturer");
        lecturerRadioButton.setStyle("-fx-font-size: 16px;");
        lecturerRadioButton.setToggleGroup(toggleGroup);

        HBox hBox = new HBox(50);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(studentRadioButton, lecturerRadioButton);

        Button nextButton = new Button("Next");
        nextButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (studentRadioButton.isSelected()) {
                    studentRegistration(stage);
                } else {
                    lecturerRegistration(stage);
                }
            }
        });

        vBox.getChildren().addAll(
                selectUserLabel,
                lecturerRadioButton,
                hBox,
                nextButton);

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);

    }

    private void studentRegistration(Stage stage) {
        uniqueId++;
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label registrationLabel = new Label("Student Registration");
        registrationLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-size: 16px;");
        TextField nameTextField = new TextField();

        Label emailLabel = new Label("Email:");
        emailLabel.setStyle("-fx-font-size: 16px;");
        TextField emailTextField = new TextField();

        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font-size: 16px;");
        PasswordField passwordField = new PasswordField();

        Label confirmPasswordLabel = new Label("Confirm Password:");
        confirmPasswordLabel.setStyle("-fx-font-size: 16px;");
        PasswordField confirmPasswordField = new PasswordField();

        Label ageLabel = new Label("Age:");
        ageLabel.setStyle("-fx-font-size: 16px;");
        TextField ageField = new TextField();

        Label idLabel = new Label("ID:");
        idLabel.setStyle("-fx-font-size: 16px;");
        TextField idField = new TextField();

        Label icLabel = new Label("IC:");
        icLabel.setStyle("-fx-font-size: 16px;");
        TextField icField = new TextField();

        Label departmentLabel = new Label("Department:");
        departmentLabel.setStyle("-fx-font-size: 16px;");
        TextField departmentField = new TextField();

        Label programmeLabel = new Label("Programme:");
        programmeLabel.setStyle("-fx-font-size: 16px;");
        TextField programmeField = new TextField();

        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                int age = Integer.parseInt(ageField.getText());
                String id = idField.getText();
                String ic = icField.getText();
                String department = departmentField.getText();
                String programme = programmeField.getText();
                if (!password.equals(confirmPassword)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Passwords do not match!", ButtonType.OK);
                    alert.showAndWait();
                } else {
                    students.add(uniqueId, new Student(name, email, password, age, id, ic, department, programme));
                    System.out.println(students.get(0).getName());
                    System.out.println(uniqueId);
                    assignCourse(stage, students, uniqueId);
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                start(stage);
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.addRow(0, nameLabel, nameTextField);
        gridPane.addRow(1, emailLabel, emailTextField);
        gridPane.addRow(2, passwordLabel, passwordField);
        gridPane.addRow(3, confirmPasswordLabel, confirmPasswordField);
        gridPane.addRow(4, ageLabel, ageField);
        gridPane.addRow(5, idLabel, idField);
        gridPane.addRow(6, icLabel, icField);
        gridPane.addRow(7, departmentLabel, departmentField);
        gridPane.addRow(8, programmeLabel, programmeField);
        gridPane.add(registerButton, 1, 9);
        gridPane.add(backButton, 2, 9);

        vBox.getChildren().addAll(
                registrationLabel,
                gridPane
        );

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    // -->> assignCourse -->> studentDashboard

    private void lecturerRegistration(Stage stage) {
        uniqueId++;
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Lecturer Registration");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-size: 16px;");
        TextField nameTextField = new TextField();

        Label emailLabel = new Label("Email:");
        emailLabel.setStyle("-fx-font-size: 16px;");
        TextField emailTextField = new TextField();

        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font-size: 16px;");
        PasswordField passwordField = new PasswordField();

        Label confirmPasswordLabel = new Label("Confirm Password:");
        confirmPasswordLabel.setStyle("-fx-font-size: 16px;");
        PasswordField confirmPasswordField = new PasswordField();

        Label ageLabel = new Label("Age:");
        ageLabel.setStyle("-fx-font-size: 16px;");
        TextField ageField = new TextField();

        Label idLabel = new Label("ID:");
        idLabel.setStyle("-fx-font-size: 16px;");
        TextField idField = new TextField();

        Label icLabel = new Label("IC:");
        icLabel.setStyle("-fx-font-size: 16px;");
        TextField icField = new TextField();

        Label departmentLabel = new Label("Department:");
        departmentLabel.setStyle("-fx-font-size: 16px;");
        TextField departmentField = new TextField();

        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setStyle("-fx-font-size: 16px;");
        TextField phoneField = new TextField();

        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                int age = Integer.parseInt(ageField.getText());
                String id = idField.getText();
                String ic = icField.getText();
                String department = departmentField.getText();
                String phoneNum = phoneField.getText();
                if (!password.equals(confirmPassword)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Passwords do not match!", ButtonType.OK);
                    alert.showAndWait();
                } else {
                    lecturers.add(uniqueId, new Lecturer(name, email, password, age, id, ic, department, phoneNum));
                    lecturerDashboard(stage, lecturers, uniqueId);
                }
            }
        });

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                start(stage);
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.addRow(0, nameLabel, nameTextField);
        gridPane.addRow(1, emailLabel, emailTextField);
        gridPane.addRow(2, passwordLabel, passwordField);
        gridPane.addRow(3, confirmPasswordLabel, confirmPasswordField);
        gridPane.addRow(4, ageLabel, ageField);
        gridPane.addRow(5, idLabel, idField);
        gridPane.addRow(6, icLabel, icField);
        gridPane.addRow(7, departmentLabel, departmentField);
        gridPane.addRow(8, phoneLabel, phoneField);
        gridPane.add(registerButton, 1, 9);
        gridPane.add(backButton, 2, 9);

        vBox.getChildren().addAll(
                titleLabel,
                gridPane);

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    // -->> lecturerDashboard

    private void studentDashboard(Stage stage, ArrayList<Student> students, int uniqueId, ArrayList<Course> courses) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome " + students.get(uniqueId).getName() + "!");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label idLabel = new Label("ID: " + students.get(uniqueId).getId());
        idLabel.setStyle("-fx-font-size: 16px;");

        Label departmentLabel = new Label("Department: " + students.get(uniqueId).getDepartment());
        departmentLabel.setStyle("-fx-font-size: 16px;");

        Label emailLabel = new Label("Email: " + students.get(uniqueId).getEmail());
        emailLabel.setStyle("-fx-font-size: 16px;");

        Label dashboardLabel = new Label("Dashboard");
        dashboardLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label courseListView = new Label("Your courses:");
        courseListView.setStyle("-fx-font-size: 16px;");

        //System.out.println(students.get(uniqueId).getCourseName());
        List<Course> studentCourse = new ArrayList<>();

        //studentCourse = students.get(uniqueId).getCourses(1);

        // Display the available courses Name in a ListView
        ObservableList<Course> courseList = FXCollections.observableArrayList(studentCourse);
        ListView<Course> listView = new ListView<>(courseList);
        listView.setPrefWidth(400);

        Button enrollButton = new Button("Enroll in course");
        enrollButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        enrollButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                assignCourse(stage, students, uniqueId);
            }
        });

        Button viewEnrolledCourseButton = new Button("View enrolled Course");
        viewEnrolledCourseButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        viewEnrolledCourseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewEnrolledCourses(stage, students, uniqueId, courses);
            }
        });

        Button logoutButton = new Button("Log out");
        logoutButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 16px;");
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                start(stage);
            }
        });

        HBox hBox = new HBox(50);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(enrollButton, logoutButton);

        vBox.getChildren().addAll(
                welcomeLabel,
                dashboardLabel,
                courseListView,
                listView,
                hBox
        );

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    // -->> viewEnrolledCourse -->> courseDetails -->> viewGrades ||  logout -->> start
    // issue: resolved

    private void lecturerDashboard(Stage stage, ArrayList<Lecturer> lecturers, int uniqueId) {

        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome " + lecturers.get(uniqueId).getName() + "!");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label idLabel = new Label("ID: " + lecturers.get(uniqueId).getId());
        idLabel.setStyle("-fx-font-size: 16px;");

        Label departmentLabel = new Label("Department: " + lecturers.get(uniqueId).getDepartment());
        departmentLabel.setStyle("-fx-font-size: 16px;");

        Label emailLabel = new Label("Email: " + lecturers.get(uniqueId).getEmail());
        emailLabel.setStyle("-fx-font-size: 16px;");

        Label dashboardLabel = new Label("Dashboard");
        dashboardLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button viewSessionsButton = new Button("View Sessions");
        viewSessionsButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        viewSessionsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewSessions(stage, lecturers, uniqueId);
            }
        });

        Button addSessionButton = new Button("Add Session");
        addSessionButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        addSessionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addSession(stage, lecturers, uniqueId);
            }
        });

        Button deleteSessionButton = new Button("Delete Session");
        deleteSessionButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        deleteSessionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                deleteSession(stage, lecturers, uniqueId);
            }
        });

        Button createAssignmentButton = new Button("Create Assignment");
        createAssignmentButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        createAssignmentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                assignmentCourseSelect(stage, lecturers, uniqueId);
            }
        });

        Button logoutButton = new Button("Log out");
        logoutButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 16px;");
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lecturers.remove(lecturers);
                start(stage);
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.addRow(0, emailLabel);
        gridPane.addRow(1, idLabel);
        gridPane.addRow(2, departmentLabel);
        gridPane.add(viewSessionsButton, 1, 3);
        gridPane.add(addSessionButton, 1, 4);
        gridPane.add(deleteSessionButton, 1, 5);
        gridPane.add(createAssignmentButton, 1, 6);

        vBox.getChildren().addAll(
                welcomeLabel,
                emailLabel,
                idLabel,
                departmentLabel,
                viewSessionsButton,
                addSessionButton,
                deleteSessionButton,
                createAssignmentButton
        );

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    // -->> viewSession, addSesssions, deleteSessions || --->> assignmentCourseSelect -->> createAssignment -->> || || -->> start
    // issue: resolved

    private void assignCourse(Stage stage, ArrayList<Student> students, int uniqueId) {
        System.out.println(uniqueId);
        System.out.println(students.get(0).getName());
        // Get the selected student
        //List<Student> selectedStudent = students;
        courses.add(new IntroductionToJava());
        courses.add(new DataStructuresAndAlgorithms());

        // Create a list of available courses
        List<Course> availableCourses = new ArrayList<>();
        availableCourses.add(new DataStructuresAndAlgorithms());
        availableCourses.add(new IntroductionToJava());

        // Display the available courses in a ListView
        ObservableList<Course> courseList = FXCollections.observableArrayList(availableCourses);
        ListView<Course> listView = new ListView<>(courseList);
        listView.setPrefWidth(400);

        // Add a label to display the selected course
        Label selectedCourseLabel = new Label("");

        // Add a button to assign the selected course
        Button assignButton = new Button("Assign Course");
        assignButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        assignButton.setOnAction(event -> {
            Course selectedCourse = listView.getSelectionModel().getSelectedItem();
            if (selectedCourse != null) {
                // Update the existing Student object
                students.get(uniqueId).setCourse(selectedCourse);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Course Assigned");
                alert.setHeaderText(null);
                alert.setContentText(selectedCourse.getCourseName() + " has been assigned to " + students.get(uniqueId).getName());
                alert.showAndWait();
            }
        });

        // Update the selected course label when a course is selected in the ListView
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedCourseLabel.setText("Selected Course: " + newValue.getCourseName());
            } else {
                selectedCourseLabel.setText("");
            }
        });

        // Add a button to go to the student dashboard
        Button dashboardButton = new Button("Go to Dashboard");
        dashboardButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        dashboardButton.setOnAction(event -> {
            Course selectedCourse = listView.getSelectionModel().getSelectedItem();
            if (selectedCourse != null) {
                studentDashboard(stage, students, uniqueId, selectedCourse);
            }
        });

        // Display the ListView, label, and buttons in a VBox
        VBox vBox = new VBox(20, listView, selectedCourseLabel, assignButton, dashboardButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));

        // Display the VBox in a new scene
        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
    }
    // -->> studentDashboard
    // issue: course is abstract, thus can't find specific course to the parameter inserted,
    // status: resolve with using instance rather than index

    private void courseDetails(Stage stage, ArrayList<Student> students, int uniqueId, ArrayList<Course> courses) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        int courseindex = 0;

        if (courses instanceof IntroductionToJava) {
            IntroductionToJava i = (IntroductionToJava) courses;
            cName = i.getCourseName();
            lName = i.getCourseLecturer();
            courseindex = 0;

        } else if (courses instanceof DataStructuresAndAlgorithms) {
            DataStructuresAndAlgorithms d = (DataStructuresAndAlgorithms) courses;
            cName = d.getCourseName();
            lName = d.getCourseLecturer();
            courseindex = 1;
        }

        Label courseLabel = new Label("Course: " + cName );
        courseLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label lecturerLabel = new Label("Lecturer: " + lName );
        lecturerLabel.setStyle("-fx-font-size: 16px;");

        Label descriptionLabel = new Label("Description:");
        descriptionLabel.setStyle("-fx-font-size: 16px;");
        TextArea descriptionTextArea = new TextArea();
        descriptionTextArea.setText(courses.get(courseindex).getDescription());
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setWrapText(true);
        descriptionTextArea.setPrefRowCount(5);

        Button viewGradeButton = new Button("View Grade");
        viewGradeButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        viewGradeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewGrades(stage, students, uniqueId, courses);
            }
        });

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    studentDashboard(stage, students, uniqueId, courses);
            }
        });

        vBox.getChildren().addAll(courseLabel, lecturerLabel, descriptionLabel, descriptionTextArea, backButton);

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    // -->> viewGrade || -->> studentDashboard
    // no issue

    private void assignmentCourseSelect(Stage stage, List<Lecturer> lecturers, int uniqueId) {
        // Create a new dialog
        Dialog<Course> dialog = new Dialog<>();
        dialog.setTitle("Choose Course");

        // Create the dialog content
        VBox content = new VBox();
        content.setSpacing(10);

        Label label = new Label("Select a course:");
        content.getChildren().add(label);

        // Create the course options
        ToggleGroup group = new ToggleGroup();

        RadioButton javaButton = new RadioButton("Introduction to Java");
        javaButton.setToggleGroup(group);
        javaButton.setSelected(true);
        content.getChildren().add(javaButton);

        RadioButton dsButton = new RadioButton("Data Structures and Algorithms");
        dsButton.setToggleGroup(group);
        content.getChildren().add(dsButton);

        // Add the content to the dialog
        dialog.getDialogPane().setContent(content);

        // Create the buttons
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

        // Set the result converter
        dialog.setResultConverter(buttonType -> {
            if (buttonType == okButton) {
                if (javaButton.isSelected()) {
                    return new IntroductionToJava();
                } else if (dsButton.isSelected()) {
                    return new DataStructuresAndAlgorithms();
                }
            }
            return null;
        });

        // Show the dialog and wait for a response
        Optional<Course> result = dialog.showAndWait();

        // If the user clicked OK, create the assignment
        result.ifPresent(course -> createAssignment(stage, (ArrayList<Lecturer>) lecturers, uniqueId, course));
    }
    // -->> createAssignment
    // no issue

    private void createAssignment(Stage stage, ArrayList<Lecturer> lecturers, int uniqueId, ArrayList<Course> courses) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label createAssignmentLabel = new Label("Create New Assignment");
        createAssignmentLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label assignmentNameLabel = new Label("Assignment Name:");
        assignmentNameLabel.setStyle("-fx-font-size: 16px;");
        TextField assignmentNameTextField = new TextField();

        Label assignmentDescriptionLabel = new Label("Assignment Description:");
        assignmentDescriptionLabel.setStyle("-fx-font-size: 16px;");
        TextArea assignmentDescriptionTextArea = new TextArea();

        Label assignmentDueDateLabel = new Label("Due Date:");
        assignmentDueDateLabel.setStyle("-fx-font-size: 16px;");
        DatePicker dueDatePicker = new DatePicker();

        Button createButton = new Button("Create");
        createButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String assignmentName = assignmentNameTextField.getText();
                String assignmentDescription = assignmentDescriptionTextArea.getText();
                LocalDate dueDate = dueDatePicker.getValue();

                Session newAssignment = new Session(assignmentName, assignmentDescription, dueDate);
                //borrow session class
                lecturerDashboard(stage, lecturers, uniqueId);
            }
        });

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lecturerDashboard(stage, lecturers, uniqueId);
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.addRow(0, assignmentNameLabel, assignmentNameTextField);
        gridPane.addRow(1, assignmentDescriptionLabel, assignmentDescriptionTextArea);
        gridPane.addRow(2, assignmentDueDateLabel, dueDatePicker);
        gridPane.add(createButton, 1, 3);
        gridPane.add(backButton, 2, 3);

        vBox.getChildren().addAll(createAssignmentLabel, gridPane);

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    // -->> lecturerDashboard
    // no issue

    private void viewGrades(Stage stage, ArrayList<Student> students, int uniqueId, ArrayList<Course> courses) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        int courseindex = 0;

        if (courses instanceof IntroductionToJava) {
            IntroductionToJava i = (IntroductionToJava) courses;
            cName = i.getCourseName();
            lName = i.getCourseLecturer();
            courseindex = 0;

        } else if (courses instanceof DataStructuresAndAlgorithms) {
            DataStructuresAndAlgorithms d = (DataStructuresAndAlgorithms) courses;
            cName = d.getCourseName();
            lName = d.getCourseLecturer();
            courseindex = 1;
        }

        Label titleLabel = new Label(cName + " Grades");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label studentLabel = new Label("Student: " + students.get(uniqueId).getName());
        studentLabel.setStyle("-fx-font-size: 18px;");

        TableView<Session> table = new TableView<>();
        table.setStyle("-fx-font-size: 16px;");
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Course, String> assignmentColumn = new TableColumn<>("Assignment");
        assignmentColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Course, Integer> gradeColumn = new TableColumn<>("Grade");
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> studentDashboard(stage, students, uniqueId, courses));

        vBox.getChildren().addAll(titleLabel, studentLabel, table, backButton);

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    // -->> studentDashboard

    private void viewEnrolledCourses(Stage stage, ArrayList<Student> students, int uniqueId, ArrayList<Course> courses)  {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label enrolledCoursesLabel = new Label("Enrolled Courses");
        enrolledCoursesLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TableView<Course> coursesTable = new TableView<>();
        coursesTable.setPrefWidth(600);

        TableColumn<Course, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Course, String> codeColumn = new TableColumn<>("Code");
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn<Course, String> instructorColumn = new TableColumn<>("Instructor");
        instructorColumn.setCellValueFactory(new PropertyValueFactory<>("instructor"));

        coursesTable.getColumns().addAll(nameColumn, codeColumn, instructorColumn);

        for (Course course : students.get(uniqueId).getEnrolledCourses()) {
            coursesTable.getItems().add(course);
        }

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                studentDashboard(stage, students, uniqueId, courses);
            }
        });

        coursesTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    Course course = coursesTable.getSelectionModel().getSelectedItem();
                    courseDetails(stage, students, uniqueId, courses);
                }
            }
        });

        vBox.getChildren().addAll(enrolledCoursesLabel, coursesTable, backButton);

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    // -->> courseDetails -->> viewGrades
    //no issue

    private void viewSessions(Stage stage, ArrayList<Lecturer> lecturers, int uniqueId) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("View Sessions");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TableView<Session> table = new TableView<Session>();

        TableColumn<Session, String> idColumn = new TableColumn<Session, String>("Schedule ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("scheduleID"));

        TableColumn<Session, String> locationColumn = new TableColumn<Session, String>("Location");
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Session, Date> dateColumn = new TableColumn<Session, Date>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Session, Course> courseColumn = new TableColumn<Session, Course>("Course");
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));

        table.getColumns().addAll(idColumn, locationColumn, dateColumn, courseColumn);

        for (Session session : lecturers.get(uniqueId).getSession(0)) {
            table.getItems().add(new Session(session.getScheduleID(), session.getLocation(), session.getStudents(), session.getLecturer(), session.getCourse(), session.getDate()));
        }

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lecturerDashboard(stage, lecturers, uniqueId);
            }
        });

        vBox.getChildren().addAll(titleLabel, table, backButton);

        Scene scene = new Scene(vBox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void addSession(Stage stage, ArrayList<Lecturer> lecturers, int uniqueId) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Add Session");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label locationLabel = new Label("Location:");
        TextField locationTextField = new TextField();

        Label dateLabel = new Label("Date (YYYY-MM-DD):");
        TextField dateTextField = new TextField();

        List<Course> availableCourses = new ArrayList<>();
        availableCourses.add(new DataStructuresAndAlgorithms());
        availableCourses.add(new IntroductionToJava());

        Label courseLabel = new Label("Course:");
        ObservableList<Course> courseList = FXCollections.observableArrayList(availableCourses);
        ChoiceBox<Course> courseChoiceBox = new ChoiceBox<>(courseList);
        courseChoiceBox.getSelectionModel().selectFirst();

        Button addButton = new Button("Add");
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String location = locationTextField.getText();
                String dateString = dateTextField.getText();
                Course course = courseChoiceBox.getValue();

                // Parse the date string to a Date object
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = dateFormat.parse(dateString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                lecturers.get(uniqueId).addSession(location, course, date, sessionId);
                sessionId++;

                // Show a confirmation dialog
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Session added successfully!");
                alert.showAndWait();

                // Go back to the dashboard
                lecturerDashboard(stage, lecturers, uniqueId);
            }
        });

        vBox.getChildren().addAll(
                titleLabel,
                locationLabel,
                locationTextField,
                dateLabel,
                dateTextField,
                courseLabel,
                courseChoiceBox,
                addButton
        );

        Scene scene = new Scene(vBox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void deleteSession(Stage stage, ArrayList<Lecturer> lecturers, int uniqueId) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Delete Session");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        ComboBox<Session> comboBox = new ComboBox<Session>();
        comboBox.setPromptText("Select session to delete");

        for (Session session : lecturers.get(uniqueId).getSession(0)) {
            comboBox.getItems().add(session);
        }

        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Session session = comboBox.getValue();
                if (session != null) {
                    lecturers.get(uniqueId).deleteSession(session);
                    sessionId--;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("Session deleted");
                    alert.setContentText("The session has been successfully deleted.");
                    alert.showAndWait();
                    viewSessions(stage, lecturers, uniqueId);
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText("No session selected");
                    alert.setContentText("Please select a session to delete.");
                    alert.showAndWait();
                }
            }
        });

        vBox.getChildren().addAll(titleLabel, comboBox, deleteButton);

        Scene scene = new Scene(vBox,400, 400);
        stage.setScene(scene);
        stage.show();
    }

}
