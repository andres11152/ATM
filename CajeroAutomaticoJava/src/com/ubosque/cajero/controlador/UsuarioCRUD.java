package com.ubosque.cajero.controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.ubosque.cajero.modelo.Usuario;


public class UsuarioCRUD {
	public boolean crearUsuario(Usuario usuarioACrear) {
		try {
				
			FileWriter fw = new FileWriter("C:/archivos/credenciales.txt", true);
			String lineaNueva = usuarioACrear.toString();
			
			fw.write("\r\n" + lineaNueva);
			fw.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe ese archivo en esa ruta");
			return false;
		} catch (IOException e) {
			System.out.println("No se pudo escribir la línea");
			return false;
		}
		return true;

	}
	public boolean actualizarUsuario(Usuario us) {
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      FileWriter fw = null;
	      String old = "";
	      try {
	        
	         archivo = new File ("C:/archivos/credenciales.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         String linea = br.readLine();
		     linea = br.readLine();
	         // Lectura del fichero
		     String linea_nueva = us.toString();
	         while(linea != null){
	        	 String[] datos = linea.split(";");
				 String numeroDocumento = datos[0];
				 String password = datos[1];
				 if(((""+us.getNumeroIdentificacion()).equals(numeroDocumento)) && ((""+us.getContrasena()).equals(password))) {
						old = old + linea_nueva;
					}
				 else {
	        	 old = old + linea;
				 }
				 linea = br.readLine();
				 if (linea != null)
					 old += System.lineSeparator();
	         }
	         fw = new FileWriter(archivo);
	         fw.write("\n"+old);
	         fw.flush();
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	    }
	 
	      }
		return true;

	}

	public boolean eliminarUsuario(Usuario us) {
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      FileWriter fw = null;
	      String old = "";
	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File ("C:/archivos/credenciales.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         String linea = br.readLine();
		     linea = br.readLine();
	         // Lectura del fichero
	         while(linea != null){
	        	 String[] datos = linea.split(";");
				 String numeroDocumento = datos[0];
				 String password = datos[1];
				 if ((((""+us.getNumeroIdentificacion()).equals(numeroDocumento)) && ((""+us.getContrasena()).equals(password))) == false) {
					 old += linea;
					 
				 }
				 else
					 old = old.substring(0,old.length()-2);
				 linea = br.readLine();
				 	if (linea != null)
				 		old += System.lineSeparator();
				 
	         }
	         System.out.print(old);
	         fw = new FileWriter(archivo);
	         fw.write("\n"+old);
	         fw.flush();
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	    }
	 
	      }
		return true;
		
	}
}