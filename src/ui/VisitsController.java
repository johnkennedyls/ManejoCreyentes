package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import model.Church;

public class VisitsController {
	
	@FXML
    private Tab toVisitTab;

    @FXML
    private Tab visitedTab;
	
	private Church church;
    
    public VisitsController(Church church) {
		this.church = church;
	}
    
    @FXML
    public void initialize() {
    	loadToVisit();
		loadVisited();
		
    }
    
    private void loadToVisit() {
    	try {
    		ToVisitController toVisitController = new ToVisitController(church);
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/toVisit.fxml"));
    		fxmlLoader.setController(toVisitController);
    		Parent Pane = fxmlLoader.load();
    		toVisitTab.setContent(Pane);
    		
    	}catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    	
		
    }
    
    private void loadVisited() {
    	try {
    		VisitedController visitedController = new VisitedController(church);
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/visited.fxml"));
    		fxmlLoader.setController(visitedController);
    		Parent Pane = fxmlLoader.load();
    		visitedTab.setContent(Pane);
    		
    	}catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    	
    }
    
}
