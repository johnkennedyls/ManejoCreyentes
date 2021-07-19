package ui;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

public class BirthdaysController {
	
	private Church myChurch;
	
	
	@FXML
    private TableView<Member> birthdays;

    @FXML
    private TableColumn<Member, String> name;   

    @FXML
    private TableColumn<Member, String> phoneNumber;

    @FXML
    private TableColumn<Member, String> sector;

   
    @FXML
    private TableView<Member> upcomingbirthdays;

    @FXML
    private TableColumn<Member, String> UName;
   
    @FXML
    private TableColumn<Member, String>  UTextForUnBirthDay;;

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
    
    
    
    public  BirthdaysController( Church myChurch) {
		this.myChurch = myChurch;
	}

    @FXML
    void search(ActionEvent event) {
    	
    }
    @FXML
    public void initialize() {
    	loadBirthdaysTable(myChurch.ToListodayBirthays());
		loadUpcomingBirthdaysTable(myChurch.ToListnextBirthays());
		
    }
    
    private void loadBirthdaysTable(List<Member> birthdaysList) {
		ObservableList<Member> observableList;
		observableList = FXCollections.observableArrayList(birthdaysList);
		birthdays.setItems(observableList);

		name.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));		
		phoneNumber.setCellValueFactory(new PropertyValueFactory<Member, String>("phoneNumber"));
		sector.setCellValueFactory(new PropertyValueFactory<Member, String>("sector"));
		
	}
    
    private void loadUpcomingBirthdaysTable(List<Member> upcomingbirthday) {
		ObservableList<Member> observableList;
		observableList = FXCollections.observableArrayList(upcomingbirthday);		
		upcomingbirthdays.setItems(observableList);

		UName.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
		
		UTextForUnBirthDay.setCellValueFactory(new PropertyValueFactory<Member, String>("textForUnbirthday"));
	}
    
}
