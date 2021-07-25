package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Church;

public class MenuController {
	@FXML
    private AnchorPane mainPane;
	
	private Church church;
    
    public MenuController(Church church) {
		this.church = church;
	}
	
	@FXML
    void openFollowers(MouseEvent event) {
		try {
			openPrincipalWindow("Followers");
			
			mainPane.getScene().getWindow().hide();
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		
    }
	
    @FXML
    void openSectors(MouseEvent event) {
    	try {
			openPrincipalWindow("Sectors");
			
			mainPane.getScene().getWindow().hide();
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
    }
    
    @FXML
    void openCommittees(MouseEvent event) {
    	try {
			openPrincipalWindow("Committees");
			
			mainPane.getScene().getWindow().hide();
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
    }
    
	@FXML
    void openBirthdays(MouseEvent event) {
		try {
			openPrincipalWindow("Birthdays");
			
			mainPane.getScene().getWindow().hide();
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
    }
	
    @FXML
    void openVisits(MouseEvent event) {
    	try {
			openPrincipalWindow("Visits");
			
			mainPane.getScene().getWindow().hide();
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
    }
	
    @FXML
    void openOptions(MouseEvent event) {
    	try {
			openPrincipalWindow("Options");
			
			mainPane.getScene().getWindow().hide();
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
    }
	
	private void openPrincipalWindow(String startingWindow) throws IOException {
		PrincipalController principalController = new PrincipalController(church,startingWindow);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/principal.fxml"));
		fxmlLoader.setController(principalController);
		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(scene);
		secondaryStage.setTitle("Principal");
		secondaryStage.setResizable(false);
		secondaryStage.show();
	}
	
	@FXML
    void logOff(ActionEvent event) {
		try {
			openLoginWindow();
			mainPane.getScene().getWindow().hide();

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
	
}
