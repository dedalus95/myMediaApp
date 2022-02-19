package it.myMediaApp.parser;

import java.util.ArrayList;
import java.util.List;

import it.myMediaApp.domain.Movie;
import it.myMediaApp.dto.MovieDTO;

public class MovieParser {

	public static Movie fromDTOToEntity(MovieDTO dto) {
		
		Movie entity = new Movie();
		
		if(dto.getCast() != null)
			entity.setCast(ActorParser.fromListDTOToEntity(dto.getCast()));
		
		
		entity.setAuthor(dto.getAuthor());
		entity.setDescription(dto.getDescription());
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setYear(dto.getYear());
		
		return entity;
	}
	
	
	public static MovieDTO fromEntityToDTO(Movie entity) {
		
		MovieDTO dto = new MovieDTO();
		
		if(entity.getCast() != null) 
			dto.setCast(ActorParser.fromListEntityToDTO(entity.getCast()));
		
		
		dto.setAuthor(entity.getAuthor());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setYear(entity.getYear());
		
		return dto;
	}


	public static List<MovieDTO> fromListEntityToDTO(List<Movie> entityList) {

		List<MovieDTO> dtoList = new ArrayList<MovieDTO>();
		
		for (Movie m : entityList) {
			dtoList.add(fromEntityToDTO(m));
		}
		
		return dtoList;
	}
	

	
		
	
}
