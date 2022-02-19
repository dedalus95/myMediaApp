package it.myMediaApp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class TvSeries {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private Long year;
	
	@Column
	private String description;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "fk-tvseries")
	private TvSeriesAuthor author;
	
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "fk-tvseries")
	private List<StreamingProvider> provider;
	
	@Column
	private String title;
	
	@Column
	private Long episodeNum;
	
	@Column
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
	public TvSeriesAuthor getAuthor() {
		return author;
	}
	public void setAuthor(TvSeriesAuthor author) {
		this.author = author;
	}

	public List<StreamingProvider> getProvider() {
		return provider;
	}
	public void setProvider(List<StreamingProvider> provider) {
		this.provider = provider;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getEpisodeNum() {
		return episodeNum;
	}
	public void setEpisodeNum(Long episodeNum) {
		this.episodeNum = episodeNum;
	}
	public Long getSeasonsNum() {
		return seasonsNum;
	}
	public void setSeasonsNum(Long seasonsNum) {
		this.seasonsNum = seasonsNum;
	}
	
	
	

}
