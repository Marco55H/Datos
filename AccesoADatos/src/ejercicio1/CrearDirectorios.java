package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CrearDirectorios {

	public static void main(String[] args) {

		leerArchivo();
		
	}

	public static void crearDirectorio(String directorio) {
		try {

			// Crear un directorio

			boolean exito = (new File(directorio)).mkdir();

			if (exito)

				System.out.println("Directorio: " + directorio + " creado");

		} catch (Exception e) {

			System.err.println("Error: " + e.getMessage());

		}
	}
	
	
	
	static public void leerArchivo() {

		BufferedReader br = null;
			try {

				br = new BufferedReader(new FileReader("src/ejercicio1/Carpetas.txt"));

				String linea;

				linea = br.readLine();

				while (linea != null) {
					
					crearDirectorio("C:\\Users\\mholguin\\"+linea);
					linea = br.readLine();

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					br.close();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}
	} //Fin leerArchivo
}