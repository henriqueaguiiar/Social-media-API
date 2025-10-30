package io.github.henriqueaguiiar.workshop_mongoDB.domain.services;


import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    Post findById(String id);
}
