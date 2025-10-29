package io.github.henriqueaguiiar.workshop_mongoDB.domain.repository;

import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
