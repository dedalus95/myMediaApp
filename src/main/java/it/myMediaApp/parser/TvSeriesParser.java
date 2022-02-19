package it.myMediaApp.parser;

import java.util.ArrayList;
import java.util.List;

import it.myMediaApp.domain.TvSeries;
import it.myMediaApp.dto.TvSeriesDTO;

public class TvSeriesParser {

	public static TvSeries fromDTOToEntity(TvSeriesDTO dto) {

		TvSeries entity = new TvSeries();
		
		entity.setAuthor(TvSeriesAuthorParser.fromDTOToEntity(dto.getAuthor()));
		entity.setDescription(dto.getDescription());
		entity.setEpisodeNum(dto.getEpisodesNum());
		entity.setId(dto.getId());
		
		if(dto.getProvider() != null)
			entity.setProvider(ProviderParser.fromListDTOToEntity(dto.getProvider()));
		
		
		entity.setSeasonsNum(dto.getSeasonsNum());
		entity.setTitle(dto.getTitle());
		entity.setYear(dto.getYear());
		
		
		return entity;
		
	}
	
	public static TvSeriesDTO fromEntityToDTO(TvSeries entity) {

		TvSeriesDTO dto = new TvSeriesDTO();
		
		dto.setAuthor(TvSeriesAuthorParser.fromEntityToDTO(entity.getAuthor()));
		dto.setDescription(entity.getDescription());
		dto.setEpisodesNum(entity.getEpisodeNum());
		dto.setId(entity.getId());
		
		if(entity.getProvider() != null)
			dto.setProvider(ProviderParser.fromListEntityToDTO(entity.getProvider()));
		
		dto.setSeasonsNum(entity.getSeasonsNum());
		dto.setTitle(entity.getTitle());
		dto.setYear(entity.getYear());
		
		
		return dto;
		
	}

	public static List<TvSeriesDTO> fromListEntityToDTO(List<TvSeries> listEntity) {

		List<TvSeriesDTO> listDTO = new ArrayList<TvSeriesDTO>();
		
		for (TvSeries ts : listEntity) {
			listDTO.add(fromEntityToDTO(ts));
		}
		
		return listDTO;
	}
	
	
	
	
	
	

	
	
}
