package br.com.gianlucampos.workshopmongo.dto;

import br.com.gianlucampos.workshopmongo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserDTO implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

}
