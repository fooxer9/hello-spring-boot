package com.fooxer.orm.springorm.entities;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "artist_tbl")
public class Artist {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column(name="art_id")
    private Integer art_id;
    @Column(name="art_fullname")
    private String art_fullName;
    @Column (name = "art_link")
    private String art_link;
    @Column (name = "art_genre")
    private String art_genre;

    public Artist() {

    }

    public Artist(String name, String link, String genre) {
        this.art_fullName =name;
        this.art_link = link;
        this.art_genre = genre;
    }

    public String getArt_fullName() {
        return art_fullName;
    }

    public void setArt_fullName(String art_fullName) {
        this.art_fullName = art_fullName;
    }

    public String getArt_link() {
        return art_link;
    }

    public void setArt_link(String art_link) {
        this.art_link = art_link;
    }

    public String getArt_genre() {
        return art_genre;
    }

    public void setArt_genre(String art_genre) {
        this.art_genre = art_genre;
    }
    public Integer getArt_id() {
        return art_id;
    }

    public void setArt_id(Integer art_id) {
        this.art_id = art_id;
    }
}

