package ui;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
    private PasswordField passwordField;

    @FXML
    private TextField userNameField;

    @FXML
    void login(ActionEvent event) {
    	verifyLogin();
    }
    
    private boolean verifyLogin() {
    	return false;
    }

}

