package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import model.Church;
import model.Member;

public class MemberInfoController {
	
	@FXML
    private BorderPane mainPane;
	
	private Church church;
    
	private Member member;
	
	private RecordsController recordsController;
	private SearchController searchController;
	
    public MemberInfoController(Church church,Member member,RecordsController recordsController) {
		this.church = church;
		this.member = member;
		this.recordsController = recordsController;
		this.searchController = null;
		
	}
    
    public MemberInfoController(Church church,Member member,SearchController searchController) {
    	this.church = church;
		this.member = member;
		this.recordsController = null;
		this.searchController = searchController;
		
    }
		 
    @FXML
    public void initialize() {
    	loadInfo();
    	
    }
    
    private void loadInfo() {
    	try {
    		InfoController infoController = null;
    		
    		if (recordsController != null) {
        		recordsController.loadMembers();
        		infoController = new InfoController(church,mainPane,member,recordsController);
    		}
        	
        	if (searchController != null) {
        		searchController.search();
        		infoController = new InfoController(church,mainPane,member,searchController);
        		
    		}
    		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/info.fxml"));
			fxmlLoader.setController(infoController);
			Parent Pane = fxmlLoader.load();
			mainPane.setCenter(Pane);
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    }
	
}
