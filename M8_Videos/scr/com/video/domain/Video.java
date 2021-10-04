package com.video.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

import com.video.application.CamposVacios;

public class Video {
	Scanner sc;
	
	protected int id;
	private static int COUNTER_VIDEOS = 1;
	private String url;
	private String title;
	private List<Tag> tags;	
	private LocalDateTime videoUploadDate;
	enum Status {UPLOADING, VERIFYING, PUBLIC};
	Status status;
	
		
	public Video(String url, String title){
		setTitle(title);
		setUrl(url);
		this.videoUploadDate = LocalDateTime.now();	
		this.tags = new ArrayList<Tag>();
		this.id = COUNTER_VIDEOS;
		COUNTER_VIDEOS++;
	}
	
	
	public int getId() {
		return id;
	}	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Tag> getTags() {
		return tags;
	}

	public void addTag(){	
		
		String opcion, tagName = null;	
		sc = new Scanner(System.in);
		do {
			System.out.println("Añadir etiqueta al video: [si]/[no]");
			opcion = sc.nextLine();
			
			if (opcion.equalsIgnoreCase("si")) {
				System.out.println("Nombre de la etiqueta:");
				tagName = sc.nextLine();		
				
				try {
					tags.add(new Tag(tagName));
				} catch (CamposVacios e) {					
					System.err.println(e.getMessage());
				}
			}
		}while (opcion.equalsIgnoreCase("si"));
		
	}
	
	//obtener el estado de subida del video
	public String getStatus() {			
				
		long tiempo = Duration.between(videoUploadDate, LocalDateTime.now()).toMillis();
		
		if (tiempo < 10000) { // si es menos de 10 segundos será uploading
			status = Status.UPLOADING;
			
			
			// entre 10 y 20 segundos será verifying
		} else if (tiempo > 10000 && tiempo < 20000) {
			status = Status.VERIFYING;
						
			// sino más de 20 segundos será public
		}else {
			status = Status.PUBLIC;
		}

		return status.toString();
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", url=" + url + ", title=" + title + ", tags=" + tags + ", videoUploadDate="
				+ videoUploadDate + ", status=" + getStatus() + "]";
	}
	
}
