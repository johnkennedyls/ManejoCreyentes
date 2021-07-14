package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ChangePasswordController {
	
	@FXML
    private TextField currentPassword;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField confirmPassword;

    @FXML
    void save(ActionEvent event) {
    	currentPassword.getScene().getWindow().hide();
    }
    //
}
