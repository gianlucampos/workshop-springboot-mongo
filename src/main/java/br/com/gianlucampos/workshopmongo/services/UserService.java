package br.com.gianlucampos.workshopmongo.services;

import br.com.gianlucampos.workshopmongo.domain.User;
import br.com.gianlucampos.workshopmongo.repository.UserRepository;
import br.com.gianlucampos.workshopmongo.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
