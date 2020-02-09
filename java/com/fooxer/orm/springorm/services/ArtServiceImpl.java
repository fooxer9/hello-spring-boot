package com.fooxer.orm.springorm.services;

import com.fooxer.orm.springorm.entities.Artist;
import com.fooxer.orm.springorm.repository.ArtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtServiceImpl implements ArtService {

    private ArtRepository repository;

    @Autowired
    public void setProductRepository (ArtRepository repo) {
        this.repository = repo;
    }

    @Override
    public Artist getArtistById(Integer id) {
        return repository.findById(id).get();
    }
    @Override
    public void saveArtist(Artist artist) {
        repository.save(artist);
    }
    @Override
    public void deleteArtist(Integer id) {
        repository.deleteById(id);
    }
    @Override
    public void updateArtist(Integer id, String fullName, String link, String genre) {
        Artist updated = repository.findById(id).get();
        updated.setArt_fullName(fullName);
        updated.setArt_link(link);
        updated.setArt_genre(genre);
        repository.save(updated);
    }
    @Override
    public List<Artist> findAll() {
        return repository.findAll();
    }
}
