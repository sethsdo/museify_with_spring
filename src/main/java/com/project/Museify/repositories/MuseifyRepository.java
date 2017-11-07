package com.project.Museify.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.Museify.models.Museify;

@Repository
public interface MuseifyRepository extends CrudRepository<Museify, Long> {
    List<Museify> findAll();

    List<Museify> findTop10ByOrderByRaitingDesc();

    List<Museify> findByArtistContaining(String search);
}