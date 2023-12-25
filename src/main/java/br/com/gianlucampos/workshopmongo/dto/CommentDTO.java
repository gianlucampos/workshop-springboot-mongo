package br.com.gianlucampos.workshopmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String text;
    private LocalDate date;
    private AuthorDTO author;

}