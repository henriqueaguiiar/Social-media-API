package io.github.henriqueaguiiar.workshop_mongoDB.domain.services.impl;


import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.User;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.repository.UserRepository;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.services.UserService;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null) {
            throw new ObjectNotFoundException("User not found");
        }
        return user;
    }
}
