package it.myMediaApp.controller;

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

import it.myMediaApp.dto.MovieDTO;
import it.myMediaApp.service.MovieService;

@RestController
@RequestMapping("api/v1/movies")
public class MoviesController {
	
	@Autowired
	MovieService movieService;

	
	@PostMapping
	public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movie) {
		
		if(movie == null)
			return ResponseEntity.badRequest().build();
		
		MovieDTO newMovie = movieService.createMovie(movie);
		
		if(newMovie == null)
			return ResponseEntity.internalServerError().build();
		
		
		
		return ResponseEntity.ok(newMovie);
		
	}
	
	
	@PutMapping
	public ResponseEntity<MovieDTO> updateMovie(@RequestBody MovieDTO movie) {
		
		
		if(movie == null)
			return ResponseEntity.badRequest().build();	
		
		MovieDTO updatedMovie = movieService.updateMovie(movie);
			
		if(updatedMovie == null)
			return ResponseEntity.internalServerError().build();
		
		return ResponseEntity.ok(updatedMovie);
		
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<MovieDTO> getMovie(@PathVariable Long id) {
		
		if(id < 0L)
			return ResponseEntity.badRequest().build();
		
		
		MovieDTO found = movieService.getMovie(id);
		
		if(found == null)
			return ResponseEntity.noContent().build();
		
		
		
		return ResponseEntity.ok(found);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteMovie(@PathVariable Long id) {
		
		if(id < 0L)
			return ResponseEntity.badRequest().build();
		
		MovieDTO deletedMovie = movieService.deleteMovie(id);
		
		if(deletedMovie == null)
			return ResponseEntity.noContent().build();
		
	
		return ResponseEntity.ok(true);
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<MovieDTO>> getAllMovies() {
		
		List<MovieDTO> moviesList = movieService.getAllMovies();
		
		if(moviesList == null)
			return null;
		
		return ResponseEntity.ok(moviesList);
		
	}
}
