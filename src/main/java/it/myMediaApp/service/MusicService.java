package it.myMediaApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.myMediaApp.domain.Song;
import it.myMediaApp.dto.SongDTO;
import it.myMediaApp.parser.MusicParser;
import it.myMediaApp.repository.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	MusicRepository musicRepository;

	public SongDTO addSong(SongDTO song) {
		
		Song repoSong = MusicParser.fromDTOToEntity(song);
		
		musicRepository.save(repoSong);
		
		if(repoSong == null)
			return null;
		
	
		return MusicParser.fromEntityToDTO(repoSong);
	}

	public SongDTO updateSong(SongDTO song) {

		Optional<Song> repoSong = musicRepository.findById(song.getId());
		
		if(repoSong.isEmpty())
			return null;
		
		updateSongBean(song, repoSong.get());
		
		musicRepository.save(repoSong.get());
		
		
		return MusicParser.fromEntityToDTO(repoSong.get());

	}

	private void updateSongBean(SongDTO song, Song repoSong) {

		repoSong.setSinger(song.getSinger());
		repoSong.setTitle(song.getTitle());
		repoSong.setYear(song.getYear());
	}

	public SongDTO getSong(Long id) {
		
		Optional<Song> found = musicRepository.findById(id);
		
		if(found.isEmpty())
			return null;
		
		
		return MusicParser.fromEntityToDTO(found.get());
	}

	public SongDTO deleteSong(Long id) {

		Optional<Song> songToDelete = musicRepository.findById(id);
		
		if(songToDelete.isEmpty())
			return null;
		
		musicRepository.deleteById(id);
		
		
		return MusicParser.fromEntityToDTO(songToDelete.get());
	}

	public List<SongDTO> getAllSongs() {

		List<Song> songList = (List<Song>) musicRepository.findAll();
		
		if(songList == null)
			return null;
		
		return MusicParser.fromListEntityToDTO(songList);
	}

}
