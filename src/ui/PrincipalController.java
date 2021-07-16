package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Church;

public class PrincipalController {
	private Church myChurch;
	 	
		@FXML
		private BorderPane principalWindow;
		
		
		public  PrincipalController(Church myChurch) throws IOException {
			this.myChurch = myChurch;
			
			
		}
		@FXML
	    public void initialize() {
	        openFollowers();
			
			
	    }
	
    	@FXML
    	void openFollowers(ActionEvent event) {
    		openFollowers();
    		
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
    	
    	private void openFollowers() {
    		try {
    			FollowersController followersController = new FollowersController(myChurch);
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/followers.fxml"));
    			fxmlLoader.setController(followersController);
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
				BirthdaysController recordsController = new BirthdaysController(myChurch);
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/records.fxml"));
    			fxmlLoader.setController(recordsController);
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
