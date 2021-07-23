package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Church;

public class PrincipalController {
	private Church myChurch;
	 	
		@FXML
		private BorderPane principalWindow;
		
		private String startingWindow;
		
		public  PrincipalController(Church myChurch, String startingWindow) throws IOException {
			this.myChurch = myChurch;
			this.startingWindow = startingWindow;
			
		}
		
		@FXML
	    public void initialize() {
			try {
				myChurch.readMembers("data/memberscsv.csv");
				myChurch.divideBySectors();
				myChurch.divideByCommittee();
			} catch (IOException e) {
				System.out.println("Error en la lectura del csv de miembros");
				e.printStackTrace();
			}
			if (startingWindow.equals("Followers")) {
				openFollowers();
				
			}else if (startingWindow.equals("Sectors")) {
				openSectors();
				
			}else if (startingWindow.equals("Committees")) {
				openCommittees();
				
			}else if (startingWindow.equals("Birthdays")) {
				openBirthdays();
				
			}else if (startingWindow.equals("Visits")) {
				openVisits();
				
			}else if (startingWindow.equals("Options")) {
				openOptions();
				
			}
			
			
	    }
	
    	@FXML
    	void openFollowers(ActionEvent event) {
    		openFollowers();
    		
    	}
    	
    	private void openFollowers() {
    		try {
    			FollowersController followersController = new FollowersController(myChurch);
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/followers.fxml"));
    			fxmlLoader.setController(followersController);
				Parent Pane = fxmlLoader.load();
				principalWindow.setRight(Pane);
				
    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
    		
    	}
    	
		@FXML
	    void openSectors(ActionEvent event) {
			openSectors();
	    }
		
		private void openSectors() {
    		try {
    			SectorsController sectorsController = new SectorsController(myChurch);
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/sectors.fxml"));
    			fxmlLoader.setController(sectorsController);
				Parent Pane = fxmlLoader.load();
				principalWindow.setRight(Pane);
				
    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
    		
    	}
		
		@FXML
	    void openCommittees(ActionEvent event) {
			openCommittees();
			
	    }
		
		private void openCommittees() {
    		try {
    			CommitteesController committeesController = new CommitteesController(myChurch);
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/committees.fxml"));
    			fxmlLoader.setController(committeesController);
				Parent Pane = fxmlLoader.load();
				principalWindow.setRight(Pane);
				
    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
    		
    	}
		
		@FXML
	    void openBirthdays(ActionEvent event) {
			openBirthdays();
			
	    }
		
		private void openBirthdays() {
    		try {
    			BirthdaysController birthdaysController = new BirthdaysController(myChurch);
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/Birthdays.fxml"));
    			fxmlLoader.setController(birthdaysController);
				Parent Pane = fxmlLoader.load();
				principalWindow.setRight(Pane);
				
    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
    		
    	}
    	
    	private void openMenu() throws IOException{
    		MenuController menuController = new MenuController(myChurch);
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/menu.fxml"));
    		fxmlLoader.setController(menuController);
    		Parent root = fxmlLoader.load();

    		Scene scene = new Scene(root);
    		Stage secondaryStage = new Stage();
    		secondaryStage.setScene(scene);
    		secondaryStage.setTitle("Principal");
    		secondaryStage.setResizable(false);
    		secondaryStage.show();
        }
    	
    	@FXML
	    void openVisits(ActionEvent event) {
    		openVisits();
    		
	    }
    	
    	private void openVisits() {
    		try {
    			VisitsController visitsController = new VisitsController(myChurch);
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/visits.fxml"));
    			fxmlLoader.setController(visitsController);
				Parent Pane = fxmlLoader.load();
				principalWindow.setRight(Pane);
				
    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
    		
    	}
		
	    @FXML
	    void openOptions(ActionEvent event) {
	    	openOptions();
	    	
	    }
	    
	    private void openOptions() {
    		try {
    			OptionsController optionsController = new OptionsController(myChurch);
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/options.fxml"));
    			fxmlLoader.setController(optionsController);
				Parent Pane = fxmlLoader.load();
				principalWindow.setRight(Pane);
				
    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
    		
    	}
    	
    	private void openLoginWindow() throws IOException{
        	Parent root = FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
    		Scene scene = new Scene(root);
    		Stage secondaryStage = new Stage();
    		secondaryStage.setScene(scene);
    		secondaryStage.setTitle("Principal");
    		secondaryStage.setResizable(false);
    		secondaryStage.show();
        }

    	@FXML
        void goBack(ActionEvent event) {
    		try {
    			openMenu();
    			principalWindow.getScene().getWindow().hide();

    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
        }
    	
    	@FXML
        void logOff(ActionEvent event) {
    		try {
    			openLoginWindow();
    			principalWindow.getScene().getWindow().hide();

    		} catch (IOException ioException) {
				ioException.printStackTrace();
				
			}
        }
    	
}
