package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Organization {
	
	private Minister minister;

	public Organization() {
		
	}
	
	public void importDataOrder(String fn) throws IOException {
		File fl = new File(fn);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fl));
		br.readLine();
		
		String line = br.readLine();
		
		while (line != null) {
			String[] split = line.split(",");	
			
			//se crea el objeto que vamos a leer y se añaden a la estructura.
			/*
			Order or = new 	Order(split[0], java.sql.Date.valueOf(split[1]), split[2], split[3], split[4], StatusOrder.valueOf(split[5]), split[6]) ;
			orders.add(or);
			*/
			line = br.readLine();
			
		}
	}
}
