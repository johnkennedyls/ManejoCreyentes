package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import model.Church;

public class FollowersController {
	
	@FXML
    private Tab recordsTab;

    @FXML
    private Tab registerTab;

    @FXML
    private Tab searchTab;
    
    private Church church;
    
    public FollowersController(Church church) {
		this.church = church;
		
	}
    
    @FXML
    public void initialize() {
    	loadRecords();
		loadRegister();
		loadSearch();
		
    }
    
    private void loadRecords() {
    	try {
    		RecordsController recordsController = new RecordsController(church);
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/records.fxml"));
    		fxmlLoader.setController(recordsController);
    		Parent Pane = fxmlLoader.load();
    		recordsTab.setContent(Pane);
    		
    	}catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    	
		
    }
    
    private void loadRegister() {
    	try {
    		RegisterController registerController = new RegisterController(church);
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register.fxml"));
    		fxmlLoader.setController(registerController);
    		Parent Pane = fxmlLoader.load();
    		registerTab.setContent(Pane);
    		
    	}catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    	
    }
    
    private void loadSearch() {
    	try {
    		SearchController searchController = new SearchController(church);
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/search.fxml"));
    		fxmlLoader.setController(searchController);
    		Parent Pane = fxmlLoader.load();
    		searchTab.setContent(Pane);
    		
    	}catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    	
    }
}
