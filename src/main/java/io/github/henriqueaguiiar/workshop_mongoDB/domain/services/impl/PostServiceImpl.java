package io.github.henriqueaguiiar.workshop_mongoDB.domain.services.impl;



import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.Post;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.repository.PostRepository;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.services.PostService;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {

        this.postRepository = postRepository;
    }


    @Override
    public Post findById(String id) {
        Post post = postRepository.findById(id).orElse(null);
        if(post == null) {
            throw new ObjectNotFoundException("Post not found");
        }
        return post;
    }

    @Override
    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
