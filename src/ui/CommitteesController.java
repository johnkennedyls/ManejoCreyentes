package ui;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Church;
import model.Member;

public class CommitteesController {
	@FXML
    private TableView<Member> members;

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

    @FXML
    private ComboBox<String> committees;
    
    private Church church;
    
    public CommitteesController(Church church) {
		this.church = church;
	}

    @FXML
	public void initialize() {
    	loadComboBox();
	}

	private void loadMembers(List<Member> membersList) {

		ObservableList<Member> observableList;
		observableList = FXCollections.observableArrayList(membersList);
		members.setItems(observableList);

		Name.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
		IdNumber.setCellValueFactory(new PropertyValueFactory<Member, String>("idNumber"));
		Gender.setCellValueFactory(new PropertyValueFactory<Member, String>("gender"));
		Birthday.setCellValueFactory(new PropertyValueFactory<Member, String>("birthday"));
		Baptized.setCellValueFactory(new PropertyValueFactory<Member, Boolean>("baptized"));
		Active.setCellValueFactory(new PropertyValueFactory<Member, Boolean>("active"));
		PhoneNumber.setCellValueFactory(new PropertyValueFactory<Member, String>("phoneNumber"));
		Sector.setCellValueFactory(new PropertyValueFactory<Member, String>("sector"));
		Committee.setCellValueFactory(new PropertyValueFactory<Member, String>("committee"));
	}

    private void loadComboBox() {
    	for (int i = 0; i < church.getTheCommittees().size(); i++) {
			committees.getItems().add(church.getTheCommittees().get(i).getName());
		}
    }
    
    @FXML
	void committeeInfo(ActionEvent event) {
		try {
			
			if (committees.getValue() != null) {
				openCommitteeInfo(committees.getValue());
			}
			
		} catch (IOException ioException) {
			ioException.printStackTrace();

		}

	}
    
    private void openCommitteeInfo(String committeeString) throws IOException {
    	model.Committee committeeModel = church.searchCommittee(committeeString);
    	CommitteeInfoController cInfoController = new CommitteeInfoController(church,committeeModel);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/committeesInfo.fxml"));
		fxmlLoader.setController(cInfoController);
		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(scene);
		secondaryStage.setTitle("Información");
		secondaryStage.setResizable(false);
		secondaryStage.show();

	}
    
    /*
    @FXML
    void createCommittee(ActionEvent event) {
    	try {
    		openNewCommitteeWindow();
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    }
    */
    /*
    private void openNewCommitteeWindow() throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("fxml/newCommittee.fxml"));
		Scene scene = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(scene);
		secondaryStage.setTitle("Nuevo Sector");
		secondaryStage.setResizable(false);
		secondaryStage.show();
    }
    */
    @FXML
    void loadCommittee(ActionEvent event) {
    	if (committees.getValue() != null) {
    		loadCommittee(committees.getValue());
		}
    	
    }
    
    private void loadCommittee(String committeeString) {
    	model.Committee committee = church.searchCommittee(committeeString);
    	loadMembers(committee.getcMembersList());
    	
    }
    
}