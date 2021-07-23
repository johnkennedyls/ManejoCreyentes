package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Church;

public class EditCommitteeController {
	 
	@FXML
    private TextField committeeName;
	
	private Church church;
    
    public EditCommitteeController(Church church) {
		this.church = church;
	}
	
    @FXML
    void edit(ActionEvent event) {
    	String newCommitteeName = committeeName.getText();
    	
    }

    @FXML
    void goBack(ActionEvent event) {
    	committeeName.getScene().getWindow().hide();
    	
    }

}
