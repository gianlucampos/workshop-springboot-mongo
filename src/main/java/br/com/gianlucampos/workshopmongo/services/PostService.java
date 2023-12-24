package br.com.gianlucampos.workshopmongo.services;

import br.com.gianlucampos.workshopmongo.domain.Post;
import br.com.gianlucampos.workshopmongo.repository.PostRepository;
import br.com.gianlucampos.workshopmongo.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
