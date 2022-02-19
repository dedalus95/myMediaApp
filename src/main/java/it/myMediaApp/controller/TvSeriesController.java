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

import it.myMediaApp.dto.TvSeriesDTO;
import it.myMediaApp.service.TvSeriesService;


@RestController
@RequestMapping("api/v1/tv-series")
public class TvSeriesController {
	
	@Autowired
	TvSeriesService tvSeriesService;
	
	@PostMapping
	public ResponseEntity<TvSeriesDTO> addTvSeries(@RequestBody TvSeriesDTO tvSeries) {
		
		if(tvSeries == null)
			return ResponseEntity.badRequest().build();
		
		tvSeries = tvSeriesService.addTvSeries(tvSeries);
		
		if(tvSeries == null)
			return ResponseEntity.internalServerError().build();
		
		return ResponseEntity.ok(tvSeries);
		
	}
	
	
	@PutMapping
	public ResponseEntity<TvSeriesDTO> updateTvSeries(@RequestBody TvSeriesDTO tvSeries) {
		
		if(tvSeries == null)
			return ResponseEntity.badRequest().build();
		
		tvSeries = tvSeriesService.updateSong(tvSeries);
		
		
		if(tvSeries == null) 
			return ResponseEntity.internalServerError().build();
		
		
		return ResponseEntity.ok(tvSeries);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<TvSeriesDTO> getTvSeries(@PathVariable Long id) {
		
		
		if(id < 0L)
			return ResponseEntity.badRequest().build();

		TvSeriesDTO tvSeries = tvSeriesService.getTvSeries(id);
		
		if(tvSeries == null)
			return ResponseEntity.noContent().build();
		
		
		return ResponseEntity.ok(tvSeries);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteTvSeris(@PathVariable Long id) {
		
		if(id < 0L)
			return ResponseEntity.badRequest().build();
		
		TvSeriesDTO deletedTvSeries = tvSeriesService.deleteTvSeries(id);
		
		
		if(deletedTvSeries == null)
			return ResponseEntity.noContent().build();
		
		
		
		return ResponseEntity.ok(true);
	}
	
	
	@GetMapping
	public ResponseEntity<List<TvSeriesDTO>> getAll() {
		
		List<TvSeriesDTO> tvSeriesList = tvSeriesService.getAllTvSeries();
		
		if(tvSeriesList == null)
			return ResponseEntity.noContent().build();
		
		
		return ResponseEntity.ok(tvSeriesList);
		
	}


}
