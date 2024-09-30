Explanation of Key Components:

	•	JavaFX Classes:
	•	Application: The base class for any JavaFX application. It manages the application lifecycle.
	•	Stage: Represents the main window where the UI is displayed.
	•	Scene: The container for the UI elements in JavaFX. You set this on the Stage.
	•	Label: A UI component that displays static text.
	•	VBox: A layout manager that arranges UI components vertically.
	•	XML Parsing Classes:
	•	DocumentBuilderFactory: A factory that provides methods to create an XML parser.
	•	DocumentBuilder: A parser that reads XML files and converts them into a DOM Document.
	•	Document: A DOM representation of the XML file, which you can traverse to extract data.
	•	NodeList: Represents a list of nodes (elements) from the XML document.
	•	Element: Represents an individual XML element, like <contact>.
	•	Java I/O:
	•	File: Represents a file on the filesystem. Here, it refers to contacts.xml.

This program will display each contact’s name, phone number, and email address from the contacts.xml file in a simple vertical list. The window title is “Contact List Manager,” and the layout is managed by a VBox.
The compiling commands were a little more verbose with JavaFX: javac --module-path src/javafx-sdk-23/lib --add-modules javafx.controls,javafx.fxml -d out src/ContactListManager.java
And to Run: java --module-path src/javafx-sdk-23/lib --add-modules javafx.controls,javafx.fxml -cp out ContactListManager
