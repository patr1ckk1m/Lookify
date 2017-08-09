package com.patrick.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.patrick.lookify.models.Song;
import com.patrick.lookify.repositories.SongRepository;

@Service
public class SongService {
	private SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public void addSong(Song song) {
		songRepository.save(song);
	}
	
	public List<Song> allSongs(){
		return (List<Song>) songRepository.findAll();
	}
	
	public void destroySong(Long id) {
		songRepository.delete(id);
	}
}
