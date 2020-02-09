package com.fooxer.orm.springorm.repository;

import com.fooxer.orm.springorm.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtRepository extends JpaRepository<Artist,Integer> {
}
