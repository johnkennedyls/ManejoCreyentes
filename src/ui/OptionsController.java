package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OptionsController {
	@FXML
    void changePassword(ActionEvent event) {
		try {
			openChangePasswordWindow();
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
		
    }
	
	private void openChangePasswordWindow() throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("fxml/changePassword.fxml"));
		Scene scene = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(scene);
		secondaryStage.setTitle("Actualizar Contraseña");
		secondaryStage.setResizable(false);
		secondaryStage.show();
    }

    @FXML
    void createSector(ActionEvent event) {
    	
    }
    
}
