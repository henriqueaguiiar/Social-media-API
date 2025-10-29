package io.github.henriqueaguiiar.workshop_mongoDB.config;


import io.github.henriqueaguiiar.workshop_mongoDB.domain.entity.User;
import io.github.henriqueaguiiar.workshop_mongoDB.domain.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Log4j
@Configuration
public class Instantiation implements CommandLineRunner {


    private final UserRepository userRepository;

    @Autowired
    public Instantiation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(java.util.Arrays.asList(maria, alex, bob));
        log.info("Users seed savade in database.");
    }
}
