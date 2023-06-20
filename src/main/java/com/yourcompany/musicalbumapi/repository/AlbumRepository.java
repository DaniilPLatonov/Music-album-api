package com.yourcompany.musicalbumapi.repository;

import com.yourcompany.musicalbumapi.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
