package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import cz.czechitas.java2webapps.ukol7.service.PostService;

import java.util.List;

@Controller
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }
    @GetMapping("/")
    public ModelAndView index(){//(@PageableDefault(Pageable pageable) {
        PageRequest pageable = PageRequest.of(0, 20);
        Page<Post> listOfPosts = service.seznamPostu(pageable);
        return new ModelAndView("index").addObject("ListOfPosts",listOfPosts );
    }

    @GetMapping("/{slug}")
    public ModelAndView detail(@PathVariable String slug){
        Post singlePost = service.singlePost(slug);
        return new ModelAndView("detail").addObject("singlePost",singlePost);
    }
}
