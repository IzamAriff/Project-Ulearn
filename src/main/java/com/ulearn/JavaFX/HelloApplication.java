package com.ulearn.JavaFX;

import com.ulearn.Main.Course;
import com.ulearn.Main.Lecturer;
import com.ulearn.Main.Student;
import com.ulearn.Main.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private final ArrayList<User> users = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();
    private final ArrayList<Lecturer> lecturers = new ArrayList<>();


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

        vBox.getChildren().addAll(welcomeLabel, gridPane);

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

        vBox.getChildren().addAll(selectUserLabel, hBox, nextButton);

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);

    }

    private void studentRegistration(Stage stage) {
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

        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                if (!password.equals(confirmPassword)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Passwords do not match!", ButtonType.OK);
                    alert.showAndWait();
                } else {
                    students.add(new Student(name, email, password));
                    loginSelection(stage);
                }
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.addRow(0, nameLabel, nameTextField);
        gridPane.addRow(1, emailLabel, emailTextField);
        gridPane.addRow(2, passwordLabel, passwordField);
        gridPane.addRow(3, confirmPasswordLabel, confirmPasswordField);
        gridPane.add(registerButton, 1, 4);

        vBox.getChildren().addAll(registrationLabel, gridPane);

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void lecturerRegistration(Stage stage) {
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

        Label departmentLabel = new Label("Department:");
        departmentLabel.setStyle("-fx-font-size: 16px;");
        TextField departmentTextField = new TextField();

        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                String department = departmentTextField.getText();
                if (!password.equals(confirmPassword)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Passwords do not match!", ButtonType.OK);
                    alert.showAndWait();
                } else {
                    lecturers.add(new Lecturer(name, email, password));
                    loginSelection(stage);
                }
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.addRow(0, nameLabel, nameTextField);
        gridPane.addRow(1, emailLabel, emailTextField);
        gridPane.addRow(2, passwordLabel, passwordField);
        gridPane.addRow(3, departmentLabel, departmentTextField);
        gridPane.add(registerButton, 1, 4);

        vBox.getChildren().addAll(titleLabel, gridPane);

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void studentDashboard(Stage stage, User user) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome " + user.getName() + "!");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label courseLabel = new Label("Your courses:");
        courseLabel.setStyle("-fx-font-size: 16px;");

        ListView<String> courseListView = new ListView<>();
        courseListView.setPrefWidth(400);
        courseListView.setPrefHeight(200);

        for (Course course : students.getCourse()) {
            courseListView.getItems().add(course.getName());
        }

        Button enrollButton = new Button("Enroll in course");
        enrollButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        enrollButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                enrollCourse(stage, user);
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

        vBox.getChildren().addAll(welcomeLabel, courseLabel, courseListView, hBox);

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void lecturerDashboard(Stage stage, User user) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome " + user.getName() + "!");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label dashboardLabel = new Label("Dashboard");
        dashboardLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button viewCoursesButton = new Button("View Courses");
        viewCoursesButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        viewCoursesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewCourses(stage);
            }
        });

        Button addCourseButton = new Button("Add Course");
        addCourseButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        addCourseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addCourse(stage);
            }
        });

        Button logoutButton = new Button("Log out");
        logoutButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 16px;");
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                users.remove(user);
                start(stage);
            }
        });

        vBox.getChildren().addAll(welcomeLabel, dashboardLabel, viewCoursesButton, addCourseButton, logoutButton);

        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void assignCourse(Stage stage, User user) {
        // Get the selected student
        Student selectedStudent = null;
        for (Student student : students) {
            if (student.getId().equals(user.getId())) {
                selectedStudent = student;
                break;
            }
        }

        // Create a list of available courses
        List<Course> availableCourses = new ArrayList<>();
        for (Course course : courses) {
            if (!selectedStudent.getCourseIds().contains(course.getCourseId())) {
                availableCourses.add(course);
            }
        }

        // Display the available courses in a ListView
        ObservableList<Course> courseList = FXCollections.observableArrayList(availableCourses);
        ListView<Course> listView = new ListView<>(courseList);
        listView.setPrefWidth(400);

        // Add a button to assign the selected course
        Button assignButton = new Button("Assign Course");
        assignButton.setOnAction(event -> {
            Course selectedCourse = listView.getSelectionModel().getSelectedItem();
            if (selectedCourse != null) {
                selectedStudent.getCourseIds().add(selectedCourse.getCourseId());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Course Assigned");
                alert.setHeaderText(null);
                alert.setContentText(selectedCourse.getName() + " has been assigned to " + selectedStudent.getName());
                alert.showAndWait();
            }
        });

        // Display the ListView and button in a VBox
        VBox vBox = new VBox(20, listView, assignButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));

        // Display the VBox in a new scene
        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
    }









