package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Church;

public class RecordsController {
	@FXML
    private TableView<?> members;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<?, ?> IdNumber;

    @FXML
    private TableColumn<?, ?> Gender;

    @FXML
    private TableColumn<?, ?> Birthday;

    @FXML
    private TableColumn<?, ?> Baptized;

    @FXML
    private TableColumn<?, ?> Active;

    @FXML
    private TableColumn<?, ?> PhoneNumber;

    @FXML
    private TableColumn<?, ?> Sector;

    @FXML
    private TableColumn<?, ?> Committee;
    
    private Church church;
    
    public RecordsController(Church church) {
		this.church = church;
	}
    
    @FXML
    public void initialize() {
    	loadMembers();
		
    }
   
    private void loadMembers() {
    	
    }
    
    @FXML
    void showMore(ActionEvent event) {
    	try {
			openMemberInfo();
		} catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    	
    }
    
    private void openMemberInfo() throws IOException{
		MemberInfoController memberInfoController = new MemberInfoController(church);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/memberInfo.fxml"));
		fxmlLoader.setController(memberInfoController);
		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(scene);
		secondaryStage.setTitle("Información");
		secondaryStage.setResizable(false);
		secondaryStage.show();
		
    }
    
}
