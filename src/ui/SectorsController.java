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

public class SectorsController {
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
    private ComboBox<String> sectors;
    
    private Church church;
    
    public SectorsController(Church church) {
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
    	for (int i = 0; i < church.getTheSectors().size(); i++) {
			sectors.getItems().add(church.getTheSectors().get(i).getName());
		}
    	
    }
    
    @FXML
	void sectorInfo(ActionEvent event) {
		try {
			if (sectors.getValue() != null) {
				openSectorInfo(sectors.getValue());
			}
			
		} catch (IOException ioException) {
			ioException.printStackTrace();

		}

	}
    
    private void openSectorInfo(String sectorString) throws IOException {
    	model.Sector sectorModel = church.searchSector(sectorString);
    	SectorInfoController sCInfoController = new SectorInfoController(church,sectorModel);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/sectorsInfo.fxml"));
		fxmlLoader.setController(sCInfoController);
		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(scene);
		secondaryStage.setTitle("Informaci?n");
		secondaryStage.setResizable(false);
		secondaryStage.show();

	}
    
    /*
    @FXML
    void createSector(ActionEvent event) {
    	try {
			openNewSectorWindow();
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    }
    */
    /*
    private void openNewSectorWindow() throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("fxml/newSector.fxml"));
		Scene scene = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(scene);
		secondaryStage.setTitle("Nuevo Sector");
		secondaryStage.setResizable(false);
		secondaryStage.show();
    }
    */
    @FXML
    void loadSector(ActionEvent event) {
    	if (sectors.getValue() != null) {
			loadSector(sectors.getValue());
		}
    	
    }
    
    private void loadSector(String sectorString) {
    	model.Sector sector = church.searchSector(sectorString);
    	loadMembers(sector.getMembersList());
    	
    }
  
}