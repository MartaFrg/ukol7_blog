package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;

import java.sql.Date;
import java.time.LocalDate;
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
    public Page<Post> seznamPostu(Pageable pageable) {
        LocalDate now = LocalDate.now().plusDays(1); ;
        return postRepository.findByPublishedBeforeOrderByPublishedDesc(now, pageable);
    }
    /**
     * Vrací seznam jednoho postu podle slugu.
     */
    public Post singlePost(String slug) {
        return postRepository.findBySlug(slug);
    }
    /**
     * Ukládá do databáze.
     */
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

}
