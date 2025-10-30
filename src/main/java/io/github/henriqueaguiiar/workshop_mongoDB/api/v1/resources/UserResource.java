package io.github.henriqueaguiiar.workshop_mongoDB.api.v1.resources;


import io.github.henriqueaguiiar.workshop_mongoDB.domain.dto.UserDtoInput;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.dto.UserDtoOutput;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.User;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserServiceImpl userService;

    @Autowired
    public UserResource(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDtoOutput>> findAll() {
        List<User> users = userService.findAll();
        List<UserDtoOutput> userDtoOutputs = users
                .stream()
                .map(user -> new UserDtoOutput(user))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(userDtoOutputs);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDtoOutput> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDtoOutput(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDtoInput userDtoInput) {
        User user = userService.fromDTO(userDtoInput);
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDtoInput userDtoInput, @PathVariable String id) {
        User user = userService.fromDTO(userDtoInput);
        user.setId(id);
        user = userService.update(user);
        return  ResponseEntity.noContent().build();
    }

}
