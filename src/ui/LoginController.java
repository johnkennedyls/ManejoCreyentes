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
import model.Church;

public class LoginController {
	
	private Church church;
	
	public LoginController() {
		church = new Church("default", "Cali");
		
	}
	
	@FXML
    private PasswordField passwordField;

    @FXML
    private TextField userNameField;

    @FXML
    void login(ActionEvent event) {
    	try {
			if (verifyLogin()) {
				openPrincipalWindow();
	    		
	    		passwordField.getScene().getWindow().hide();
	    		
			}else {
				//TODO: add invalid user exception to throw
				
			}
    		
    		
		} catch (IOException ioException) {

			ioException.printStackTrace();
			
		}
    	
    	
    }
    
    private void openPrincipalWindow() throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("fxml/principal.fxml"));
		Scene scene = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(scene);
		secondaryStage.setTitle("Principal");
		secondaryStage.setResizable(false);
		secondaryStage.show();
    }
    
    private boolean verifyLogin() {
    	String name = church.getMinister().getName();
    	String password = church.getMinister().getPassword();
    	
    	String inputName = userNameField.getText();
    	String inputPassword = passwordField.getText();
    	
    	if (name.equals(inputName) && password.equals(inputPassword)) {
			return true;
		}
    	
    	return false;
    }

}

