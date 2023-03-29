import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentRegister extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create input fields for name, id, and age
        TextField nameField = new TextField();
        TextField idField = new TextField();
        TextField ageField = new TextField();
        
        // Create label and dropdown menu for department options
        Label departmentLabel = new Label("Department:");
        ComboBox<String> departmentDropdown = new ComboBox<>();
        departmentDropdown.getItems().addAll("Sales", "Marketing", "Engineering", "HR");
        
        // Create a grid pane to organize the input fields and labels
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        // Add labels and input fields to the grid pane
        gridPane.add(new Label("Name:"), 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(new Label("ID:"), 0, 1);
        gridPane.add(idField, 1, 1);
        gridPane.add(new Label("Age:"), 0, 2);
        gridPane.add(ageField, 1, 2);
        gridPane.add(departmentLabel, 0, 3);
        gridPane.add(departmentDropdown, 1, 3);
        
        // Create a submit button and add it to an HBox
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10, 0, 0, 0));
        hbox.getChildren().add(new Button("Submit"));
        
        // Create a scene with the grid pane and submit button
        Scene scene = new Scene(new VBox(20, gridPane, hbox), 400, 300);
        
        // Set the scene on the stage and show it
        primaryStage.setScene(scene);
        primaryStage.setTitle("Employee Information");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
