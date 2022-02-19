package it.myMediaApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.myMediaApp.domain.Movie;
import it.myMediaApp.dto.MovieDTO;
import it.myMediaApp.parser.ActorParser;
import it.myMediaApp.parser.MovieParser;
import it.myMediaApp.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;

	public MovieDTO createMovie(MovieDTO movie) {
		
		Movie parsed = MovieParser.fromDTOToEntity(movie);
		
		Movie saved = movieRepository.save(parsed);
		
		if(saved == null)
			return null;
		
		return MovieParser.fromEntityToDTO(saved);
	}

	public MovieDTO updateMovie(MovieDTO movie) {

		Optional<Movie> toUpdateMovie = movieRepository.findById(movie.getId());
		
		if(toUpdateMovie.isEmpty())
			return null;
		
		updateMovieBean(movie, toUpdateMovie.get());
		
		
		movieRepository.save(toUpdateMovie.get());
	
		
		return MovieParser.fromEntityToDTO(toUpdateMovie.get());
	}
	
	
	private void updateMovieBean(MovieDTO newMovie, Movie oldMovie) {
		
		oldMovie.setAuthor(newMovie.getAuthor());
		
		if(newMovie.getCast() != null)
			oldMovie.setCast(ActorParser.fromListDTOToEntity(newMovie.getCast()));
		
		oldMovie.setDescription(newMovie.getDescription());
		oldMovie.setTitle(newMovie.getTitle());
		oldMovie.setYear(newMovie.getYear());
		
	}
	

	public MovieDTO getMovie(Long id) {
		Optional<Movie> movie = movieRepository.findById(id);
		
		if(movie.isEmpty())
			return null;
		
		return MovieParser.fromEntityToDTO(movie.get());
		
		
	}

	public MovieDTO deleteMovie(Long id) {
		
		Optional<Movie> found = movieRepository.findById(id);
		
		if(found.isEmpty())
			return null;
		
		movieRepository.deleteById(found.get().getId());
		
		return MovieParser.fromEntityToDTO(found.get());
	}

	public List<MovieDTO> getAllMovies() {
		
		List<Movie> foundList = (List<Movie>) movieRepository.findAll();
		
		if(foundList == null)
			return null;
		
		return MovieParser.fromListEntityToDTO(foundList);
	
	}
	
	



}
