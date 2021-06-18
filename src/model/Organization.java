package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Organization {
	
	private Minister minister;

	public Organization() {
		
	}
	
	
	public static void leerArchivo(String ruta) {

     	String dato;
     	
        try {
            File archivo = new File(ruta);
            Scanner myReader = new Scanner(archivo);
            String[] list = myReader.nextLine().split(";");
            int[][] myMatrix = new int[list.length-1][list.length-1];
            int row = 0;
            String[] info;
            while (myReader.hasNextLine()) {
                dato = myReader.nextLine();
                info = dato.split(";");
                System.out.println("Tamaño info: " + info.length);
                for (int i = 1; i < list.length; i++) {
                    myMatrix[row][i-1] = Integer.parseInt(info[i]);
                }
                row++;               
            }
            
            for (int j = 0; j < list.length-1; j++){ 
                for (int k = 0; k < list.length-1; k++){ 
                    System.out.print(myMatrix[j][k]+" "); 
                } 
                System.out.println(""); 
            }
            
        } catch (FileNotFoundException ex) {
             System.out.println("El archivo no existe");
        }

      
     }
	
}

