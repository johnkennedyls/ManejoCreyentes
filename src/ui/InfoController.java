package ui;

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.BorderPane;
import model.Church;

public class InfoController {
	@FXML
    private Label name;

    @FXML
    private Label id;

    @FXML
    private Label gender;

    @FXML
    private Label birthday;

    @FXML
    private Label baptized;

    @FXML
    private Label active;

    @FXML
    private Label phoneNumber;

    @FXML
    private Label sector;

    @FXML
    private Label phoneNumber1;

    @FXML
    private Label sector1;

    @FXML
    private Label committee;
	
	private Church church;
	private BorderPane mainPane;
    
    public InfoController(Church church,BorderPane mainPane) {
		this.church = church;
		this.mainPane = mainPane;
	}
    
    @FXML
    public void initialize() {
    	loadInfo();
		
    }
    
    private void loadInfo() {
    	church.getTheCommittees();
    }
    
    @FXML
    void edit(ActionEvent event) {
    	openEdit();
    }
    
    private void openEdit() {
    	try {
    		EditController editController = new EditController(church,mainPane);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/edit.fxml"));
			fxmlLoader.setController(editController);
			Parent Pane = fxmlLoader.load();
			mainPane.setCenter(Pane);
			
			//committee.getScene().getWindow().hide();

		} catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    }
    
    @FXML
    void remove(ActionEvent event) {
    	boolean removed = removingMemberAlert();
    	if (removed) {
    		committee.getScene().getWindow().hide();
		}

    }
    
    private boolean removingMemberAlert() {
    	Alert emptyFieldsAlert = new Alert(AlertType.WARNING);
    	emptyFieldsAlert.setTitle("Eliminar miembro.");
    	emptyFieldsAlert.setHeaderText("El miembro será ELIMINADO de los registros.");
    	
    	ButtonType cancelButtonType = new ButtonType("Cancel",ButtonData.CANCEL_CLOSE);
    	emptyFieldsAlert.getDialogPane().getButtonTypes().add(cancelButtonType);
    	
    	Optional<ButtonType> result = emptyFieldsAlert.showAndWait();
    	if (result.isPresent() && result.get() == ButtonType.OK) {
    		memberRemovedAlert();
    		return true;
		}else {
			return false;
		}
    	
    }
    
    private void memberRemovedAlert() {
    	Alert emptyFieldsAlert = new Alert(AlertType.INFORMATION);
    	emptyFieldsAlert.setTitle("Registro Eliminado.");
    	emptyFieldsAlert.setHeaderText("El miembro fué eliminado de los registros.");
    	emptyFieldsAlert.showAndWait();

    }
    
    @FXML
    void close(ActionEvent event) {
    	committee.getScene().getWindow().hide();
    	
    }
    
}
