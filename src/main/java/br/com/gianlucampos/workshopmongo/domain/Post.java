package br.com.gianlucampos.workshopmongo.domain;

import br.com.gianlucampos.workshopmongo.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@Document(collection = "post")
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private LocalDate date;
    private String title;
    private String body;
    private AuthorDTO author;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
