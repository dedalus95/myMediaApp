package it.myMediaApp.dto;

import java.util.List;

public class TvSeriesDTO {
	
	private Long id;
	private Long year;
	private String description;
	private TvSeriesAuthorDTO author;
	private List<ActorDTO> cast;
	private String title;
	private List<StreamingProviderDTO> provider;
	private Long episodesNum;
	private Long seasonsNum;
	
	
	
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
	public TvSeriesAuthorDTO getAuthor() {
		return author;
	}
	public void setAuthor(TvSeriesAuthorDTO author) {
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

	public List<StreamingProviderDTO> getProvider() {
		return provider;
	}
	public void setProvider(List<StreamingProviderDTO> provider) {
		this.provider = provider;
	}
	public Long getEpisodesNum() {
		return episodesNum;
	}
	public void setEpisodesNum(Long episodesNum) {
		this.episodesNum = episodesNum;
	}
	public Long getSeasonsNum() {
		return seasonsNum;
	}
	public void setSeasonsNum(Long seasonsNum) {
		this.seasonsNum = seasonsNum;
	}
	
	
	
}
