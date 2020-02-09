package com.fooxer.orm.springorm;


import com.fooxer.orm.springorm.entities.Artist;
import com.fooxer.orm.springorm.services.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
public class GetController {
    private ArtService service;

    @Autowired
    public void setArtService(ArtService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index () {
        return "index";
    }


    @GetMapping("/pages/table")
    public String table(Model model) {
        model.addAttribute("artists",service.findAll());
        return "pages/table";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Artist artist = service.getArtistById(id);
        model.addAttribute("artist",artist);
        return "db/edit";
    }
    @GetMapping("/new")
    public String create() {
        return "db/new";
    }
    @GetMapping ("/delete/{id}")
    public String delete(@PathVariable Integer id){
        service.deleteArtist(id);
        return "redirect:pages/table";
    }

    @GetMapping("pages/rometoarabic")
    public String convert (@RequestParam(name="rome", required = false, defaultValue = "")String rome,
                           @RequestParam(name="arabic",required = false, defaultValue = "") String arabic, Model model) {
        model.addAttribute("rome",rome);
        model.addAttribute("arabic",arabic);
        return "pages/rometoarabic";
    }

}
