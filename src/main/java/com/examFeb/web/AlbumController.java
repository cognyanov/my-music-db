package com.examFeb.web;

import com.examFeb.binding.AlbumBindingModel;
import com.examFeb.model.service.AlbumServiceModel;
import com.examFeb.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addProductForm(HttpSession httpSession, Model model) {
        if (!model.containsAttribute("albumBindingModel")) {
            model.addAttribute("albumBindingModel", new AlbumBindingModel());
        }
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        return "add-album";
    }

    @PostMapping("/add")
    public String addAlbum(@Valid AlbumBindingModel albumBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumBindingModel", albumBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumBindingModel", bindingResult);

            return "redirect:add";
        }


        albumService.addAlbum(modelMapper.map(albumBindingModel, AlbumServiceModel.class));


        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteByID(@PathVariable Long id) {
    albumService.deleteById(id);
    return "redirect:/";
    }
}
