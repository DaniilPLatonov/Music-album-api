package com.yourcompany.musicalbumapi.service;

import com.yourcompany.musicalbumapi.model.Album;
import com.yourcompany.musicalbumapi.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Optional<Album> getAlbumById(Long id) {
        return albumRepository.findById(id);
    }

    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Optional<Album> updateAlbum(Long id, Album updatedAlbum) {
        Optional<Album> optionalAlbum = albumRepository.findById(id);
        optionalAlbum.ifPresent(album -> {
            album.setTitle(updatedAlbum.getTitle());
            album.setArtist(updatedAlbum.getArtist());
            album.setReleaseYear(updatedAlbum.getReleaseYear());
            album.setGenre(updatedAlbum.getGenre());
            album.setSongs(updatedAlbum.getSongs());
            albumRepository.save(album);
        });
        return optionalAlbum;
    }

    public boolean deleteAlbum(Long id) {
        Optional<Album> optionalAlbum = albumRepository.findById(id);
        if (optionalAlbum.isPresent()) {
            albumRepository.delete(optionalAlbum.get());
            return true;
        }
        return false;
    }
}
