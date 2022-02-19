package it.myMediaApp.parser;

import it.myMediaApp.dto.SongDTO;

import java.util.ArrayList;
import java.util.List;

import it.myMediaApp.domain.Song;

public class MusicParser {

	public static Song fromDTOToEntity(SongDTO dto) {

		Song entity = new Song();
		
		entity.setId(dto.getId());
		entity.setSinger(dto.getSinger());
		entity.setTitle(dto.getTitle());
		entity.setYear(dto.getYear());
		
		return entity;
	}

	public static SongDTO fromEntityToDTO(Song entity) {

		
		SongDTO dto = new SongDTO();
		
		dto.setId(entity.getId());
		dto.setSinger(entity.getSinger());
		dto.setTitle(entity.getTitle());
		dto.setYear(entity.getYear());
		
		return dto;	
		
	}

	public static List<SongDTO> fromListEntityToDTO(List<Song> entityList) {

		List<SongDTO> dtoList = new ArrayList<SongDTO>();
		
		for (Song s : entityList) {
			dtoList.add(fromEntityToDTO(s));
		}
		
		
		return dtoList;
	}

}
