package ui;

import java.time.temporal.ChronoUnit;

import exceptions.EmptyDataException;
import exceptions.InvalidUserException;
import exceptions.PasswordMismatchException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Church;

public class ChangePasswordController {
	
	@FXML
    private TextField currentPassword;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField confirmPassword;
    
    final static String DEVELOPER_PASSWORD = "7uVxe2DKma8LAJm1lrHV6" ;
    
    private Church church;
    
    public ChangePasswordController(Church church) {
		this.church = church;
	}
    
    @FXML
    void save(ActionEvent event) {
    	try {
			validateEmptyFields();
			validateOldPassword();
			validateNewPassword();
			passwordChangedAlert();
			
		} catch (EmptyDataException emptyDataException) {
			emptyFieldsAlert(emptyDataException.getMessage());
		}catch (InvalidUserException invalidUserException) {
			invalidUserAlert();
			
		}catch (PasswordMismatchException passwordMismatchException) {
			passwordMismatchAlert(passwordMismatchException.getMessage());
			
		}
    	currentPassword.getScene().getWindow().hide();
    	
    }
    
    private void passwordChangedAlert() {
		Alert emptyFieldsAlert = new Alert(AlertType.ERROR);
		emptyFieldsAlert.setTitle("Cambio de contraseña.");
		emptyFieldsAlert.setHeaderText("La contraseña ha sido cambiada exitosamente.");
		emptyFieldsAlert.showAndWait();

	}
    
    private void validateEmptyFields() throws EmptyDataException {
		if (currentPassword.getText().equals("")) {
			throw new EmptyDataException();
		}

		if (newPassword.getText().equals("")) {
			throw new EmptyDataException();
		}
		
		if (confirmPassword.getText().equals("")) {
			throw new EmptyDataException();
		}

	}
    
    private void emptyFieldsAlert(String message) {
		Alert emptyFieldsAlert = new Alert(AlertType.ERROR);
		emptyFieldsAlert.setTitle("Datos vacíos.");
		emptyFieldsAlert.setHeaderText(message);
		emptyFieldsAlert.showAndWait();

	}
    
    private void validateOldPassword() throws InvalidUserException{
    	String password = church.getMinister().getPassword();

		String inputPassword = currentPassword.getText();
		 
		if (!password.equals(inputPassword)) {
			throw new InvalidUserException();
			
		  
		}else if (!inputPassword.equals(DEVELOPER_PASSWORD)) {
			throw new InvalidUserException();
			
		}

	}
    
    private void invalidUserAlert() {
		Alert emptyFieldsAlert = new Alert(AlertType.ERROR);
		emptyFieldsAlert.setTitle("Contraseña invalida.");
		emptyFieldsAlert.setHeaderText("La contraseña ingresada no corresponde a la contraseña del usuario.");
		emptyFieldsAlert.showAndWait();

	}
    
    private void validateNewPassword() throws PasswordMismatchException{
		if (newPassword.getText().equals(confirmPassword.getText())) {
			church.getMinister().setPassword(newPassword.getText());
			
		}else {
			throw new PasswordMismatchException();
			
		}
	}
    
    private void passwordMismatchAlert(String message) {
		Alert emptyFieldsAlert = new Alert(AlertType.ERROR);
		emptyFieldsAlert.setTitle("las Contraseñas no corresponden.");
		emptyFieldsAlert.setHeaderText(message);
		emptyFieldsAlert.showAndWait();

	}
    
    
    
}
