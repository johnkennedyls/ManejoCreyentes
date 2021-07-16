package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import model.Church;

public class MemberInfoController {
	
	@FXML
    private BorderPane mainPane;
	
	private Church church;
    
    public MemberInfoController(Church church) {
		this.church = church;
	}
    
    @FXML
    public void initialize() {
    	loadInfo();
    }
    
    private void loadInfo() {
    	try {
    		InfoController infoController = new InfoController(church);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/info.fxml"));
			fxmlLoader.setController(infoController);
			Parent Pane = fxmlLoader.load();
			mainPane.setCenter(Pane);
			

		} catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    }
	
}
