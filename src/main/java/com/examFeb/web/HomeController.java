package com.examFeb.web;

import com.examFeb.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final AlbumService albumService;

    public HomeController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String getIndexPage (HttpSession httpSession, Model model){

        if  (httpSession.getAttribute("user") == null){
            model.addAttribute("isLogged", false);
            return "index";
        }

        model.addAttribute("albums", albumService.findAllAlbums());
        model.addAttribute("totalCopies", albumService.getTotalCopies());
        if (albumService.findAllAlbums().size() == 0) {
            model.addAttribute("noCopies", true);
        }
        model.addAttribute("isLogged", true);

        return "home";
    }
}
