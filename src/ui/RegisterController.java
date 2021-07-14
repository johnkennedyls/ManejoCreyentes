package ui;

import java.time.LocalDate;


import exceptions.EmptyDataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RegisterController {
	
	@FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField genderField;

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
    private ComboBox<String> committees;

    @FXML
    private TextArea observationsField;
    
    @FXML
    public void initialize() {
        loadCommittees();
        loadSectorType();
    }
    
    @FXML
    void signUp(ActionEvent event) {
    	try {
    		validateEmptyFields();
    		
    		System.out.println("registered :)");
		} catch (EmptyDataException emptyDataException) {
			emptyFieldsAlert(emptyDataException.getMessage());
		}
    }
    
    private void loadSectorType() {
    	
    }
    
    private void loadCommittees() {
    	
    }
    
    private void validateEmptyFields() throws EmptyDataException{
    	if (nameField.getText().equals("")) {
			throw new EmptyDataException();
		}
    	
    	if (idField.getText().equals("")) {
			throw new EmptyDataException();
		}
    	
    	if (genderField.getText().equals("")) {
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
    	emptyFieldsAlert.setTitle("Datos vac�os.");
    	emptyFieldsAlert.setHeaderText(message);
    	emptyFieldsAlert.showAndWait();

    }
    
}