package it.myMediaApp.dto;

import java.util.List;


public class MovieDTO {

	private Long id;
	
	private Long year;
	
	private String description;
	
	private String author;

	private List<ActorDTO> cast;
	
	private String title;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<ActorDTO> getCast() {
		return cast;
	}

	public void setCast(List<ActorDTO> cast) {
		this.cast = cast;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
