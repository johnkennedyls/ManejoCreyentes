package ui;

import java.io.IOException;
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

public class VisitedController {
	
	@FXML
	private TableView<Member> members;
	
	@FXML
	private TableColumn<Member,String> Name;
	
	@FXML
	private TableColumn<Member, String> IdNumber;
	
	@FXML
	private TableColumn<Member, String> PhoneNumber;
	
	@FXML
	private TableColumn<Member, String> Sector;

	private Church church;
    
    public VisitedController(Church church) {
		this.church = church;
		
	}
    
    @FXML
    public void initialize() {
    	loadVisitedTable(church.getVisited());
		
    }
    
    private void loadVisitedTable(List<Member> membersList) {

		ObservableList<Member> observableList;
		observableList = FXCollections.observableArrayList(membersList);
		members.setItems(observableList);

		Name.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
		IdNumber.setCellValueFactory(new PropertyValueFactory<Member, String>("idNumber"));
		PhoneNumber.setCellValueFactory(new PropertyValueFactory<Member, String>("phoneNumber"));
		Sector.setCellValueFactory(new PropertyValueFactory<Member, String>("sector"));

	}
    
    @FXML
    void toVisit(ActionEvent event) {
    	try {
    		Member selectedMember = members.getSelectionModel().getSelectedItem();
        	church.moveToNovisited(selectedMember);
        	
        	loadVisitedTable(church.getVisited());
        	
        	moveToTovisitAlert();
        	
		} catch (IOException ioException) {
			memberNotMovedAlert();
		}
    	
    	
    }
    
    private void memberNotMovedAlert() {
    	Alert emptyFieldsAlert = new Alert(AlertType.ERROR);
		emptyFieldsAlert.setTitle("Error al agregar a por visitar");
		emptyFieldsAlert.setHeaderText("El miembro NO ha sido agregado a la lista de por visitar.");
		emptyFieldsAlert.showAndWait();
		
    }
    
    private void moveToTovisitAlert() {
    	Alert emptyFieldsAlert = new Alert(AlertType.ERROR);
		emptyFieldsAlert.setTitle("Agregado a por visitar");
		emptyFieldsAlert.setHeaderText("El miembro ha sido agregado a la lista de visitados y removido de la lista de por visitar");
		emptyFieldsAlert.showAndWait();
		
    }
    
    
}
