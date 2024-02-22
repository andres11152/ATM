package com.ubosque.cajero.vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
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
import javax.swing.JComboBox;
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

public class Vista extends JFrame implements ActionListener {
	
	private JPanel panel1;
	
	private JLabel calculadoraLbl;
	private JLabel resultadosLbl;
	private JLabel sistemaLbl;
	private JLabel decimalLbl;
	private JLabel binarioLbl;
	private JLabel hexadecimalLbl;
	private JLabel resDecimalLbl;
	private JLabel resBinarioLbl;
	private JLabel resHexadecimalLbl;
	
	private JTextField sistemaTxt;
	
	private JButton calcular;
	private JButton comprobarSisBtn;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button0;
	private JComboBox sistemaCbmb;

	public Vista() {
		super();
		configurarVista();
		inicializarVista();
		organizarVista();
		addListeners();
	}

	public void configurarVista() {
		this.setTitle("NumSys - Calculadora de Sistemas Numéricos");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4,5,3,3));
	}

	public void inicializarVista() {

		panel1 = new JPanel();
		
		calculadoraLbl = new JLabel("Calculadora");
		resultadosLbl = new JLabel("Resultados");
		sistemaLbl = new JLabel("Sistema");
		decimalLbl = new JLabel("Decimal");
		binarioLbl = new JLabel("Binario");
		hexadecimalLbl = new JLabel("Hexadecimal");
		resDecimalLbl = new JLabel("Resultado Decimal");
		resBinarioLbl = new JLabel("Resultado Binario");
		resHexadecimalLbl = new JLabel("Resultado Hexadecimal");
		
		sistemaTxt = new JTextField();
		sistemaTxt.setName("usuarioTxt");
		sistemaCbmb = new JComboBox();
		calcular = new JButton("Calcular todos los sitemas numéricos");
		comprobarSisBtn = new JButton("Comprobar Sistema Numérico");
		
		//Teclado
		JButton button1= new JButton("7");
		JButton button2= new JButton("8");
		JButton button3= new JButton("9");
		JButton button4= new JButton("4");
		JButton button5= new JButton("5");
		JButton button6= new JButton("6");
		JButton button7= new JButton("1");
		JButton button8= new JButton("2");
		JButton button9= new JButton("3");
		JButton button0= new JButton("0");
		
	}

	public void organizarVista() {

		panel1.setSize(200,200);
		calculadoraLbl.setBounds(20, 10, 100, 20);
		resultadosLbl.setBounds(220,10,100,20);
		sistemaLbl.setBounds(20, 40, 100, 20);
		decimalLbl.setBounds(220, 80, 100, 20);
		binarioLbl.setBounds(220,140,100,20);
		hexadecimalLbl.setBounds(220, 200, 100, 20);
		resDecimalLbl.setBounds(220, 100, 130, 20);
		resBinarioLbl.setBounds(220,160,130,20);
		resHexadecimalLbl.setBounds(220, 220, 150, 20);
		
		sistemaTxt.setBounds(20, 120, 170, 20);
		calcular.setBounds(10, 320, 180, 20);
		sistemaCbmb.setBounds(80,40,110,20);
		comprobarSisBtn.setBounds(20,80,130,20);	
		calcular.setName("ingresar");
		
		
		this.add(calculadoraLbl);
		this.add(resultadosLbl);
		this.add(sistemaLbl);
		this.add(decimalLbl);
		this.add(binarioLbl);
		this.add(hexadecimalLbl);
		this.add(resDecimalLbl);
		this.add(resBinarioLbl);
		this.add(resHexadecimalLbl);
		this.add(sistemaTxt);
		this.add(calcular);
		this.add(sistemaCbmb);
		this.add(comprobarSisBtn);
		this.add(panel1);
		
		
		
	}

	public void addListeners() {

		calcular.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		}
	

	public static void main(String[] args) {

		Vista login = new Vista();
		login.setVisible(true);
	}

}
