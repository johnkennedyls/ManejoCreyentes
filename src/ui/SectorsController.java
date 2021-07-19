package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Church;

public class SectorsController {
	@FXML
    private ComboBox<?> sectorOne;

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
    private ComboBox<?> sectorTwo;

    @FXML
    private TableView<?> birthdays1;

    @FXML
    private TableColumn<?, ?> name1;

    @FXML
    private TableColumn<?, ?> idNumber1;

    @FXML
    private TableColumn<?, ?> gender1;

    @FXML
    private TableColumn<?, ?> birthday1;

    @FXML
    private TableColumn<?, ?> baptized1;

    @FXML
    private TableColumn<?, ?> active1;

    @FXML
    private TableColumn<?, ?> phoneNumber1;

    @FXML
    private TableColumn<?, ?> sector1;

    @FXML
    private TableColumn<?, ?> committee1;
    
    private Church church;
    
    public SectorsController(Church church) {
		this.church = church;
	}
    
    @FXML
    void transferOneToTwo(ActionEvent event) {

    }

    @FXML
    void transferTwoToOne(ActionEvent event) {

    }
    
}
