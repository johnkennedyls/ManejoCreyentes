package ui;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Church;
import model.Sector;

public class SectorInfoController {
	@FXML
    private Label name;
	/*
    @FXML
    private Label lider;
    */
    private Church church;
    private Sector sector;
    
    public SectorInfoController(Church church,Sector sector) {
		this.church = church;
		this.sector = sector;
		
	}
    
    @FXML
    public void initialize() {
    	loadInfo();
		
    }
    
    private void loadInfo() {
    	name.setText(sector.getName());
    }
    /*
    @FXML
    void edit(ActionEvent event) {
    	
    }
	*/
    /*
    @FXML
    void remove(ActionEvent event) {
    	boolean removed = removingSectorAlert();
    	if (removed) {
    		name.getScene().getWindow().hide();
		}
    	
    }
    */
    /*
    private boolean removingSectorAlert() {
    	Alert emptyFieldsAlert = new Alert(AlertType.WARNING);
    	emptyFieldsAlert.setTitle("Eliminar Sector.");
    	emptyFieldsAlert.setHeaderText("El sector será ELIMINADO de los registros.");
    	
    	ButtonType cancelButtonType = new ButtonType("Cancel",ButtonData.CANCEL_CLOSE);
    	emptyFieldsAlert.getDialogPane().getButtonTypes().add(cancelButtonType);
    	
    	Optional<ButtonType> result = emptyFieldsAlert.showAndWait();
    	if (result.isPresent() && result.get() == ButtonType.OK) {
    		memberRemovedAlert();
    		
		}else {
			return false;
		}
    	return true;
    }
    */
    /*
    private void memberRemovedAlert() {
    	Alert emptyFieldsAlert = new Alert(AlertType.INFORMATION);
    	emptyFieldsAlert.setTitle("Sector Eliminado.");
    	emptyFieldsAlert.setHeaderText("El sector fué eliminado de los registros.");
    	emptyFieldsAlert.showAndWait();

    }
    */
    
    @FXML
    void close(ActionEvent event) {
    	name.getScene().getWindow().hide();
    }
    
}
