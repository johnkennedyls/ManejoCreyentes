package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewSectorController {
	@FXML
    private TextField sectorName;

    @FXML
    void save(ActionEvent event) {
    	sectorName.getScene().getWindow().hide();
    	
    }
    
}
