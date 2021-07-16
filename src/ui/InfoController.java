package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Church;

public class InfoController {
	@FXML
    private Label name;

    @FXML
    private Label id;

    @FXML
    private Label gender;

    @FXML
    private Label birthday;

    @FXML
    private Label baptized;

    @FXML
    private Label active;

    @FXML
    private Label phoneNumber;

    @FXML
    private Label sector;

    @FXML
    private Label phoneNumber1;

    @FXML
    private Label sector1;

    @FXML
    private Label committee;

    @FXML
    void edit(ActionEvent event) {

    }
	
	private Church church;
    
    public InfoController(Church church) {
		this.church = church;
	}
    
    @FXML
    public void initialize() {
    	loadInfo();
		
    }
    
    private void loadInfo() {
    	church.getTheCommittees();
    }
    
    @FXML
    void remove(ActionEvent event) {

    }
}
