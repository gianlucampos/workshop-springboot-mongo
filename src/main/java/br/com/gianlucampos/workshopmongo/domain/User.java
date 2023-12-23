package br.com.gianlucampos.workshopmongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
public class User implements Serializable {

    private String id;
    private String name;
    private String email;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
