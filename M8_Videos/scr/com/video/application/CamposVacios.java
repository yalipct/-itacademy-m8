package com.video.application;

public class CamposVacios extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String CAMPO_VACIO = "no puede estar vacío";
	public static final String ERROR_TIPO = "Error - Has introducido un número";
	
	
	public CamposVacios(String mensaje) {
		super(mensaje);
		
	}

}
