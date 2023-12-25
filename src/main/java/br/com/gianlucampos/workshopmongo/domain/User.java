package br.com.gianlucampos.workshopmongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Document(collection = "user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String email;

    @NonNull
    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(String id, String name, @NonNull String email) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
