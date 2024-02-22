package com.ubosque.cajero.vista;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ubosque.cajero.controlador.UsuarioCRUD;
import com.ubosque.cajero.images.FondoCajero;
import com.ubosque.cajero.modelo.Usuario;

public class CreacionUsuario extends JFrame implements ActionListener{
	
	private JPasswordField contrasenaPwd1;
	private JPasswordField contrasenaPwd2;
	private JComboBox tiposClienteCmb;
	private JComboBox tiposCCCmb;
	private JTextField nombreUnoTxt;
	private JTextField nombreDosTxt;
	private JTextField apellidoUnoTxt;
	private JTextField apellidoDosTxt;
	private JTextField numeroIdentificacionTxt;
	private JTextField montoCreditoTxt;
	private JLabel tipoCC;
	private JLabel nombreUno;
	private JLabel nombreDos;
	private JLabel apellidoUno;
	private JLabel apellidoDos;
	private JLabel numeroIdentificacion;
	private JLabel contrasena1;
	private JLabel contrasena2;
	private JLabel tipoUsuario;
	private JLabel titulo;
	private JLabel montoCreditolbl;
	private JButton eliminarBtn;
	private JButton guardarBtn;
	
	public CreacionUsuario() {

		try {
            FondoCajero fondo = new FondoCajero(ImageIO.read(new File("C:/Users/ANDRES BETANCOURT/Pictures/Saved Pictures/bancoBosque.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de lectura de fondo", JOptionPane.ERROR_MESSAGE);
        }
		
		
		this.setTitle("MENU BANCOBOSQUE");
		this.setSize(450, 350);
		this.setLocationRelativeTo(null); 
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		titulo = new JLabel("NUEVO USUARIO");
		titulo.setBounds(150, 10, 200, 50);
		
		nombreUno = new JLabel("Primer Nombre");
		nombreUno.setBounds(50, 60, 100, 20);
		nombreUnoTxt = new JTextField();
		nombreUnoTxt.setBounds(300, 60, 100, 20);
		nombreUnoTxt.setName("nombreTxt");
		
		nombreDos = new JLabel("Segundo Nombre");
		nombreDos.setBounds(50, 80, 100, 20);
		nombreDosTxt = new JTextField();
		nombreDosTxt.setBounds(300, 80, 100, 20);
		nombreDosTxt.setName("nombreTxt");
		
		apellidoUno = new JLabel("Primer Apellido");
		apellidoUno.setBounds(50, 100, 100, 20);
		apellidoUnoTxt = new JTextField();
		apellidoUnoTxt.setBounds(300, 100, 100, 20);
		apellidoUnoTxt.setName("primerApellidoTxt");
			
		apellidoDos = new JLabel("Segundo Apellido");
		apellidoDos.setBounds(50, 120, 100, 20);
		apellidoDosTxt = new JTextField();
		apellidoDosTxt.setBounds(300, 120, 100, 20);
		apellidoDosTxt.setName("primerApellidoTxt");
		
		numeroIdentificacion = new JLabel("Identificación");
		numeroIdentificacion.setBounds(50, 140, 100, 20);
		numeroIdentificacionTxt = new JTextField();
		numeroIdentificacionTxt.setBounds(300, 140, 100, 20);
		numeroIdentificacionTxt.setName("numeroIdentificacionTxt");
	
		tipoCC = new JLabel("Tipo de identificación");
		tipoCC.setBounds(50, 160, 120, 20);
		Object[] listaTipoCC = new Object[4];
		listaTipoCC[0] = "Cédula";
		listaTipoCC[1] = "T. Identidad";
		listaTipoCC[2] = "Cédula de Extranjeria";
		listaTipoCC[3] = "Pasaporte";
		tiposCCCmb = new JComboBox(listaTipoCC);
		tiposCCCmb.setBounds(300, 160, 100, 20);
		
		contrasena1 = new JLabel("Contraseña");
		contrasena1.setBounds(50, 180, 100, 20);
		contrasenaPwd1 = new JPasswordField();
		contrasenaPwd1.setBounds(300, 180, 100, 20);
		contrasenaPwd1.setName("contrasenaPwd1");
		
		contrasena2 = new JLabel("Confirme contraseña");
		contrasena2.setBounds(50, 200, 120, 20);
		contrasenaPwd2 = new JPasswordField();
		contrasenaPwd2.setBounds(300, 200, 100, 20);
		contrasenaPwd2.setName("contrasenaPwd2");
		
		tipoUsuario = new JLabel("Tipo de usuario");
		tipoUsuario.setBounds(50, 220, 100, 20);
		Object[] listaTipoUsuario = new Object[2];
		listaTipoUsuario[0] = "Funcionario";
		listaTipoUsuario[1] = "Cliente";
		tiposClienteCmb = new JComboBox(listaTipoUsuario);
		tiposClienteCmb.setBounds(300, 220, 100, 20);
		
		montoCreditolbl = new JLabel("Monto del Crédito");
		montoCreditolbl.setBounds(50, 240, 100, 20);
		montoCreditoTxt = new JTextField();
		montoCreditoTxt.setBounds(300, 240, 100, 20);
		montoCreditoTxt.setName("créditoTxt");
		
		guardarBtn = new JButton("Guardar");
		guardarBtn.setBounds(250, 270, 100, 20);
		guardarBtn.setName("guardarBtn");
		guardarBtn.addActionListener(this);		
		
		
		eliminarBtn= new JButton("Eliminar");
		eliminarBtn.setBounds(100, 270, 100, 20);
		eliminarBtn.setName("eliminar");
		eliminarBtn.addActionListener(this);
		
		this.add(titulo);
		this.add(numeroIdentificacion);
		this.add(numeroIdentificacionTxt);
		this.add(contrasena1);
		this.add(contrasenaPwd1);
		this.add(contrasena2);
		this.add(contrasenaPwd2);
		this.add(tipoUsuario);
		this.add(tiposClienteCmb);
		this.add(guardarBtn);
		this.add(tiposCCCmb);
		this.add(nombreUno);
		this.add(nombreDos);
		this.add(nombreUnoTxt);
		this.add(nombreDosTxt);
		this.add(apellidoUno);
		this.add(apellidoDos);
		this.add(apellidoUnoTxt);
		this.add(apellidoDosTxt);
		this.add(tipoCC);
		this.add(montoCreditolbl);
		this.add(montoCreditoTxt);
		this.add(eliminarBtn);
		
	}

	public void actionPerformed(ActionEvent e) {
		int numIdentificacion = 0;
		int password1 = 0;
		int password2 = 0;
		int saldo = 0;
		try {
		numIdentificacion = Integer.parseInt(numeroIdentificacionTxt.getText());
		password1 = Integer.parseInt(contrasenaPwd1.getText());
		password2 = Integer.parseInt(contrasenaPwd2.getText());
		saldo = Integer.parseInt(montoCreditoTxt.getText());
		}
		catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null,"Alerta información ingresada no valida\nPor favor ingresela nuevamente.","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		String nombreUno = (nombreUnoTxt.getText());
		String nombreDos = (nombreDosTxt.getText());
		String apellidoUno = (apellidoUnoTxt.getText());
		String apellidoDos = (apellidoDosTxt.getText());
		String tipUsr = tiposClienteCmb.getSelectedItem().toString();
		String td = tiposCCCmb.getSelectedItem().toString();
		if(password1 != password2) {
			JOptionPane.showMessageDialog(null, "Las contraseñas deben coincidir");
			return;
		}
		
		Usuario usuario = new Usuario(numIdentificacion, password1, tipUsr,nombreUno,nombreDos,apellidoUno,apellidoDos,saldo,td);
		
		
		UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
		boolean exitoso = usuarioCRUD.crearUsuario(usuario);
		
		if (exitoso){
			JOptionPane.showMessageDialog(null, "Creación Exitosa");
			
		}else {
				JOptionPane.showMessageDialog(null, "No se pudo crear el usuario ");
			}
		}
	
	
	
	public static void main(String[] args) {
		CreacionUsuario cu = new CreacionUsuario();
		cu.setVisible(true);
	}

}
