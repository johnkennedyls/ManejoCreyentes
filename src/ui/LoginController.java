package ui;

import java.io.IOException;

import exceptions.InvalidUserException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Church;

public class LoginController {

	private Church church;
	
	final static String DEVELOPER_USER = "Admin" ;
	
	final static String DEVELOPER_PASSWORD = "7uVxe2DKma8LAJm1lrHV6" ;

	public LoginController() {
		church = new Church("default", "Cali");
		
	}

	@FXML
	private PasswordField passwordField;

	@FXML
	private TextField userNameField;

	@FXML
	void login(ActionEvent event) {
		try {
			if (verifyLogin()) {
				church.readMembers("data/memberscsv.csv");
				openPrincipalWindow();

				passwordField.getScene().getWindow().hide();

			} else {
				throw new InvalidUserException();

			}

		} catch (IOException ioException) {

			ioException.printStackTrace();

		} catch (InvalidUserException invalidUserException) {
			invaliduserAlert();

		}

	}
	
	private void invaliduserAlert() {
		Alert emptyFieldsAlert = new Alert(AlertType.ERROR);
    	emptyFieldsAlert.setTitle("Usuario o contraseña invalidos.");
    	emptyFieldsAlert.setHeaderText("EL usuario y/o la contrasña ingresados son incorrectos.");
    	emptyFieldsAlert.showAndWait();
	}

	private void openPrincipalWindow() throws IOException {
		MenuController menuController = new MenuController(church);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/menu.fxml"));
		fxmlLoader.setController(menuController);
		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setScene(scene);
		secondaryStage.setTitle("Principal");
		secondaryStage.setResizable(false);
		secondaryStage.show();
		secondaryStage.setOnCloseRequest(e -> Platform.exit());
		
	}

	private boolean verifyLogin() {
		/*
		 String name = church.getMinister().getName(); 
		String password = church.getMinister().getPassword();
		 
		 String inputName = userNameField.getText(); 
		 String inputPassword = passwordField.getText();
		 
		 if (name.equals(inputName) && password.equals(inputPassword)) {
		 	return true;
		  
		 }else if (inputName.equals(DEVELOPER_USER) && inputPassword.equals(DEVELOPER_PASSWORD)) {
			 return true;
		 }
			 
		 return false;
		 
		 */
		
		return true;
	}

	@FXML
	void developersInfo(ActionEvent event) {
		
		Stage popupwindow = new Stage();
		
		popupwindow.initModality(Modality.APPLICATION_MODAL);
		popupwindow.setTitle("Desarrolladores");
		
		Label label2 = new Label("\r\n" + "-Info1\n" + "-Info2\n" + "-Sean Quintero. Email: seanquintero3@gmail.com\n" + "\r\n" + "\r\n"
				+ "Copyright Disclaimer for icons:\r\n"
				+ "\r\n"
				+ "individual-man-people-person icon:\r\n"
				+ "Original Name: 3289576-individual-man-people-person_107097\r\n"
				+ "Author: Dumitriu Robert // http://www.nufrecamenta.com\r\n"
				+ "Source: https://icon-icons.com/icon/individual-man-people-person/107097\r\n"
				+ "\r\n"
				+ "clan-group-partners-peers-people icon:\r\n"
				+ "Original Name: 3289557-clan-group-partners-peers-people_107100\r\n"
				+ "Author: Dumitriu Robert // http://www.nufrecamenta.com\r\n"
				+ "Source: https://icon-icons.com/icon/clan-group-partners-peers-people/107100\r\n"
				+ "\r\n"
				+ "leader-leading-president-speaking-speech icon:\r\n"
				+ "Original Name: 3289575-leader-leading-president-speaking-speech_107108\r\n"
				+ "Author: Dumitriu Robert // http://www.nufrecamenta.com\r\n"
				+ "Source: https://icon-icons.com/icon/leader-leading-president-speaking-speech/107108\r\n"
				+ "\r\n"
				+ "birthdaycakewithcandles icon:\r\n"
				+ "Original Name: birthdaycakewithcandles_79795\r\n"
				+ "Author: Linh Pham // https://linhpham.me/miu/\r\n"
				+ "Source: https://icon-icons.com/icon/birthday-cake-with-candles/79795\r\n"
				+ "\r\n"
				+ "placeholderblackshapeforlocalizationonmaps icon:\r\n"
				+ "Original Name: placeholderblackshapeforlocalizationonmaps_79861\r\n"
				+ "Author: Linh Pham // https://linhpham.me/miu/\r\n"
				+ "Source: https://icon-icons.com/icon/placeholder-black-shape-for-localization-on-maps/79861}\r\n"
				+ "\r\n"
				+ "configuration-edit-gear-options-preferences-setting-settings icon:\r\n"
				+ "Original Name: 1904675-configuration-edit-gear-options-preferences-setting-settings_122525\r\n"
				+ "Author: Alice Rizzo // https://www.behance.net/rizzoalicee3e1\r\n"
				+ "Source: https://icon-icons.com/icon/configuration-edit-gear-options-preferences-setting-settings/122525\r\n"
				+ "");
		
		Button button1 = new Button("Cerrar");

		button1.setOnAction(e -> popupwindow.close());
		
		
		ScrollPane sp = new ScrollPane();
		
		sp.setContent(label2);
		
		VBox layout = new VBox(10);

		layout.getChildren().addAll(sp, button1);

		layout.setAlignment(Pos.CENTER);

		Scene scene1 = new Scene(layout, 300, 250);

		popupwindow.setScene(scene1);

		popupwindow.showAndWait();
	}

}
