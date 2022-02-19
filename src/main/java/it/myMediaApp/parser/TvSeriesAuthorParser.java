package it.myMediaApp.parser;

import it.myMediaApp.domain.TvSeriesAuthor;
import it.myMediaApp.dto.TvSeriesAuthorDTO;

public class TvSeriesAuthorParser {

	public static TvSeriesAuthor fromDTOToEntity(TvSeriesAuthorDTO dto) {

		TvSeriesAuthor entity = new TvSeriesAuthor();
		
		entity.setId(dto.getId());
		entity.setGroup(dto.getGroup());
		entity.setName(dto.getName());
		
		
		return entity;
	}
	
	public static TvSeriesAuthorDTO fromEntityToDTO(TvSeriesAuthor entity) {

		TvSeriesAuthorDTO dto = new TvSeriesAuthorDTO();
		
		dto.setId(entity.getId());
		dto.setGroup(entity.getGroup());
		dto.setName(entity.getName());
		
		
		return dto;
	}

}
