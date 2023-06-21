CREATE TABLE albums (
                        album_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                        title VARCHAR(64) NOT NULL,
                        artist VARCHAR(64) NOT NULL,
                        release_year INT NOT NULL,
                        genre VARCHAR(64) NOT NULL
);


CREATE TABLE songs (
                       song_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                       title VARCHAR(64) NOT NULL,
                       record_label VARCHAR(64) NOT NULL,
                       duration INT NOT NULL,
                       lyrics TEXT,
                       language VARCHAR(64),
                       album_id INT NOT NULL,
                       FOREIGN KEY (album_id) REFERENCES albums(album_id)
);