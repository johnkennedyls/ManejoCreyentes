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
import model.Church;
import javafx.scene.control.Alert.AlertType;

public class RegisterController {
	private Church myChurch;
	
	@FXML
    private TextField nameField;

    @FXML
    private TextField idField;

   
    @FXML
    private ComboBox<String> genderComboBox;
    
   

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
    
    public  RegisterController(Church myChurch) {
    	this.myChurch = myChurch;
	}
    
    @FXML
    public void initialize() {
    	loadGender();
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
    
    private void loadGender() {
   	

   	 genderComboBox.getItems().add("Hombre");
   	 genderComboBox.getItems().add("Mujer");
   }
    
    private void loadSectorType() {
    	for (int i = 0; i < myChurch.getTheSectors().size(); i++) {
			sectorType.getItems().add(myChurch.getTheSectors().get(i).getName());
		}
    }
    
    private void loadCommittees() {
    	for (int i = 0; i < myChurch.getTheCommittees().size(); i++) {
			sectorType.getItems().add(myChurch.getTheCommittees().get(i).getName());
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
