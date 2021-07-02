package ui;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalController {
	 	
		@FXML
		private BorderPane principalWindow;
		
		@FXML
	    public void initialize() {
	        openRegister();
			
			
	    }
	
    	@FXML
    	void openRegister(ActionEvent event) {
    		openRegister();
    		
    	}
    	
    	@FXML
        void logOff(ActionEvent event) {
    		try {
    			openLoginWindow();
    			principalWindow.getScene().getWindow().hide();

    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
        }
    	
    	private void openLoginWindow() throws IOException{
        	Parent root = FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
    		Scene scene = new Scene(root);
    		Stage secondaryStage = new Stage();
    		secondaryStage.setScene(scene);
    		secondaryStage.setTitle("Principal");
    		secondaryStage.setResizable(false);
    		secondaryStage.show();
        }
    	
    	private void openRegister() {
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
