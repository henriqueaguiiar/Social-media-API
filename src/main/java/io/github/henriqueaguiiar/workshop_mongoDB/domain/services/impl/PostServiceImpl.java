package io.github.henriqueaguiiar.workshop_mongoDB.domain.services.impl;



import io.github.henriqueaguiiar.workshop_mongoDB.domain.repository.PostRepository;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.services.PostService;
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


}
