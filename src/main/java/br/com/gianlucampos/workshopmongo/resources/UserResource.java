package br.com.gianlucampos.workshopmongo.resources;

import br.com.gianlucampos.workshopmongo.domain.User;
import br.com.gianlucampos.workshopmongo.dto.UserDTO;
import br.com.gianlucampos.workshopmongo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserResource {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findAll(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok(new UserDTO(obj));
    }

}
