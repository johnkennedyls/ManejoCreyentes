package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private ComboBox<?> sectorType;

    @FXML
    private ComboBox<?> officeType;

    @FXML
    private TextArea observationsField;

    @FXML
    void signUp(ActionEvent event) {

    }
    
}
