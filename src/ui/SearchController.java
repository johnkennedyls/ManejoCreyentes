package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Church;

public class SearchController {
	@FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private CheckBox baptizedCB;

    @FXML
    private CheckBox activeCB;

    @FXML
    private ComboBox<?> sectorType;

    @FXML
    private ComboBox<?> committee1;
    
    

    @FXML
    private TableView<?> members;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<?, ?> IdNumber;

    @FXML
    private TableColumn<?, ?> Gender;

    @FXML
    private TableColumn<?, ?> Birthday;

    @FXML
    private TableColumn<?, ?> Baptized;

    @FXML
    private TableColumn<?, ?> Active;

    @FXML
    private TableColumn<?, ?> PhoneNumber;

    @FXML
    private TableColumn<?, ?> Sector;

    @FXML
    private TableColumn<?, ?> Committee;
    
    private Church church;
    
    public SearchController(Church church) {
		this.church = church;
	}
    
    @FXML
    public void initialize() {
    	loadMembers();
		
    }
    
    private void loadMembers() {
    	
    }
    
    @FXML
    void search(ActionEvent event) {
    	
    }
    
}
