package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Vrací seznam všech postů v databázi.
     */
    public List<Post> seznamPostu() {
        return postRepository.findAll();
    }
    /**
     * Vrací seznam jednoho postu podle slugu.
     */
    public Post singlePost(String slug) {
        return postRepository.findBySlug(slug);
    }
}
