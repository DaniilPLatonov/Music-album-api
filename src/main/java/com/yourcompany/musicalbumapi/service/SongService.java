package com.yourcompany.musicalbumapi.service;

import com.yourcompany.musicalbumapi.model.Song;
import com.yourcompany.musicalbumapi.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }

    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public Optional<Song> updateSong(Long id, Song updatedSong) {
        Optional<Song> optionalSong = songRepository.findById(id);
        optionalSong.ifPresent(song -> {
            song.setTitle(updatedSong.getTitle());
            song.setRecordLabel(updatedSong.getRecordLabel());
            song.setDuration(updatedSong.getDuration());
            song.setLyrics(updatedSong.getLyrics());
            song.setLanguage(updatedSong.getLanguage());
            song.setAlbum(updatedSong.getAlbum());
            songRepository.save(song);
        });
        return optionalSong;
    }

    public boolean deleteSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if (optionalSong.isPresent()) {
            songRepository.delete(optionalSong.get());
            return true;
        }
        return false;
    }
}
