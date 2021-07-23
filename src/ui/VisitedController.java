package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    
    public VisitedController(Church church) {
		this.church = church;
		
	}
    
    @FXML
    public void initialize() {
    	loadVisitedTable();
		
    }
    
    private void loadVisitedTable() {
		
	}
    
    @FXML
    void toVisit(ActionEvent event) {

    }
    
}
