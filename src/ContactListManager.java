import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class ContactListManager extends Application {

    public static void main(String[] args) {
        launch(args);  // Start the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();  // Create a vertical box layout
        Label title = new Label("Contact List");  // Title for the window
        root.getChildren().add(title);  // Add the title label to the layout

        // Load and parse the XML file containing contact information
        try {
            File xmlFile = new File("contacts.xml");  // Ensure the path to your XML file is correct
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);  // Parse the XML file

            doc.getDocumentElement().normalize();  // Normalize the XML structure

            NodeList nodeList = doc.getElementsByTagName("contact");  // Get all <contact> elements

            // Loop through each contact in the XML file and display it
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element contact = (Element) nodeList.item(i);

                String name = contact.getElementsByTagName("name").item(0).getTextContent();
                String phone = contact.getElementsByTagName("phone").item(0).getTextContent();
                String email = contact.getElementsByTagName("email").item(0).getTextContent();

                // Create a label for each contact and add it to the layout
                Label contactLabel = new Label("Name: " + name + ", Phone: " + phone + ", Email: " + email);
                root.getChildren().add(contactLabel);
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print any errors encountered during XML parsing
        }

        Scene scene = new Scene(root, 400, 300);  // Create a scene with the layout
        primaryStage.setScene(scene);  // Set the scene on the primary stage
        primaryStage.setTitle("Contact List Manager");  // Set the window title
        primaryStage.show();  // Display the window
    }
}