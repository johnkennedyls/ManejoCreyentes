package ui;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;
import model.Church;
import model.Committee;

public class CommitteeInfoController {
	@FXML
    private Label name;
    
    private Church church;
    private Committee committee;
    public CommitteeInfoController(Church church, Committee committtee) {
		this.church = church;
		this.committee = committtee;
	}
    
    @FXML
    public void initialize() {
    	loadInfo();
		
    }
    
    private void loadInfo() {
    	name.setText(committee.getName());
    }
    
    @FXML
    void edit(ActionEvent event) {
    	try {
    		EditCommitteeController editCommitteeController = new EditCommitteeController(church);
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/editCommittee.fxml"));
    		fxmlLoader.setController(editCommitteeController);
    		Parent root = fxmlLoader.load();

    		Scene scene = new Scene(root);
    		Stage secondaryStage = new Stage();
    		secondaryStage.setScene(scene);
    		secondaryStage.setTitle("Información");
    		secondaryStage.setResizable(false);
    		secondaryStage.show();
    		
		} catch (IOException ioException) {
			//TODO
		}
    	
    }

    @FXML
    void remove(ActionEvent event) {
    	boolean removed = removingCommitteeAlert();
    	if (removed) {
    		name.getScene().getWindow().hide();
		}
    	
    }
    
    private boolean removingCommitteeAlert() {
    	Alert emptyFieldsAlert = new Alert(AlertType.WARNING);
    	emptyFieldsAlert.setTitle("Eliminar Comité.");
    	emptyFieldsAlert.setHeaderText("El comité será ELIMINADO de los registros.");
    	
    	ButtonType cancelButtonType = new ButtonType("Cancel",ButtonData.CANCEL_CLOSE);
    	emptyFieldsAlert.getDialogPane().getButtonTypes().add(cancelButtonType);
    	
    	Optional<ButtonType> result = emptyFieldsAlert.showAndWait();
    	if (result.isPresent() && result.get() == ButtonType.OK) {
    		committeeRemovedAlert();
    		
		}else {
			return false;
		}
    	return true;
    }
    
    private void committeeRemovedAlert() {
    	Alert emptyFieldsAlert = new Alert(AlertType.INFORMATION);
    	emptyFieldsAlert.setTitle("Comité Eliminado.");
    	emptyFieldsAlert.setHeaderText("El comité fué eliminado de los registros.");
    	emptyFieldsAlert.showAndWait();

    }
    
    @FXML
    void close(ActionEvent event) {
    	name.getScene().getWindow().hide();
    }
    
}
