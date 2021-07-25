package ui;

import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import exceptions.EmptyDataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Church;
import model.OfficeType;
import javafx.scene.control.Alert.AlertType;

public class RegisterController {
	private Church myChurch;

	@FXML
	private TextField nameField;

	@FXML
	private TextField idField;

	@FXML
	private ComboBox<String> genderComboBox;

	@FXML
	private DatePicker birthday;

	@FXML
	private CheckBox baptized;

	@FXML
	private CheckBox active;

	@FXML
	private TextField phoneNumberField;

	@FXML
	private ComboBox<String> sectorType;

	@FXML
	private ComboBox<String> committee;
	
	@FXML
	private ComboBox<String> officeType;

	@FXML
	private TextArea observationsField;

	public RegisterController(Church myChurch) {
		this.myChurch = myChurch;
	}

	@FXML
	public void initialize() {
		loadGender();
		loadCommittees();
		loadSectorType();
		loadofficeTypes();

	}

	@FXML
	void signUp(ActionEvent event) throws IOException {
		try {
			validateEmptyFields();
			String name = nameField.getText();
			String idNumber = idField.getText();
			String gender = genderComboBox.getValue();
			LocalDate birthdayLocalDate = birthday.getValue();
			String memberBirthday = birthdayLocalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			boolean baptizedBool = baptized.isSelected();
			boolean activeBool = active.isSelected();
			String observations = observationsField.getText();
			String phoneNumber = phoneNumberField.getText();
			String sector = sectorType.getValue();
			String MemberCommittee = committee.getValue();
			OfficeType charge = OfficeType.valueOf(officeType.getValue());

			myChurch.createGeneralMember(name, idNumber, gender, memberBirthday, baptizedBool, activeBool, observations,
					phoneNumber, sector, MemberCommittee, charge);

			resetForm();
			System.out.println("registered :)");

			resetForm();
			

		} catch (EmptyDataException emptyDataException) {
			emptyFieldsAlert(emptyDataException.getMessage());
		}
	}

	private void resetForm() {
		nameField.clear();
		idField.clear();
		genderComboBox.setValue(null);
		birthday.setValue(null);
		baptized.setSelected(false);
		active.setSelected(false);
		observationsField.clear();
		phoneNumberField.clear();
		sectorType.setValue(null);
		committee.setValue(null);

	}

	private void loadGender() {

		genderComboBox.getItems().add("Hombre");
		genderComboBox.getItems().add("Mujer");
	}

	private void loadSectorType() {
		for (int i = 0; i < myChurch.getTheSectors().size(); i++) {
			sectorType.getItems().add(myChurch.getTheSectors().get(i).getName());
		}
	}

	private void loadCommittees() {
		for (int i = 0; i < myChurch.getTheCommittees().size(); i++) {
			committee.getItems().add(myChurch.getTheCommittees().get(i).getName());
		}
	}
	
	private void loadofficeTypes() {
		officeType.getItems().add(OfficeType.PRESIDENTE.toString());
		officeType.getItems().add(OfficeType.VICEPRESIDENTE.toString());
		officeType.getItems().add(OfficeType.SECRETARIO.toString());
		officeType.getItems().add(OfficeType.TESORERO.toString());
		officeType.getItems().add(OfficeType.VOCAL.toString());
		officeType.getItems().add(OfficeType.AUXILIAR.toString());
		officeType.getItems().add(OfficeType.FISCAL.toString());
		officeType.getItems().add(OfficeType.NINGUNO.toString());
		
	}

	private void validateEmptyFields() throws EmptyDataException {
		if (nameField.getText().equals("")) {
			throw new EmptyDataException();
		}

		if (idField.getText().equals("")) {
			throw new EmptyDataException();
		}

		LocalDate localDate = birthday.getValue();

		if (localDate == null) {
			throw new EmptyDataException();
		}

		if (phoneNumberField.getText().equals("")) {
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
