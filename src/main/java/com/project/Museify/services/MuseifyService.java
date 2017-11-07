package com.project.Museify.services;
import org.springframework.stereotype.Controller;

import java.util.List;
import com.project.Museify.models.Museify;
import com.project.Museify.repositories.MuseifyRepository;

@Controller
public class MuseifyService {
    private MuseifyRepository museifyRepository;

    public MuseifyService(MuseifyRepository museifyRepository) {
        this.museifyRepository = museifyRepository;
    }

    public List<Museify> allSongs() {
        return museifyRepository.findAll();
    }

    public void addSong(Museify song) {
        museifyRepository.save(song);
    }

    public void destroySong(Long id) {
        museifyRepository.delete(id);
    }

    public Museify findSongById(Long id) {
        return museifyRepository.findOne(id);
    }

    public void updateSong(Museify song) {
        museifyRepository.save(song);
    }
    
    public List<Museify> TopSongs() {
        return museifyRepository.findTop10ByOrderByRaitingDesc();
    }

    public List<Museify> searchSongs(String search) {
        return museifyRepository.findByArtistContaining(search);
    }
    

}

