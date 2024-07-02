package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import cz.czechitas.java2webapps.ukol7.service.PostService;

import java.util.List;

@Controller
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }
    @RequestMapping("/")
    @GetMapping("")
    public ModelAndView index(@RequestParam(required=false,defaultValue = "0")int page){
        PageRequest pageable = PageRequest.of(page, 20);
        Page<Post> listOfPosts = service.seznamPostu(pageable);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("ListOfPosts",listOfPosts );
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("")
    public Object form(@ModelAttribute("post") Post post) {

        //if (bindingResult.hasErrors()) {
        //  return "/";
        //}
        return "/index";//OPRAVIT, UPRAVIT
    }

    @GetMapping("/post/{slug}")
    public ModelAndView detail(@PathVariable String slug){
        Post singlePost = service.singlePost(slug);
        return new ModelAndView("detail").addObject("singlePost",singlePost);
    }

}
