package com.video.view;

import java.util.*;

import com.video.application.Controller;


public class AppVideo {

	private static Controller controller = new Controller();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int op = 0;		
		
		while (op != 3) {
			System.out.println("1-Registrar Usuario \n2-Login Usuario \n3-Salir");
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				createUser();
				break;
			case 2:
				loginUser();
				break;
			case 3:
				System.out.println("Saliendo de la aplicación...");
				break;
			default:
				System.out.println("Opcion no permitida");
			}
		}
	}

	private static void loginUser() {
		//comprobar si el usuario existe
		String name, password;
		System.out.println("Introduce tu nombre:");
		name = sc.nextLine();
		System.out.println("Introduce contraseña:");
		password = sc.nextLine();
		
		int existe = controller.getValidUser(name, password);
			
		//si existe mostrar un menú con opciones
		if(existe == -1) {
			System.err.println("Usuario no registrado");
		}else {
			int opc = 0;
			while(opc!=3) {
				System.out.println("1-Ver Videos Usuario \n"
						+ "2-Crear Video \n"
						+ "3 Salir ");
				opc = sc.nextInt();
				sc.nextLine();
				switch(opc) {
				case 1:
					System.out.println(controller.getUser(existe).viewVideos());
					break;
				case 2:
					createVideo(existe);
					break;
				case 3:
					System.out.println("Saliendo de las opciones de video...");
					break;
				default:
					System.out.println("Opcion no permitida");
				}
			}
		}
	}

	private static void createVideo(int existe) {
		String title, url;
		System.out.println("Introduce la url del vídeo:");
		url = sc.nextLine();

		System.out.println("Introduce título:");
		title = sc.nextLine();			
		
		try {
			controller.getUser(existe).createVideo(url, title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	

	private static void createUser() {
		String name, lastname, password;

		System.out.println("Introduce tu nombre:");
		name = sc.nextLine();

		System.out.println("Introduce tu apellido:");
		lastname = sc.nextLine();

		System.out.println("Introduce contraseña:");
		password = sc.nextLine();
		
		try {
			controller.createUser(name, lastname, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
	}
	
	
}
