package br.com.gianlucampos.workshopmongo.dto;

import br.com.gianlucampos.workshopmongo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class AuthorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;

    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
    }

}
