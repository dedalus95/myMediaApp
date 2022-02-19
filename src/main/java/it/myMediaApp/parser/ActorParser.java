package it.myMediaApp.parser;

import java.util.ArrayList;
import java.util.List;

import it.myMediaApp.domain.Actor;
import it.myMediaApp.dto.ActorDTO;

public class ActorParser {
	
	public static Actor fromDTOToEntity(ActorDTO dto) {
		
		Actor entity = new Actor();
		
		entity.setAge(dto.getAge());
		entity.setFullName(dto.getFullName());
		entity.setId(dto.getId());
		
		return entity;
	}
	
	public static ActorDTO fromEntityToDTO(Actor entity) {
		
		ActorDTO dto = new ActorDTO();
		
		dto.setAge(entity.getAge());
		dto.setFullName(entity.getFullName());
		dto.setId(entity.getId());
		
		return dto;
		
	}

	public static List<Actor> fromListDTOToEntity(List<ActorDTO> dtoCast) {
		
		
		List<Actor> entityCast = new ArrayList<Actor>();
		
		for (ActorDTO a : dtoCast) {
			
			entityCast.add(fromDTOToEntity(a));
		}
		
		return entityCast;
		
	}
	
	
	public static List<ActorDTO> fromListEntityToDTO(List<Actor> entityCast) {
		
		List<ActorDTO> dtoCast = new ArrayList<ActorDTO>();
		
		for (Actor a : entityCast) {
			dtoCast.add(fromEntityToDTO(a));
		}
		
		return dtoCast;
	}

}
