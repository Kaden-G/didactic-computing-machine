import javafx.application.Application;  // Importing the base class for JavaFX applications
import javafx.scene.Scene;  // Importing the class that represents a scene, where UI elements are placed
import javafx.scene.control.Label;  // Importing the Label class, which is used to display text
import javafx.scene.layout.VBox;  // Importing the VBox layout class, which organizes elements vertically
import javafx.stage.Stage;  // Importing the Stage class, which is the main window
import org.w3c.dom.*;  // Importing DOM classes for parsing XML documents
import javax.xml.parsers.*;  // Importing classes for creating the XML parser
import java.io.File;  // Importing the File class for handling file input

public class ContactListManager extends Application {  // Extending the Application class to create a JavaFX application

    public static void main(String[] args) {  
        // The main method is the entry point for a Java application
        // 'launch(args)' is a call to start the JavaFX application and invoke the 'start' method
        launch(args);  
    }

    @Override
    public void start(Stage primaryStage) {  
        // The 'start' method is where the JavaFX application starts and the UI is set up
        // The 'Stage' object represents the main window

        VBox root = new VBox();  
        // Creating a VBox layout manager that arranges its children (UI elements) vertically
        // 'VBox' is a layout class in JavaFX

        Label title = new Label("Contact List");  
        // Creating a Label object with the text "Contact List" which will serve as a title
        // A label in JavaFX is a non-editable text display control

        root.getChildren().add(title);  
        // Adding the title label to the VBox layout, which will appear at the top of the window

        try {
            // Try block to catch exceptions during file reading and XML parsing

            File xmlFile = new File("contacts.xml");  
            // Creating a File object representing the 'contacts.xml' file
            // This file contains the contacts data in XML format and should be located in the project root

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
            // Creating a new DocumentBuilderFactory, which is used to create a parser for XML files

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();  
            // Creating a DocumentBuilder object, which parses the XML and converts it into a Document object (a DOM tree)

            Document doc = dBuilder.parse(xmlFile);  
            // Parsing the XML file into a Document object
            // This creates a DOM tree (Document Object Model) of the XML content, which we can traverse

            doc.getDocumentElement().normalize();  
            // Normalizing the XML structure to eliminate any irregularities such as stray whitespace or newlines

            NodeList nodeList = doc.getElementsByTagName("contact");  
            // Fetching all the 'contact' elements from the XML
            // The result is a NodeList, which behaves like an array of XML nodes

            for (int i = 0; i < nodeList.getLength(); i++) {  
                // Iterating over each 'contact' node in the NodeList
                // 'nodeList.getLength()' gives the number of 'contact' elements in the XML

                Element contact = (Element) nodeList.item(i);  
                // Retrieving a single 'contact' element at index 'i'
                // We cast it to an Element, since we know each node in 'nodeList' is an Element

                String name = contact.getElementsByTagName("name").item(0).getTextContent();  
                // Extracting the text content of the 'name' tag inside the current 'contact' element
                // 'getElementsByTagName("name")' gets the NodeList of <name> elements, and 'item(0)' fetches the first one

                String phone = contact.getElementsByTagName("phone").item(0).getTextContent();  
                // Extracting the text content of the 'phone' tag in the same way

                String email = contact.getElementsByTagName("email").item(0).getTextContent();  
                // Extracting the text content of the 'email' tag in the same way

                Label contactLabel = new Label("Name: " + name + ", Phone: " + phone + ", Email: " + email);  
                // Creating a Label to display the contact's name, phone, and email in the format: "Name: ..., Phone: ..., Email: ..."

                root.getChildren().add(contactLabel);  
                // Adding the contact label to the VBox layout, so it will be displayed in the window
            }
        } catch (Exception e) {
            // Catch block to handle any exceptions that occur during file reading or XML parsing
            e.printStackTrace();  // Print the error details to the console for debugging
        }

        Scene scene = new Scene(root, 400, 300);  
        // Creating a Scene object, which is the container for all the UI elements
        // The scene is created with 'root' (the VBox layout) and a width of 400 and height of 300 pixels

        primaryStage.setScene(scene);  
        // Setting the scene for the primary stage (the main window of the application)

        primaryStage.setTitle("Contact List Manager");  
        // Setting the title of the main window

        primaryStage.show();  
        // Displaying the window on the screen
    }
}