package com.video.domain;

import java.time.LocalDate;
import java.util.*;

import com.video.application.CamposVacios;

public class User {
	protected int id;
	private String name;
	private String lastname;
	private String password;
	private LocalDate registerDate;
	private List<Video> videoList = new ArrayList<Video>();
	
	private static int COUNTER_USERS = 1;
	
	
	public User(int id, String name, String lastname, String password) {
						
		setName(name);
		setLastname(lastname);
		setPassword(password);
		this.registerDate = LocalDate.now();
		this.id = COUNTER_USERS;
		COUNTER_USERS++;
	}	
		
	
	public User(String name, String lastname, String password) {
		setName(name);
		setLastname(lastname);
		setPassword(password);
		this.registerDate = LocalDate.now();
		this.id = COUNTER_USERS;
		COUNTER_USERS++;
	}

	public int getId() {
		return id;
	}

	public static int getCOUNTER_USERS() {
		return COUNTER_USERS;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRegisterDate() {
		return registerDate.toString();
	}

	public void createVideo(String url, String title) throws Exception{
		if (title.equals("") || title == null)
			throw new CamposVacios("El campo title " + CamposVacios.CAMPO_VACIO);
		if (url.equals("") || url == null)
			throw new CamposVacios("El campo url " + CamposVacios.CAMPO_VACIO);
		Video v = new Video(title,url);		
		v.addTag();
		videoList.add(v);
	}
	
	public String viewVideos() {
		StringBuffer res= new StringBuffer("Listado de videos:\n\n");
		for(Video v: videoList) {
			res.append(v).append("\n");
		}
		return res.toString();
	}
	
	public Video getVideo(int index) {
		return videoList.get(index);
	}
}
