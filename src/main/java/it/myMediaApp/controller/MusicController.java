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

import it.myMediaApp.dto.SongDTO;
import it.myMediaApp.service.MusicService;

@RestController
@RequestMapping("api/v1/music")
public class MusicController {
	
	@Autowired
	MusicService musicService;
	
	@PostMapping
	public ResponseEntity<SongDTO> addSong(@RequestBody SongDTO song) {
		
		if(song == null)
			return ResponseEntity.badRequest().build();
		
		song = musicService.addSong(song);
		
		if(song == null)
			return ResponseEntity.internalServerError().build();
		
		return ResponseEntity.ok(song);
		
	}
	
	
	@PutMapping
	public ResponseEntity<SongDTO> updateSong(@RequestBody SongDTO song) {
		
		if(song == null)
			return ResponseEntity.badRequest().build();
		
		song = musicService.updateSong(song);
		
		
		if(song == null) 
			return ResponseEntity.internalServerError().build();
		
		
		return ResponseEntity.ok(song);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<SongDTO> getSong(@PathVariable Long id) {
		
		
		if(id < 0L)
			return ResponseEntity.badRequest().build();

		SongDTO song = musicService.getSong(id);
		
		if(song == null)
			return ResponseEntity.noContent().build();
		
		
		return ResponseEntity.ok(song);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteSong(@PathVariable Long id) {
		
		if(id < 0L)
			return ResponseEntity.badRequest().build();
		
		SongDTO deletedSong = musicService.deleteSong(id);
		
		
		if(deletedSong == null)
			return ResponseEntity.noContent().build();
		
		
		
		return ResponseEntity.ok(true);
	}
	
	
	@GetMapping
	public ResponseEntity<List<SongDTO>> getAll() {
		
		List<SongDTO> songList = musicService.getAllSongs();
		
		if(songList == null)
			return ResponseEntity.noContent().build();
		
		
		return ResponseEntity.ok(songList);
		
	}

	
}
