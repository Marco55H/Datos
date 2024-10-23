package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FicherosAhorcado {
	
	public static void main(String[] args) {
		leerArchivo();
	}
	
	static public void leerArchivo() {

		FileReader br = null;
		try {

			br = new FileReader("src/ejercicio3/palabras.txt");

			int numeroLineas;

			numeroLineas = br.read();
			
			String palabra ="";
			
			while(numeroLineas!=-1) {
				
				char letra = (char) numeroLineas;
				
				numeroLineas = br.read();
				
				palabra += letra;
				
				System.out.println(letra);
				
				
				
				if(Character.isUpperCase(letra)) {
					
					imprimirArchivo(palabra);
					
					numeroLineas = br.read();
				}
				
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
	
	
	
	static public void imprimirArchivo(String palabra) {

		// BufferedWriter para escribir
		BufferedWriter bw = null;
		{
			try {

				// Lo inicializamos
				bw = new BufferedWriter(new FileWriter("src/ejercicio3/palabrasOrdenadas.txt"));
				

					bw.write(palabra+"\n");
					bw.newLine();


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
