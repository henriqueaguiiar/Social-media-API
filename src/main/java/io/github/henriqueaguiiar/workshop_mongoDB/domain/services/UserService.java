package io.github.henriqueaguiiar.workshop_mongoDB.domain.services;


import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();

    User findById(String id);

    User insert(User user);

    void delete(String id);

}
