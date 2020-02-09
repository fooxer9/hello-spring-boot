package com.fooxer.orm.springorm;


import com.fooxer.httpserver.RomeToArabic;
import com.fooxer.orm.springorm.entities.Artist;
import com.fooxer.orm.springorm.services.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    private ArtService service;

    @Autowired
    public void setArtService(ArtService service) {
        this.service = service;
    }
    @PostMapping("/update")
    public String updateArtist(@RequestParam Integer art_id, @RequestParam String art_fullName, @RequestParam String art_link, @RequestParam String art_genre) {
        service.updateArtist(art_id, art_fullName, art_link, art_genre);
        return "redirect:pages/table";
    }

    @PostMapping("/save")
    public String saveNewArtist(@RequestParam String art_fullName, @RequestParam String art_link, @RequestParam String art_genre) {
        service.saveArtist(new Artist(art_fullName,art_link,art_genre));
        return "redirect:pages/table";
    }

    @PostMapping("/convert")
    public String convertRome (@RequestParam String rome) {
        String arabic;
        try {
            arabic = new RomeToArabic(rome).getResult().toString(); }
        catch (Exception e) {
            arabic = "INPUT_ERROR_NOT_A_ROMAN_SYMBOL";
        }
        return "redirect:pages/rometoarabic?rome="+rome+"&arabic="+arabic;
    }

}

