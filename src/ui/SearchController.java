package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Church;
import model.Member;

public class SearchController {
	@FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private CheckBox baptizedCB;

    @FXML
    private CheckBox activeCB;

    @FXML
    private ComboBox<String> sectorType;

    @FXML
    private ComboBox<String> committee1;

    @FXML
	private TableColumn<Member,String> Name;

	@FXML
	private TableColumn<Member, String> IdNumber;

	@FXML
	private TableColumn<Member, String> Gender;

	@FXML
	private TableColumn<Member, String> Birthday;

	@FXML
	private TableColumn<Member, Boolean> Baptized;

	@FXML
	private TableColumn<Member, Boolean> Active;

	@FXML
	private TableColumn<Member, String> PhoneNumber;

	@FXML
	private TableColumn<Member, String> Sector;

	@FXML
	private TableColumn<Member, String> Committee;
    
    private Church church;
    
    public SearchController(Church church) {
		this.church = church;
	}
    
    @FXML
    public void initialize() {
    	loadMembers();
		
    }
    
    private void loadMembers() {
    	church.getTheCommittees();
    }
    
    @FXML
    void search(ActionEvent event) {
    	
    }
    
    @FXML
	void showMore(ActionEvent event) {
		try {
			openMemberInfo();
		} catch (IOException ioException) {
			ioException.printStackTrace();

		}

	}

	private void openMemberInfo() throws IOException {
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
