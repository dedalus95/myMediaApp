package it.myMediaApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.myMediaApp.domain.Book;
import it.myMediaApp.dto.BookDTO;
import it.myMediaApp.parser.BookParser;
import it.myMediaApp.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	public BookDTO createBook(BookDTO newBook) {
		
		Book book = BookParser.fromDTOToEntity(newBook);
		
		if(book == null)
			return null;
		
		book = bookRepository.save(book);
		
		
		if(book == null)
			return null;
		
		
		return BookParser.fromEntityToDTO(book);

	}

	public BookDTO updateBook(BookDTO book) {
		
		Book repositoryBook = BookParser.fromDTOToEntity(book);
		
		
		Optional<Book> found = bookRepository.findById(repositoryBook.getId());
		
		if(found.isEmpty())
			return null;
		
		
		
		Book updatedBook = bookRepository.save(repositoryBook);
		
		
		return BookParser.fromEntityToDTO(updatedBook);
	}

	public BookDTO getBook(Long id) {
		
		Optional<Book> found = bookRepository.findById(id);
		
		if(found.isEmpty())
			return null;
		
		
		
		
		return BookParser.fromEntityToDTO(found.get());
	}

	public BookDTO deleteBook(Long id) {
		
		Optional<Book> found = bookRepository.findById(id);
		
		if(found.isEmpty())
			return null;
		
		bookRepository.deleteById(found.get().getId());
		
		return BookParser.fromEntityToDTO(found.get());
	}

	public List<BookDTO> getAllBooks() {
		

		List<Book> dbBooksList = (List<Book>) bookRepository.findAll();
		
		if(dbBooksList == null)
			return null;
		
	
		return BookParser.fromListEntityToDTO(dbBooksList);
	}


	
}
