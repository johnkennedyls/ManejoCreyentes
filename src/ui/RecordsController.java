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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Church;
import model.Member;

public class RecordsController {
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
	
	private Church church;
	
	public RecordsController(Church church) {
		this.church = church;
	}
	
	@FXML
	public void initialize() {
		loadMembers(church.getGeneralMembers());

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