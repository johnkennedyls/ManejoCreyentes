package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RecordsController {
	@FXML
    private TableView<?> birthdays;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> idNumber;

    @FXML
    private TableColumn<?, ?> gender;

    @FXML
    private TableColumn<?, ?> birthday;

    @FXML
    private TableColumn<?, ?> baptized;

    @FXML
    private TableColumn<?, ?> active;

    @FXML
    private TableColumn<?, ?> phoneNumber;

    @FXML
    private TableColumn<?, ?> sector;

    @FXML
    private TableColumn<?, ?> committee;

    @FXML
    private TableView<?> upcomingbirthdays;

    @FXML
    private TableColumn<?, ?> UName;

    @FXML
    private TableColumn<?, ?> UIdNumber;

    @FXML
    private TableColumn<?, ?> UGender;

    @FXML
    private TableColumn<?, ?> UBirthday;

    @FXML
    private TableColumn<?, ?> UBaptized;

    @FXML
    private TableColumn<?, ?> UActive;

    @FXML
    private TableColumn<?, ?> UPhoneNumber;

    @FXML
    private TableColumn<?, ?> USector;

    @FXML
    private TableColumn<?, ?> UCommittee;

    @FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private CheckBox baptizedCB;

    @FXML
    private CheckBox activeCB;

    @FXML
    private TableView<?> members;

    @FXML
    private TableColumn<?, ?> MName;

    @FXML
    private TableColumn<?, ?> MIdNumber;

    @FXML
    private TableColumn<?, ?> MGender;

    @FXML
    private TableColumn<?, ?> MBirthday;

    @FXML
    private TableColumn<?, ?> MBaptized;

    @FXML
    private TableColumn<?, ?> MActive;

    @FXML
    private TableColumn<?, ?> MPhoneNumber;

    @FXML
    private TableColumn<?, ?> MSector;

    @FXML
    private TableColumn<?, ?> MCommittee;

    @FXML
    void search(ActionEvent event) {

    }
    
}
