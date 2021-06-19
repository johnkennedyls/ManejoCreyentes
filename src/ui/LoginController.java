package ui;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
    private PasswordField passwordField;

    @FXML
    private TextField userNameField;

    @FXML
    void login(ActionEvent event) {
    	try {
			
    		openPrincipalWindow();
    		
    		passwordField.getScene().getWindow().hide();
    		
		} catch (IOException ioException) {
			// TODO: handle exception
			ioException.printStackTrace();
			
		}
    	
    	verifyLogin();
    }
    
    private void openPrincipalWindow() throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("fxml/principal.fxml"));
		Scene scene = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(scene);
		secondaryStage.setTitle("Acceder");
		secondaryStage.setResizable(false);
		secondaryStage.show();
		
    }
    
    private boolean verifyLogin() {
    	return false;
    }

}

