package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import model.Church;
import model.Member;

public class MemberInfoController {
	
	@FXML
    private BorderPane mainPane;
	
	private Church church;
    
	private Member member;
	
    public MemberInfoController(Church church,Member member) {
		this.church = church;
		this.member = member;
	}
    
    @FXML
    public void initialize() {
    	loadInfo();
    }
    
    private void loadInfo() {
    	try {
    		InfoController infoController = new InfoController(church,mainPane,member);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/info.fxml"));
			fxmlLoader.setController(infoController);
			Parent Pane = fxmlLoader.load();
			mainPane.setCenter(Pane);
			

		} catch (IOException ioException) {
			ioException.printStackTrace();
			
		}
    }
	
}
