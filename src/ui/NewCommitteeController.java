package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewCommitteeController {
	@FXML
    private TextField committeeName;

    @FXML
    void save(ActionEvent event) {
    	committeeName.getScene().getWindow().hide();
    	
    }
    
}
