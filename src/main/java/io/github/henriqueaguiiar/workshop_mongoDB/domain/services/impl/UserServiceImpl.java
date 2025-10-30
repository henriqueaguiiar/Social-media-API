package io.github.henriqueaguiiar.workshop_mongoDB.domain.services.impl;


import io.github.henriqueaguiiar.workshop_mongoDB.domain.dto.UserDtoInput;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.dto.UserDtoOutput;
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

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }
    @Override
    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDtoInput userDtoInput) {
      return new User(userDtoInput.getId(), userDtoInput.getName(), userDtoInput.getEmail());
    }


}
