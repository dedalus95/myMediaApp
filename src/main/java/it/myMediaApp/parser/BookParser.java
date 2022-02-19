package it.myMediaApp.parser;

import java.util.ArrayList;
import java.util.List;

import it.myMediaApp.domain.Book;
import it.myMediaApp.dto.BookDTO;

public class BookParser {

	public static Book fromDTOToEntity(BookDTO dto) {
		
		Book entity = new Book();
		
		entity.setId(dto.getId());
		entity.setAuthor(dto.getAuthor());
		entity.setDescription(dto.getDescription());
		entity.setTitle(dto.getTitle());
		entity.setYear(dto.getYear());


		return entity;
		
	}

	public static BookDTO fromEntityToDTO(Book entity) {

		BookDTO dto = new BookDTO();
		
		dto.setAuthor(entity.getAuthor());
		dto.setDescription(entity.getDescription());
		dto.setTitle(entity.getTitle());
		dto.setYear(entity.getYear());
		dto.setId(entity.getId());


		return dto;	
		
	}

	public static List<BookDTO> fromListEntityToDTO(List<Book> dbBooksList) {
		
		List<BookDTO> dtoList = new ArrayList<BookDTO>();
		
		for (Book b : dbBooksList) {
			
			dtoList.add(fromEntityToDTO(b));
			
		}
		
		return dtoList;
	}

}
