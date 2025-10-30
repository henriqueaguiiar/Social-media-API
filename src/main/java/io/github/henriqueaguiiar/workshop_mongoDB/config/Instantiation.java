package io.github.henriqueaguiiar.workshop_mongoDB.config;


import io.github.henriqueaguiiar.workshop_mongoDB.api.v1.resources.dto.AuthorDTO;
import io.github.henriqueaguiiar.workshop_mongoDB.api.v1.resources.dto.CommentDto;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.Post;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.User;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.repository.PostRepository;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Log4j
@Configuration
public class Instantiation implements CommandLineRunner {


    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(java.util.Arrays.asList(maria, alex, bob));
        log.info("Users seed savade in database MongoDB. " + Instant.now());

        postRepository.deleteAll();
        Post post1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(post1, post2));
        log.info("Posts seed savade in database MongoDB. " + Instant.now());

        CommentDto comment1 = new CommentDto("Boa viagem mano!", Instant.now(), new AuthorDTO(alex));
        CommentDto comment2 = new CommentDto("Aproveite", Instant.now(), new AuthorDTO(bob));
        CommentDto comment3 = new CommentDto("Tenha um ótimo dia!", Instant.now(), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().addAll(Arrays.asList(comment3));
        postRepository.saveAll(Arrays.asList(post1, post2));
        log.info("Comments added to posts. " + Instant.now());

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
        log.info("Posts added to user Maria Brown. " + Instant.now());
    }
}
