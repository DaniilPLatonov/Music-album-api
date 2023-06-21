package com.yourcompany.musicalbumapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(name = "record_label")
    private String recordLabel;
    private int duration;
    private String lyrics;
    private String language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "albumId")
    @JsonBackReference
    private Album album;


    public Song(Long id, String title, String recordLabel, int duration, String lyrics, String language, Album album) {
        this.id = id;
        this.title = title;
        this.recordLabel = recordLabel;
        this.duration = duration;
        this.lyrics = lyrics;
        this.language = language;
        this.album = album;
    }

    public Song() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Long getAlbumId() {
        return album != null ? album.getId() : null;
    }
}