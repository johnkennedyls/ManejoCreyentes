package ui;

import java.io.IOException;

import model.Minister;

public class Menu {

	private static Minister theMinister;

	public Menu() {

	}

	private void operation(String option) {

		switch (option) {
		case "createMinister":

			break;

		case "createChurch":

			break;

		case "createSector":

			break;

		case "createMember":

			break;

		case "Exit":

			break;

		}

	}
	
	private void registerTheMinister(String name, String password) {
		
		theMinister = new Minister(name, password);
		
	}
	
}
