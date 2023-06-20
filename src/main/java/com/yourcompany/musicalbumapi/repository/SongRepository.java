package com.yourcompany.musicalbumapi.repository;

import com.yourcompany.musicalbumapi.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
