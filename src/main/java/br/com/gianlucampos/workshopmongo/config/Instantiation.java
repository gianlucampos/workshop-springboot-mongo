package br.com.gianlucampos.workshopmongo.config;

import br.com.gianlucampos.workshopmongo.domain.Post;
import br.com.gianlucampos.workshopmongo.domain.User;
import br.com.gianlucampos.workshopmongo.repository.PostRepository;
import br.com.gianlucampos.workshopmongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, LocalDate.of(2018, 3, 21), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, LocalDate.of(2018, 3, 21), "Bom dia", "Acordei feliz hoje!", maria);

        userRepository.saveAll(List.of(maria, alex, bob));
        postRepository.saveAll(List.of(post1, post2));
    }
}
