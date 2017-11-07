package com.project.Museify.controllers;

import com.project.Museify.models.Museify;
import com.project.Museify.services.MuseifyService;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MuseController {

    private final MuseifyService museifyService;

    public MuseController(MuseifyService museifyService) {
        this.museifyService = museifyService;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    //SHOW ALL
    @RequestMapping("/dashboard")
    public String dashboard(Model model, @ModelAttribute("song") Museify song) {
        List<Museify> songs = museifyService.allSongs();
        model.addAttribute("songs", songs);
        return "dashboard";
    }

    //SHOW ONE
    @RequestMapping("/song/{id}")
    public String findSongByIndex(@PathVariable("id") Long id, Model model) {
        model.addAttribute("song", museifyService.findSongById(id));
        return "displaySong";
    }


    //CREATE NEW
    @RequestMapping("/create/new")
    public String addSong(@ModelAttribute("song") Museify song) {
        System.out.println("new song");
        return "createSong";

    }

    @PostMapping("/add/new")
    public String addSong(@Valid @ModelAttribute("song") Museify song, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("song", museifyService.allSongs());
            return "song/newSong.jsp";
        }
        else {
            museifyService.addSong(song);
            return "redirect:/dashboard";
        }
    }

    //DELETE
    @RequestMapping(value = "/song/delete/{id}")
    public String destroySong(@PathVariable("id") Long id) {
        museifyService.destroySong(id);
        return "redirect:/dashboard";
    }


    //DISPLAY TOP TEN
    @RequestMapping("/search/topTen")
    public String topTen(Model model, @ModelAttribute("song") Museify song) {
		List<Museify> songs = museifyService.TopSongs();
        model.addAttribute("songs", songs);
        return "topTen";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam(value="name") String name, Museify song, HttpSession session) {
        session.setAttribute("name", name);
        System.out.println(name);
        return "redirect:/search/" + name;
    }

    @RequestMapping("/search/{name}")
    public String displaySearch(Model model, Museify song, HttpSession session, @PathVariable("name") String name) {
        System.out.println(name);
        List<Museify> songs = museifyService.searchSongs(name);
        model.addAttribute("songs", songs);
        return "byArtist";
    }




}