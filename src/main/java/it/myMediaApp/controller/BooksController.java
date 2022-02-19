package it.myMediaApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.myMediaApp.dto.BookDTO;
import it.myMediaApp.service.BookService;

@RestController
@RequestMapping("api/v1/books")
public class BooksController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping
	public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO book) {
		
		if(book == null)
			return ResponseEntity.badRequest().build();
		
		BookDTO newBook = bookService.createBook(book);
		
		if(newBook == null)
			return ResponseEntity.internalServerError().build();
		
		
		return ResponseEntity.ok(newBook);
		
	}
	
	@PutMapping
	public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO book) {
		
		if(book == null)
			return ResponseEntity.noContent().build();
		
		book = bookService.updateBook(book);
		
		
		if(book == null) 
			return ResponseEntity.unprocessableEntity().build();
		
		
		return ResponseEntity.ok(book);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
		
		if(id == null)
			return ResponseEntity.badRequest().build();
		
		if(id < 0L)
			return ResponseEntity.badRequest().build();
		
		BookDTO book = bookService.getBook(id);
		
		if(book == null)
			return ResponseEntity.noContent().build();
		
		
		return ResponseEntity.ok(book);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteBook(@PathVariable Long id) {
		
		if(id == null)
			return ResponseEntity.badRequest().build();
		
		if(id < 0L)
			return ResponseEntity.badRequest().build();
		
		BookDTO book = bookService.deleteBook(id);
		
		if(book == null)
			return ResponseEntity.noContent().build();
	
		
		return ResponseEntity.ok(true);
		
	}

	
	
	@GetMapping
	public ResponseEntity<List<BookDTO>> getAllBooks() {
		
		List<BookDTO> bookList = new ArrayList<BookDTO>();
		
		bookList = bookService.getAllBooks();
		
		if(bookList == null)
			return ResponseEntity.noContent().build();
		
		
		
		return ResponseEntity.ok(bookList);
	}
}
