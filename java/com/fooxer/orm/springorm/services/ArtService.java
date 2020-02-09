package com.fooxer.orm.springorm.services;

import com.fooxer.orm.springorm.entities.Artist;

import java.util.List;

public interface ArtService {
        Artist getArtistById(Integer id);
        void saveArtist( Artist artist);
        void deleteArtist (Integer id);
        void updateArtist (Integer art_id, String fullName, String link, String genre);
        List<Artist> findAll();
    }


