package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.OfficeType;
import model.SectorType;

public class RegisterController {
	
	@FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField genderField;

    @FXML
    private DatePicker birthday;

    @FXML
    private CheckBox baptized;

    @FXML
    private CheckBox active;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField sectorField;

    @FXML
    private TextField committeeField;

    @FXML
    private ComboBox<String> sectorType;

    @FXML
    private ComboBox<String> officeType;

    @FXML
    private TextArea observationsField;
    
    @FXML
    public void initialize() {
        loadOfficeType();
        loadSectorType();
    }
    
    @FXML
    void signUp(ActionEvent event) {

    }
    
    private void loadSectorType() {
    	for (SectorType st : SectorType.values()) {
    		sectorType.getItems().add(st.toString());
		}
    	
    }
    
    private void loadOfficeType() {
    	for (OfficeType ot : OfficeType.values()) {
    		officeType.getItems().add(ot.toString());
		}
    	
    }
    
}
