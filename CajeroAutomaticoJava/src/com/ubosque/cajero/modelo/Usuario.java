package com.ubosque.cajero.modelo;

import com.ubosque.cajero.controlador.UsuarioCRUD;

public class Usuario {
	private int numeroIdentificacion;
	private int contrasena;
	private int saldo ;
	private String tipoUsuario;
	private String primerNombre ;
	private String segundoNombre ;
	private String primerApellido ;
	private String segundoApellido ;
	private String tipoDocumento ;
		
	public Usuario(int numeroIdentificacion, int contrasena, String tipoUsuario,String nombre1,String nombre2,String apellido1,String apellido2,int sald,String td) {
		super();
		this.numeroIdentificacion = numeroIdentificacion;
		this.contrasena = contrasena;
		this.tipoUsuario = tipoUsuario;
		this.primerNombre = nombre1;
		this.segundoNombre = nombre2;
		this.primerApellido = apellido1;
		this.segundoApellido = apellido2;
		this.saldo = sald;
		this.tipoDocumento = td;
		
	}
	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public Usuario() {
		
	}
	
	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(int numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public int getContrasena() {
		return contrasena;
	}
	public void setContrasena(int contrasena) {
		this.contrasena = contrasena;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String toString() {
		return this.getNumeroIdentificacion() + ";" + this.getContrasena() + ";"
				+ this.getTipoUsuario().charAt(0)+ ";" + this.getPrimerNombre()+ ";" + this.getSegundoNombre()
				+ ";" + this.getPrimerApellido()+ ";" + this.getSegundoApellido()+ ";" + this.getSaldo()+ ";"
				+ this.getTipoDocumento();
	}
}
