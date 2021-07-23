package ui;

import java.io.IOException;
import java.time.LocalDate;

import exceptions.EmptyDataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import model.Church;

public class EditController {
	 @FXML
	    private TextField nameField;

	    @FXML
	    private TextField idField;

	    @FXML
	    private ComboBox<?> genderComboBox;

	    @FXML
	    private DatePicker birthday;

	    @FXML
	    private CheckBox baptized;

	    @FXML
	    private CheckBox active;

	    @FXML
	    private TextField phoneNumberField;

	    @FXML
	    private ComboBox<String> sectorType;

	    @FXML
	    private ComboBox<String> committee;

	    @FXML
	    private TextArea observationsField;
	
	private Church church;
	private BorderPane mainPane;
    
    public EditController(Church church,BorderPane mainPane) {
		this.church = church;
		this.mainPane = mainPane;
	}
    
    @FXML
    public void initialize() {
    	loadMemberInfo();
		
    }
    
    private void loadMemberInfo() {
		church.getTheCommittees();
    }
    
    @FXML
    void edit(ActionEvent event) {
    	try {
    		validateEmptyFields();
    		
    		System.out.println("edited :)");
		} catch (EmptyDataException emptyDataException) {
			emptyFieldsAlert(emptyDataException.getMessage());
		}
    }

    @FXML
    void goBack(ActionEvent event) {
    	loadInfoWindow();
    }
    
    private void loadInfoWindow() {
    	try {
    		InfoController infoController = new InfoController(church,mainPane);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/info.fxml"));
			fxmlLoader.setController(infoController);
			Parent Pane = fxmlLoader.load();
			mainPane.setCenter(Pane);
			

		} catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    }
    
    private void validateEmptyFields() throws EmptyDataException{
    	if (nameField.getText().equals("")) {
			throw new EmptyDataException();
		}
    	
    	if (idField.getText().equals("")) {
			throw new EmptyDataException();
		}
    	
    	LocalDate localDate = birthday.getValue();
    	
    	if (localDate == null) {
			throw new EmptyDataException();
		}
    	
    	if (phoneNumberField.getText().equals("")) {
			throw new EmptyDataException();
		}
    	
    }
    
    private void emptyFieldsAlert(String message) {
    	Alert emptyFieldsAlert = new Alert(AlertType.ERROR);
    	emptyFieldsAlert.setTitle("Datos vacíos.");
    	emptyFieldsAlert.setHeaderText(message);
    	emptyFieldsAlert.showAndWait();

    }
    
}
