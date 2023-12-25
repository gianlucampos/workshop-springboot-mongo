package br.com.gianlucampos.workshopmongo.services;

import br.com.gianlucampos.workshopmongo.domain.Post;
import br.com.gianlucampos.workshopmongo.repository.PostRepository;
import br.com.gianlucampos.workshopmongo.services.exception.ObjectNotFoundException;
import br.com.gianlucampos.workshopmongo.utils.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, URL.convertToLocalDateViaInstant(minDate), URL.convertToLocalDateViaInstant(maxDate));
    }

}
