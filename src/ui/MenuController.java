package ui;

import java.io.IOException;

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
			openPrincipalWindow();
			
			mainPane.getScene().getWindow().hide();
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		
    }
	
	private void openPrincipalWindow() throws IOException {
		PrincipalController principalController = new PrincipalController(church,"Followers");
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
	
}
