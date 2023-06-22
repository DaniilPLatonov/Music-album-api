package com.yourcompany.musicalbumapi.service;

import com.yourcompany.musicalbumapi.model.Album;
import com.yourcompany.musicalbumapi.model.Song;
import com.yourcompany.musicalbumapi.repository.SongRepository;
import com.yourcompany.musicalbumapi.repository.AlbumRepository; // Добавлен импорт репозитория для альбомов
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongService(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }

    public Song createSong(Song song) {
        Long albumId = song.getAlbum().getId();
        Optional<Album> optionalAlbum = albumRepository.findById(albumId);
        if (optionalAlbum.isPresent()) {
            return songRepository.save(song);
        } else {
            return null;
        }
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
