package br.com.gianlucampos.workshopmongo.config;

import br.com.gianlucampos.workshopmongo.domain.Post;
import br.com.gianlucampos.workshopmongo.domain.User;
import br.com.gianlucampos.workshopmongo.dto.AuthorDTO;
import br.com.gianlucampos.workshopmongo.dto.CommentDTO;
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
    public void run(String... args) {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(List.of(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.of(2018, 3, 21), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.of(2018, 3, 23), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", LocalDate.of(2018, 3, 21), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", LocalDate.of(2018, 3, 22), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.of(2018, 3, 23), new AuthorDTO(alex));

        post1.getComments().addAll(List.of(c1, c2));
        post2.getComments().add(c3);
        postRepository.saveAll(List.of(post1, post2));

        maria.getPosts().addAll(List.of(post1, post2));
        userRepository.save(maria);
    }
}
