package it.myMediaApp.repository;

import org.springframework.data.repository.CrudRepository;

import it.myMediaApp.domain.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long>{

}
