package ui;

import java.io.IOException;

import exceptions.InvalidUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
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
				throw new InvalidUserException();
				
			}
    		
    		
		} catch (IOException ioException) {

			ioException.printStackTrace();
			
		} catch (InvalidUserException invalidUserException) {
			invalidUserException.printStackTrace();
			
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
    	/*
    	String name = church.getMinister().getName();
    	String password = church.getMinister().getPassword();
    	
    	String inputName = userNameField.getText();
    	String inputPassword = passwordField.getText();
    	
    	if (name.equals(inputName) && password.equals(inputPassword)) {
			return true;
		}
    	
    	return false;*/
    	return true;
    }
    
    @FXML
    void developersInfo(ActionEvent event) {
    	Stage popupwindow=new Stage();
        
    	popupwindow.initModality(Modality.APPLICATION_MODAL);
    	popupwindow.setTitle("Desarrolladores");
    	      
    	      
    	Label label1= new Label("Info1\n" + "Info2\n" + "Info3\n" + "Info4\n" + "" + "");
    	      
    	     
    	Button button1= new Button("Cerrar");
    	     
    	     
    	button1.setOnAction(e -> popupwindow.close());
    	     
    	     

    	VBox layout= new VBox(10);
    	     
    	      
    	layout.getChildren().addAll(label1, button1);
    	      
    	layout.setAlignment(Pos.CENTER);
    	      
    	Scene scene1= new Scene(layout, 300, 250);
    	      
    	popupwindow.setScene(scene1);
    	      
    	popupwindow.showAndWait();
    }

}

