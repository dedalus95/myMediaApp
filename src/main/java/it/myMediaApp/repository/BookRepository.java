package it.myMediaApp.repository;

import org.springframework.data.repository.CrudRepository;

import it.myMediaApp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
