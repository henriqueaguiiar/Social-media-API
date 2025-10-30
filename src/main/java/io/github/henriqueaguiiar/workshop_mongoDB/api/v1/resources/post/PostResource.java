package io.github.henriqueaguiiar.workshop_mongoDB.api.v1.resources.post;


import io.github.henriqueaguiiar.workshop_mongoDB.api.v1.resources.dto.UserDtoInput;
import io.github.henriqueaguiiar.workshop_mongoDB.api.v1.resources.dto.UserDtoOutput;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.Post;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.User;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.services.impl.PostServiceImpl;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    private final PostServiceImpl postService;

    @Autowired
    public PostResource(PostServiceImpl postService) {
        this.postService = postService;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }


}
