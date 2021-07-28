package ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Church;
import model.Member;

public class ToVisitController {
	
	@FXML
	private TableView<Member> members;
	
	@FXML
	private TableColumn<Member,String> Name;
	
	@FXML
	private TableColumn<Member, String> IdNumber;
	
	@FXML
	private TableColumn<Member, String> Gender;
	
	@FXML
	private TableColumn<Member, String> Birthday;
	
	@FXML
	private TableColumn<Member, Boolean> Baptized;
	
	@FXML
	private TableColumn<Member, Boolean> Active;
	
	@FXML
	private TableColumn<Member, String> PhoneNumber;
	
	@FXML
	private TableColumn<Member, String> Sector;
	
	@FXML
	private TableColumn<Member, String> Committee;
	
	private Church church;
    
    public ToVisitController(Church church) {
		this.church = church;
		
	}
    
    @FXML
    public void initialize() {
    	loadToVisitTable(Church.getNoVisited());
		
    }
    
    private void loadToVisitTable(List<Member> membersList) {
    	
		ObservableList<Member> observableList;
		observableList = FXCollections.observableArrayList(membersList);
		members.setItems(observableList);
		
		Name.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
		IdNumber.setCellValueFactory(new PropertyValueFactory<Member, String>("idNumber"));
		Gender.setCellValueFactory(new PropertyValueFactory<Member, String>("gender"));
		Birthday.setCellValueFactory(new PropertyValueFactory<Member, String>("birthday"));
		Baptized.setCellValueFactory(new PropertyValueFactory<Member, Boolean>("baptized"));
		Active.setCellValueFactory(new PropertyValueFactory<Member, Boolean>("active"));
		PhoneNumber.setCellValueFactory(new PropertyValueFactory<Member, String>("phoneNumber"));
		Sector.setCellValueFactory(new PropertyValueFactory<Member, String>("sector"));
		Committee.setCellValueFactory(new PropertyValueFactory<Member, String>("committee"));
		
	}
    
    @FXML
    void visited(ActionEvent event) {
    	Member selectedMember = members.getSelectionModel().getSelectedItem();
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    	LocalDateTime now = LocalDateTime.now(); 
    	selectedMember.setDateCapture(now);
    	
    	church.moveTovisited(selectedMember);
    	
    	loadToVisitTable(Church.getNoVisited());
    	
    	moveTovisitedAlert();
    	
    }
    
    private void moveTovisitedAlert() {
    	Alert emptyFieldsAlert = new Alert(AlertType.ERROR);
		emptyFieldsAlert.setTitle("Agregado a por visitar");
		emptyFieldsAlert.setHeaderText("El miembro ha sido agregado a la lista de visitados y removido de la lista de por visitar");
		emptyFieldsAlert.showAndWait();
		
    }
    
}
