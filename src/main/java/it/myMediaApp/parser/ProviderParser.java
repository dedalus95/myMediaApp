package it.myMediaApp.parser;

import java.util.ArrayList;
import java.util.List;

import it.myMediaApp.domain.StreamingProvider;
import it.myMediaApp.dto.StreamingProviderDTO;

public class ProviderParser {
	
	
	
	public static StreamingProvider fromDTOToEntity(StreamingProviderDTO dto) {
		
		StreamingProvider entity = new StreamingProvider();
		
		entity.setFree(dto.isFree());
		entity.setName(dto.getName());
		entity.setId(dto.getId());
		
		return entity;
	}
	
	public static StreamingProviderDTO fromEntityToDTO(StreamingProvider entity) {
		
		StreamingProviderDTO dto = new StreamingProviderDTO();
		
		dto.setFree(entity.isFree());
		dto.setName(entity.getName());
		dto.setId(entity.getId());
		
		return dto;
	}
	
	
	

	public static List<StreamingProvider> fromListDTOToEntity(List<StreamingProviderDTO> listDTO) {

		List<StreamingProvider> listEntity = new ArrayList<StreamingProvider>();
		
		for (StreamingProviderDTO sp : listDTO) {
			
			listEntity.add(fromDTOToEntity(sp));
			
		}
		
		return listEntity;
	}
	
	public static List<StreamingProviderDTO> fromListEntityToDTO(List<StreamingProvider> listEntity) {

		List<StreamingProviderDTO> listDTO = new ArrayList<StreamingProviderDTO>();
		
		for (StreamingProvider sp : listEntity) {
			
			listDTO.add(fromEntityToDTO(sp));
			
		}
		
		return listDTO;
	}

	
}
