package ui;

import java.io.IOException;

import java.util.ArrayList;


import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    public SearchController(Church church) {
		this.church = church;
	}
    
    @FXML
    public void initialize() {

    	//loadMembers();
    	loadSectorType();
    	loadCommittees();
    	
    	
		
    }
    
    @FXML
    void search(ActionEvent event) {
    	search();
    }
    
    public void search() {
    	List<Member> toPrint = new ArrayList<Member>();
    	if(!(nameField.getText().isEmpty())) {
    		toPrint = church.searchByName(nameField.getText());
    		ToloadMembers(toPrint);
    	}else if(!(idField.getText().isEmpty())) {
    		toPrint = church.searchByIdNumber(idField.getText());
    		ToloadMembers(toPrint);
    	}else if(!(genderField.getText().isEmpty())) {
    		toPrint = church.searchByGender(genderField.getText());
    		ToloadMembers(toPrint);
    	}else if(!(phoneNumberField.getText().isEmpty())) {
    		toPrint = church.searchByIdNumber(phoneNumberField.getText());
    		ToloadMembers(toPrint);
    	}else if(baptizedCB.isSelected()) {
    		toPrint = church.buscarPorBautizados(baptizedCB.isSelected());
    		ToloadMembers(toPrint);
    	}else if(activeCB.isSelected()) {
    		toPrint = church.buscarPorBautizados(activeCB.isSelected());
    		ToloadMembers(toPrint);
    	}else if(!(sectorType.getValue().isEmpty())) {
    		toPrint = church.buscarPorSector(sectorType.getValue());
    		ToloadMembers(toPrint);
    	}else if(!(committee1.getValue().isEmpty())){
    		toPrint = church.buscarPorSector(committee1.getValue());
    		ToloadMembers(toPrint);
    	}
    	resetForm();
    }
    
    private void resetForm() {
		nameField.clear();
		idField.clear();
		
		
		baptizedCB.setSelected(false);
		activeCB.setSelected(false);
		
		phoneNumberField.clear();
		sectorType.setValue(null);
		committee1.setValue(null);

	}
    
    private void ToloadMembers(List<Member> membersList) {
    	members.setItems(null);
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
    
	private void loadSectorType() {
		for (int i = 0; i < church.getTheSectors().size(); i++) {
			sectorType.getItems().add(church.getTheSectors().get(i).getName());
		}
	}

	private void loadCommittees() {
		for (int i = 0; i < church.getTheCommittees().size(); i++) {
			committee1.getItems().add(church.getTheCommittees().get(i).getName());
		}
	}
    
    @FXML
	void showMore(ActionEvent event) {
		try {
			
			Member selectedMember = members.getSelectionModel().getSelectedItem();
			
			openMemberInfo(selectedMember);
			
		} catch (IOException ioException) {
			ioException.printStackTrace();

		}

	}
	
	private void openMemberInfo(Member member) throws IOException {
		MemberInfoController memberInfoController = new MemberInfoController(church,member,this);
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