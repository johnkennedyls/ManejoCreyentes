package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewSectorController {
	@FXML
    private TextField currentPassword;

    @FXML
    void save(ActionEvent event) {
    	currentPassword.getScene().getWindow().hide();
    	
    }
    
}
