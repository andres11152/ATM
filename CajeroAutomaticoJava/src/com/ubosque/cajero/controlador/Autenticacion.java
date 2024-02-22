package com.ubosque.cajero.controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.ubosque.cajero.modelo.Usuario;

public class Autenticacion {
	
	public Usuario autenticar(Usuario usuarioIngresado) {
		int numeroId = usuarioIngresado.getNumeroIdentificacion();
		int pwd = usuarioIngresado.getContrasena();
		try {
			FileReader fr = new FileReader("C:/archivos/credenciales.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			linea = br.readLine();
			while(linea != null) {
				System.out.print(linea);
				String[] datos = linea.split(";");
				String numeroDocumento = datos[0];
				String password = datos[1];
				
				linea = br.readLine();
				if((""+numeroId).equals(numeroDocumento) && (""+pwd).equals(password)) {
					return new Usuario(numeroId,pwd,datos[2],datos[3],datos[4],datos[5],datos[6],(int) Double.parseDouble(datos[7]) ,datos[8]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No existe ese archivo en esa ruta");
		} catch (IOException e) {
			System.out.println("No se pudo leer la línea");
		}
		return null ;	    
	}
}