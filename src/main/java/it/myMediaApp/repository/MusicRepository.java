package it.myMediaApp.repository;

import org.springframework.data.repository.CrudRepository;

import it.myMediaApp.domain.Song;

public interface MusicRepository extends CrudRepository<Song, Long>{

}
