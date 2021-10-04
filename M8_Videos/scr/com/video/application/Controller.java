package com.video.application;

import java.util.*;

import com.video.domain.User;
import com.video.persistence.Repository;

public class Controller {
	
	// la lista funciona como una base de datos
	private Repository database = new Repository();
	
	public void createUser(String name, String lastname, String password) throws CamposVacios {
		if (name.equals("") || name == null)
			throw new CamposVacios("El campo name " + CamposVacios.CAMPO_VACIO);
		if (lastname.equals("") || lastname == null)
			throw new CamposVacios("El campo lastname " + CamposVacios.CAMPO_VACIO);
		if (password.equals("") || password == null)
			throw new CamposVacios("El campo password " + CamposVacios.CAMPO_VACIO);
		
		User u = new User(name, lastname, password);
		database.addUser(u);
	}
	
	public User getUser(int id) {
		return database.getUserList().get(id);
	}
	
	//obtener el usuario logueado si existe en la database
	public int getValidUser(String name, String password) {
		int exist = -1; //lo debolverá si el usuario no existe
		List<User> lista = database.getUserList();
		for(int i=0; i<lista.size(); i++) {
			User u = lista.get(i);
			
			if(u.getName().equalsIgnoreCase(name) && u.getPassword().equalsIgnoreCase(password)){
				exist = i;
			}
		}
		return exist;
	}
}
