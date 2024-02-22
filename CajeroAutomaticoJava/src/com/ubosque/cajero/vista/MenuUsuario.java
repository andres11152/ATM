package com.ubosque.cajero.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.ubosque.cajero.controlador.Autenticacion;
import com.ubosque.cajero.controlador.ClienteController;
import com.ubosque.cajero.controlador.FuncionarioController;
import com.ubosque.cajero.controlador.UsuarioCRUD;
import com.ubosque.cajero.images.FondoCajero;
import com.ubosque.cajero.modelo.Usuario;

public class MenuUsuario extends JFrame implements ActionListener {

	private JLabel bienvenidolbl;
	private JLabel nombrelbl;
	private JLabel saldolbl;
	private JButton retirarBtn;
	private JButton pagarBtn;
	private JRadioButton retUnoRad, retDosRad, retTresRad, retCuatroRad, retCincoRad ,retSeisRad;
	private JLabel titulo;
	private ButtonGroup buttonG;
	private JTextField cajaRetiroTxt;
	private JLabel cajaRetiroLbl;
	Usuario user;
	ClienteController h = new ClienteController();
	
	public MenuUsuario(Usuario user) {

		this.user = user;
		this.setTitle("MENU CAJERO AUTOMATICO CLIENTE");
		this.setSize(480, 280);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		titulo = new JLabel("BIENVENIDO A BANCOBOSQUE");
		titulo.setBounds(140, 10, 200, 20);

		try {
            FondoCajero fondo = new FondoCajero(ImageIO.read(new File("C:/Users/ANDRES BETANCOURT/Pictures/Saved Pictures/ubosque.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de lectura de fondo", JOptionPane.ERROR_MESSAGE);
        }
		
		buttonG = new ButtonGroup();
		
		retUnoRad = new JRadioButton("10.000");
		retUnoRad.setBounds(50, 90, 80, 30);
		add(retUnoRad);
		buttonG.add(retUnoRad);
		
		retDosRad = new JRadioButton("20.000");
		retDosRad.setBounds(130, 90, 80, 30);
		add(retDosRad);
		buttonG.add(retDosRad);
		
		retTresRad = new JRadioButton("50.000");
		retTresRad.setBounds(210, 90, 80, 30);
		add(retTresRad);
		buttonG.add(retTresRad);
		
		retCuatroRad = new JRadioButton("100.000");
		retCuatroRad.setBounds(290, 90, 80, 30);
		add(retCuatroRad);
		buttonG.add(retCuatroRad);
		
		retCincoRad = new JRadioButton("200.000");
		retCincoRad.setBounds(370, 90, 80, 30);
		add(retCincoRad);
		buttonG.add(retCincoRad);
		
		retSeisRad = new JRadioButton("");
		retSeisRad.setBounds(130, 115, 20, 30);
		add(retSeisRad);
		buttonG.add(retSeisRad);
		

		bienvenidolbl = new JLabel("Bienvenido:");
		bienvenidolbl.setBounds(50, 30, 150, 20);

		nombrelbl = new JLabel("    "+user.getPrimerNombre() +" "+ user.getSegundoNombre() +" "+ user.getPrimerApellido()
		+" "+ user.getSegundoApellido());
		nombrelbl.setBounds(140, 30, 300, 20);

		saldolbl = new JLabel("Saldo Disponible:  " + user.getSaldo());
		saldolbl.setBounds(50, 60, 250, 20);

		retirarBtn = new JButton("Retirar");
		retirarBtn.setBounds(280, 200, 100, 20);
		retirarBtn.setName("guardarBtn");
		retirarBtn.addActionListener(this);

		pagarBtn = new JButton("Pagar");
		pagarBtn.setBounds(100, 200, 100, 20);
		pagarBtn.setName("guardarBtn");
		pagarBtn.addActionListener(this);
		
		
		cajaRetiroLbl = new JLabel("Otro valor:");
		cajaRetiroLbl.setBounds(155, 120, 120, 20);
		
		cajaRetiroTxt = new JTextField("0.0");
		cajaRetiroTxt.setBounds(100, 150, 250, 20);

		this.add(titulo);
		this.add(bienvenidolbl);
		this.add(nombrelbl);
		this.add(saldolbl);
		this.add(retirarBtn);
		this.add(pagarBtn);
		this.add(retUnoRad);
		this.add(retDosRad);
		this.add(retTresRad);
		this.add(retCuatroRad);
		this.add(retCincoRad);
		this.add(retSeisRad);
		this.add(cajaRetiroTxt);
		this.add(cajaRetiroLbl);
		
		System.out.print(user.toString());
		
	}

	public void actionPerformed(ActionEvent e) {

		FuncionarioController fc = new FuncionarioController();
		boolean k;
		double total = 0;
		if (retUnoRad.isSelected()) {   
			total = 10000;
        }
		else if (retDosRad.isSelected()) {
        	total = 20000;
        }
		else if (retTresRad.isSelected()) {
        	total = 50000;
        }
		else if (retCuatroRad.isSelected()) {
        	total = 100000;
        }
		else if (retCincoRad.isSelected()) {
        	total = 200000;  		
         }
		else if (retSeisRad.isSelected()) {
        	total = Double.valueOf(cajaRetiroTxt.getText());  		
         }
         if (e.getSource() == retirarBtn){
 			k = h.RetirarSaldo(user,total);	
         	if (k == false){
         		JOptionPane.showMessageDialog(null, "Valor a retirar invalido");
         		return;	
         		}
         	else
         		JOptionPane.showMessageDialog(null, "Retiro Exitoso!");
         }
         if (e.getSource() == pagarBtn){
 			h.PagarSaldo(user,total);
 			JOptionPane.showMessageDialog(null, "Pago Exitoso!");
         }
         saldolbl.setText("Saldo Disponible:  " + user.getSaldo());
         
         
	}
	
}
