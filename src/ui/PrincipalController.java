package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class PrincipalController {
	 	
		@FXML
		private BorderPane principalWindow;
	
    	@FXML
    	void openRegister(ActionEvent event) {
    		try {
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register.fxml"));
				Parent Pane = fxmlLoader.load();
				principalWindow.setRight(Pane);

    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
    		
    		
    	}
    
		@FXML
	    void openCommittees(ActionEvent event) {
			try {
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/committees.fxml"));
				Parent Pane = fxmlLoader.load();
				principalWindow.setRight(Pane);

    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
			
	    }
		
		@FXML
	    void openRecords(ActionEvent event) {
			try {
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/records.fxml"));
				Parent Pane = fxmlLoader.load();
				principalWindow.setRight(Pane);

    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
			
	    }
		
	    @FXML
	    void openOptions(ActionEvent event) {
	    	try {
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/options.fxml"));
				Parent Pane = fxmlLoader.load();
				principalWindow.setRight(Pane);

    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
	    	
	    }


}
