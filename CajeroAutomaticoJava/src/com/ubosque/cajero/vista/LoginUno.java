package com.ubosque.cajero.vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ubosque.cajero.controlador.Autenticacion;
import com.ubosque.cajero.images.FondoCajero;
import com.ubosque.cajero.modelo.Usuario;

public class LoginUno extends JFrame implements ActionListener {
	private JLabel titulo;
	private JLabel usuario;
	private JTextField usuarioTxt;
	private JLabel contrasena;
	private JPasswordField contrasenaTxt;
	private JButton ingresar;

	private Autenticacion autenticacion;
	

	public LoginUno() {
		super();
		configurarVista();
		inicializarVista();
		organizarVista();
		addListeners();
	}

	public void configurarVista() {
		this.setTitle("BANCOBOSQUE:Cajero Automático");
		this.setSize(380, 260);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void inicializarVista() {

		try {
            FondoCajero fondo = new FondoCajero(ImageIO.read(new File("C:/Users/ANDRES BETANCOURT/Pictures/Saved Pictures/logo-ub.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de lectura de fondo", JOptionPane.ERROR_MESSAGE);
        }
		
		
		titulo = new JLabel("BIENVENIDO");
		usuario = new JLabel("Usuario");
		usuarioTxt = new JTextField();
		usuarioTxt.setName("usuarioTxt");
		contrasena = new JLabel("Contraseña");
		contrasenaTxt = new JPasswordField();
		contrasenaTxt.setName("contrasenaTxt");
		ingresar = new JButton("Ingresar");
		ingresar.setName("ingresar");

	}

	public void organizarVista() {

		titulo.setBounds(50, 10, 100, 20);
		usuario.setBounds(50, 40, 100, 20);
		usuarioTxt.setBounds(220, 40, 100, 20);
		contrasena.setBounds(50, 70, 100, 20);
		contrasenaTxt.setBounds(220, 70, 100, 20);
		ingresar.setBounds(220, 100, 100, 20);

		this.add(titulo);
		this.add(usuario);
		this.add(usuarioTxt);
		this.add(contrasena);
		this.add(contrasenaTxt);
		this.add(ingresar);
	}

	public void addListeners() {

		ingresar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int identificacion = 0;
		int clave = 0;
		try {
			identificacion = Integer.parseInt(usuarioTxt.getText());
			clave = Integer.parseInt(contrasenaTxt.getText());
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "La identificación debe ser numérico");
			return;
		}
		
		
		Usuario usuarioLogin = new Usuario();
		usuarioLogin.setContrasena(clave);
		usuarioLogin.setNumeroIdentificacion(identificacion);
		autenticacion = new Autenticacion();
		Usuario tipoUsuario = autenticacion.autenticar(usuarioLogin);
		
		if(tipoUsuario == null) {
			JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
		}else if(tipoUsuario.getTipoUsuario().equals("F")) {
			JOptionPane.showMessageDialog(null, "Funcionario");
			dispose();
			CreacionUsuario cu = new CreacionUsuario();
			cu.setVisible(true);
		}else if(tipoUsuario.getTipoUsuario().equals("C")) {
			JOptionPane.showMessageDialog(null, "Cliente");
			dispose();
			MenuUsuario me = new MenuUsuario(tipoUsuario);
			me.setVisible(true);
		}
	}

	public static void main(String[] args) {

		LoginUno login = new LoginUno();
		login.setVisible(true);
	}

}
