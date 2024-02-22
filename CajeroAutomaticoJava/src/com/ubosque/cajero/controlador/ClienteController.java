package com.ubosque.cajero.controlador;

import javax.swing.JOptionPane;

import com.ubosque.cajero.modelo.Usuario;

public class ClienteController {
	Usuario us = new Usuario();
	
	
	public boolean RetirarSaldo(Usuario us,double sald){
		if (us.getSaldo() - sald < 0 || sald < 0)
			
			return false;
	
		else
			us.setSaldo((int) (us.getSaldo() - sald));
			uc.actualizarUsuario(us);
		return true;
	}
	public boolean PagarSaldo(Usuario user , double monto){
		
			user.setSaldo((int) (user.getSaldo() + monto));
			uc.actualizarUsuario(user);
			return true;
			
			
	}

}
