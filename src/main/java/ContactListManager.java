import javafx.application.Application;  // Importing the base class for JavaFX applications
import javafx.scene.Scene;  // Importing the class that represents a scene, where UI elements are placed
import javafx.scene.control.Label;  // Importing the Label class, which is used to display text
import javafx.scene.layout.VBox;  // Importing the VBox layout class, which organizes elements vertically
import javafx.stage.Stage;  // Importing the Stage class, which is the main window
import org.w3c.dom.*;  // Importing DOM classes for parsing XML documents
import javax.xml.parsers.*;  // Importing classes for creating the XML parser
import java.io.File;  // Importing the File class for handling file input

public class ContactListManager extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Parse the contacts XML
        ContactParser parser = new ContactParser();
        ObservableList<Contact> contacts = parser.parseContacts("path/to/contacts.xml");

        // Create TableView
        TableView<Contact> tableView = new TableView<>();

        // Define columns for the TableView
        TableColumn<Contact, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setPrefWidth(200);

        TableColumn<Contact, String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phoneColumn.setPrefWidth(150);

        TableColumn<Contact, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColumn.setPrefWidth(250);

        // Add columns to the TableView
        tableView.getColumns().addAll(nameColumn, phoneColumn, emailColumn);

        // Add the data
        tableView.setItems(contacts);

        // Add the TableView to the scene
        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Contact List Manager");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}