package ui;

import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import exceptions.EmptyDataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import model.Church;
import model.Member;

public class EditController {
	 @FXML
	    private TextField name;

	    @FXML
	    private TextField id;

	    @FXML
	    private ComboBox<String> gender;

	    @FXML
	    private DatePicker birthday;

	    @FXML
	    private CheckBox baptized;

	    @FXML
	    private CheckBox active;

	    @FXML
	    private TextField phoneNumber;

	    @FXML
	    private ComboBox<String> sector;

	    @FXML
	    private ComboBox<String> committee;

	    @FXML
	    private TextArea observations;
	
	private Church church;
	private BorderPane mainPane;
	private Member member;
    
    public EditController(Church church,BorderPane mainPane,Member member) {
		this.church = church;
		this.mainPane = mainPane;
		this.member = member;
		
	}
    
    @FXML
    public void initialize() {
    	loadMemberInfo();
		loadComboBoxes();
    }
    
    private void loadMemberInfo() {
    	name.setText(member.getName());
    	id.setText(member.getIdNumber());
    	gender.getItems().addAll("Hombre","Mujer");
		
    	if (member.getGender().equals("Hombre")) {
    		gender.getSelectionModel().select(0);
		}else {
			gender.getSelectionModel().select(1);
		}
    	
    	
    	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	String dateString = member.getBirthday();
    	 
    	LocalDate localDateObj = LocalDate.parse(dateString, dateTimeFormatter);
    	
    	birthday.setValue(localDateObj);
    	
    	if (member.isBaptized()) {
    		baptized.setSelected(true);
		}else {
			baptized.setSelected(false);
		}
    	
    	if (member.isActive()) {
    		active.setSelected(true);
		}else {
			active.setSelected(false);
		}
    	
    	phoneNumber.setText(member.getPhoneNumber());
    	
    	int sectorIndex = 0;
    	for (int i = 0; i < church.getTheSectors().size(); i++) {
			sector.getItems().add(church.getTheSectors().get(i).getName());
			if (church.getTheSectors().get(i).getName().equals(member.getSector())) {
				sectorIndex = i;
			}
		}
    	
    	sector.getSelectionModel().select(sectorIndex);
    	
    	int committeeIndex = 0;
    	for (int i = 0; i < church.getTheCommittees().size(); i++) {
    		committee.getItems().add(church.getTheCommittees().get(i).getName());
			if (church.getTheCommittees().get(i).getName().equals(member.getCommittee())) {
				committeeIndex = i;
			}
		}
    	
    	committee.getSelectionModel().select(committeeIndex);
    	
    }
    
    private void loadComboBoxes() {
    	
    	
    	for (int i = 0; i < church.getTheCommittees().size(); i++) {
			committee.getItems().add(church.getTheCommittees().get(i).getName());
		}
    	
    }
    
    @FXML
    void edit(ActionEvent event) {
    	try {
    		validateEmptyFields();
    		
		} catch (EmptyDataException emptyDataException) {
			emptyFieldsAlert(emptyDataException.getMessage());
		}
    }

    @FXML
    void goBack(ActionEvent event) {
    	loadInfoWindow();
    }
    
    private void loadInfoWindow() {
    	try {
    		InfoController infoController = new InfoController(church,mainPane,member);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/info.fxml"));
			fxmlLoader.setController(infoController);
			Parent Pane = fxmlLoader.load();
			mainPane.setCenter(Pane);
			

		} catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    	
    }
    
    private void validateEmptyFields() throws EmptyDataException{
    	if (name.getText().equals("")) {
			throw new EmptyDataException();
		}
    	
    	if (id.getText().equals("")) {
			throw new EmptyDataException();
		}
    	
    	LocalDate localDate = birthday.getValue();
    	
    	if (localDate == null) {
			throw new EmptyDataException();
		}
    	
    	if (phoneNumber.getText().equals("")) {
			throw new EmptyDataException();
		}
    	
    }
    
    private void emptyFieldsAlert(String message) {
    	Alert emptyFieldsAlert = new Alert(AlertType.ERROR);
    	emptyFieldsAlert.setTitle("Datos vacíos.");
    	emptyFieldsAlert.setHeaderText(message);
    	emptyFieldsAlert.showAndWait();

    }
    
}
