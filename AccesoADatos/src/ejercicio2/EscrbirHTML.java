package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscrbirHTML {

	public static void main(String[] args) {

		leerArchivo();

	}

	static public void leerArchivo() {

		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader("src/ejercicio1/Carpetas.txt"));

			String linea;

			linea = br.readLine();

			while (linea != null) {



					crearFichero("C:\\Users\\mholguin\\" + linea);

	
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
	} // Fin leerArchivo

	static public void crearFichero(String linea) {

		linea=linea+"\\Fichero.html";
		
		try {
			// Creamos el objeto que encapsula el fichero
			File fichero = new File(linea);
			// A partir del objeto File creamos el fichero físicamente
			if (fichero.createNewFile()) {

				System.out.println("El fichero se ha creado correctamente");

				imprimirArchivo(linea);

			} else
				System.out.println("No se ha podido crear el fichero");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	static public void imprimirArchivo(String linea) {

		// BufferedWriter para escribir
		BufferedWriter bw = null;
		{
			try {

				// Lo inicializamos
				bw = new BufferedWriter(new FileWriter(linea));
				
				// Recorre el array y va pintando los atributos de cada objeto

				bw.write("<html> \n <head> \n <title> "+linea.subSequence(26,30)+" </title> \n </head> \n <body> \n <h1>Ruta " + linea
						+ " </h1> \n <h3>Autor: Marco</h3> </body> \n </html>");

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					bw.flush();
					bw.close();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}
		}
	}
}
