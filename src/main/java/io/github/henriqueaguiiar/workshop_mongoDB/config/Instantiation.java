package io.github.henriqueaguiiar.workshop_mongoDB.config;


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

        Post post1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje!", maria);
        postRepository.saveAll(Arrays.asList(post1, post2));
        log.info("Posts seed savade in database MongoDB. " + Instant.now());
    }
}
