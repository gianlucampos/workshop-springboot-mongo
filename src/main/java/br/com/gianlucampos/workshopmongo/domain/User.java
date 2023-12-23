package br.com.gianlucampos.workshopmongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@Document(collection = "user")
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
