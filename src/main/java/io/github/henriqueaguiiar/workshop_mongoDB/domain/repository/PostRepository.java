package io.github.henriqueaguiiar.workshop_mongoDB.domain.repository;

import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
