package br.com.gianlucampos.workshopmongo.services;

import br.com.gianlucampos.workshopmongo.domain.User;
import br.com.gianlucampos.workshopmongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}
